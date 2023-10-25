package br.com.surb.sales.modules.user.services;

import br.com.surb.sales.modules.user.infra.entities.User;
import br.com.surb.sales.modules.user.infra.repositories.UserRepository;
import br.com.surb.sales.shared.AppConstants.AppExceptionConstants;
import br.com.surb.sales.shared.AppExeptions.AppExeptionsService.AppForbiddenException;
import br.com.surb.sales.shared.AppExeptions.AppExeptionsService.AppUnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserAuthService {

  @Autowired
  private UserRepository userRepository;

  @Transactional(readOnly = true)
  public User authenticated(){
    try{
      String username = SecurityContextHolder.getContext().getAuthentication().getName();
      User user = userRepository.findByEmail(username);

      return user;
    }catch (Exception e) {
      throw new AppUnauthorizedException(AppExceptionConstants.INVALID_USER);
    }
  }

  @Transactional(readOnly = true)
  public void validateSelfOrAdmin(Long userId){
    User user = authenticated();
    if(!user.getUserId().equals(userId) && !user.hasRole("ROLE_ADMIN")){
      throw new AppForbiddenException(AppExceptionConstants.ACCESS_DENIED);
    }
  }

  @Transactional(readOnly = true)
  public void validateSelfOrMaster(Long userId){
    User user = authenticated();
    if(!user.getUserId().equals(userId) && !user.hasRole("ROLE_MASTER")){
      throw new AppForbiddenException(AppExceptionConstants.ACCESS_DENIED);
    }
  }

  @Transactional(readOnly = true)
  public void validateSelfOrMasterOrAdmin(Long userId){
    User user = authenticated();
    if(!user.getUserId().equals(userId) && !user.hasRole("ROLE_MASTER") && !user.hasRole("ROLE_ADMIN")){
      throw new AppForbiddenException(AppExceptionConstants.ACCESS_DENIED);
    }
  }
}
