package br.com.surb.sale.shared.Appconfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class AppResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {
  @Autowired
  private Environment environment;

  private static final String[] PUBLIC = {
    "/oauth/token",
    "/h2-console/**",
    "/v3/api-docs/**",
    "/swagger-ui/**",
    "/v2/api-docs/**",
    "/swagger-resources/**"
  };

  private static final String[] PUBLIC_GET = {
    "/products/**",
    "/categories/**"
  };

  private static final String[] PUBLIC_POST = {
    "/products/**",
    "/categories/**"
  };

  private static final String[] PUBLIC_DELETE = {
    "/products/**",
    "/categories/**"
  };

  private static final String[] PUBLIC_PUT = {
    "/products/**",
    "/categories/**"
  };

  private static final String[] PUBLIC_PATCH = {
    "/products/**",
    "/categories/**"
  };

  private static final String[] PRIVATE = {
    "/users/**"
  };



  @Autowired
  private JwtTokenStore jwtTokenStore;

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
    resources.tokenStore(jwtTokenStore);
  }

  @Override
  public void configure(HttpSecurity httpSecurity) throws Exception {

    // H2
    if(Arrays.asList(environment.getActiveProfiles()).contains("test")){
      httpSecurity.headers().frameOptions().disable();
    }

    httpSecurity.csrf().disable();
    httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    httpSecurity.authorizeRequests().antMatchers(PUBLIC).permitAll();
    /*httpSecurity.authorizeRequests().antMatchers(HttpMethod.GET, PUBLIC_GET).permitAll();
    httpSecurity.authorizeRequests().antMatchers(HttpMethod.POST, PUBLIC_POST).hasAnyRole("ADMIN", "MASTER");
    httpSecurity.authorizeRequests().antMatchers(HttpMethod.DELETE, PUBLIC_DELETE).hasAnyRole("ADMIN", "MASTER");
    httpSecurity.authorizeRequests().antMatchers(HttpMethod.PUT, PUBLIC_PUT).hasAnyRole("ADMIN", "MASTER");
    httpSecurity.authorizeRequests().antMatchers(HttpMethod.PATCH, PUBLIC_PATCH).hasAnyRole("ADMIN", "MASTER");
    httpSecurity.authorizeRequests().antMatchers(PRIVATE).hasRole("MASTER");*/
    httpSecurity.authorizeRequests().anyRequest().authenticated();


  }
}