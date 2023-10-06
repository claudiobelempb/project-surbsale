package br.com.surb.sale.shared.Appconfig;

import br.com.surb.sale.modules.user.services.UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

  private final BCryptPasswordEncoder passwordEncoder;
  private final UserDetailsService appUserDetailsService;
  private final Environment environment;

  public AppWebSecurityConfigurerAdapter(BCryptPasswordEncoder passwordEncoder, UserDetailsService appUserDetailsService, Environment environment) {
    this.passwordEncoder = passwordEncoder;
    this.appUserDetailsService = appUserDetailsService;
    this.environment = environment;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder);
  }

  @Override
  public void configure(WebSecurity webSecurity) throws Exception {
    webSecurity.ignoring().antMatchers("/actuator/**");
  }

  /*@Override
  public void configure(HttpSecurity httpSecurity) throws Exception {

    if(Arrays.asList(environment.getActiveProfiles()).contains("test")){
      httpSecurity.headers().frameOptions().disable();
    }

    httpSecurity.csrf().disable();
    httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    httpSecurity.authorizeRequests().antMatchers("/roles").hasAnyAuthority("ROLE_MASTER");
    httpSecurity.authorizeRequests().antMatchers(HttpMethod.GET, "/users").hasAnyAuthority("ROLE_MASTER", "ROLE_ADMIN",
      "ROLE_USER");
    httpSecurity.authorizeRequests().antMatchers(HttpMethod.POST,"/users").hasAnyAuthority("ROLE_MASTER", "ROLE_ADMIN");
    httpSecurity.authorizeRequests().anyRequest().authenticated();

    AppAuthenticationFilter appAuthenticationFilter = new AppAuthenticationFilter(super.authenticationManagerBean());
    appAuthenticationFilter.setFilterProcessesUrl("/auth0/token");

    httpSecurity.addFilter(appAuthenticationFilter);
  }*/

  @Override
  @Bean
  protected AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }
}