package br.com.surb.sales.shared.AppComponent;

import br.com.surb.sales.modules.user.infra.entities.User;
import br.com.surb.sales.modules.user.infra.repositories.UserRepository;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AppJwtTokenEnhancer implements TokenEnhancer {

  private UserRepository userRepository;

  public AppJwtTokenEnhancer(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @Override
  public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
    User user = userRepository.findByEmail(authentication.getName());

    Map<String, Object> addInfoToken = new HashMap<>();
    addInfoToken.put("userId", user.getUserId());
    addInfoToken.put("userFistName", user.getFirstName());
    addInfoToken.put("userLastname", user.getLastName());

    DefaultOAuth2AccessToken inforTokenUser = (DefaultOAuth2AccessToken) accessToken;
    inforTokenUser.setAdditionalInformation(addInfoToken);
    return accessToken;
  }
}