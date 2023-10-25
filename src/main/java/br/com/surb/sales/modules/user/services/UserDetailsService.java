package br.com.surb.sales.modules.user.services;

import br.com.surb.sales.modules.role.infra.entities.Role;
import br.com.surb.sales.modules.role.infra.repositories.RoleRepository;
import br.com.surb.sales.modules.user.infra.entities.User;
import br.com.surb.sales.modules.user.infra.repositories.UserRepository;
import br.com.surb.sales.shared.AppConstants.AppExceptionConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  private static final Logger logger = LoggerFactory.getLogger(UserDetailsService.class);

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(username);

    List<SimpleGrantedAuthority> authorities = new ArrayList<>();

    for(Role roleModel: user.getRoles()){
      authorities.add(new SimpleGrantedAuthority(roleModel.getAuthority()));
    }

    if (user == null) {
      logger.error(AppExceptionConstants.USER_NOT_FOUND + username);
      throw new UsernameNotFoundException(AppExceptionConstants.EMAIL_NOT_FOUND + username);
    }

    logger.info(AppExceptionConstants.USER_FOUND + username);
    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
  }

  public void addRoleToUser(String email, String authority){
    User userModel = userRepository.findByEmail(email);
    Role roleModel = roleRepository.findByAuthority(authority).orElseThrow();

    userModel.getRoles().add(roleModel);
    userRepository.save(userModel);
  }
}
