package br.com.surb.sale.shared.Appconfig;

import br.com.surb.sale.modules.user.services.UserDetailsService;
import br.com.surb.sale.shared.AppComponent.AppJwtTokenEnhancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
@EnableAuthorizationServer
public class AppAuthorizationServerConfigurerAdapter extends AuthorizationServerConfigurerAdapter {

  @Value("${spring.security.oauth2.client.registration.uaa.clientId}")
  private String clientId;

  @Value("${spring.security.oauth2.client.registration.uaa.clientSecret}")
  private String clientSecret;

  @Value("${spring.security.oauth2.client.registration.jwtDuration}")
  private Integer jwtDuration;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;
  @Autowired
  private JwtAccessTokenConverter accessTokenConverter;
  @Autowired
  private JwtTokenStore tokenStore;
  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private AppJwtTokenEnhancer tokenEnhancer;
  @Autowired
  private UserDetailsService appUserDetailsService;

  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
  }

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.inMemory()
      .withClient(clientId)
      .secret(passwordEncoder.encode(clientSecret))
      .scopes("read", "write")
      .authorizedGrantTypes("password", "refresh_token")
      .accessTokenValiditySeconds(jwtDuration)
      .refreshTokenValiditySeconds(jwtDuration);
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

    TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
    enhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter, tokenEnhancer));

    endpoints.authenticationManager(authenticationManager)
      .tokenStore(tokenStore)
      .accessTokenConverter(accessTokenConverter)
      .tokenEnhancer(enhancerChain)
      .userDetailsService(appUserDetailsService);
  }
}