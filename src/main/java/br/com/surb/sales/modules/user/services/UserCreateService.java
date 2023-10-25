package br.com.surb.sales.modules.user.services;

import br.com.surb.sales.modules.user.dto.UserCreateDTO;
import br.com.surb.sales.modules.user.dto.UserDTO;
import br.com.surb.sales.modules.user.infra.entities.User;
import br.com.surb.sales.modules.user.infra.repositories.UserRepository;
import br.com.surb.sales.modules.user.mapper.UserMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserCreateService {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder passwordEncoder;

  public UserCreateService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Transactional
  public UserDTO execute(UserCreateDTO dto) {
    User entity = new User();
    UserMapper.copyToDto(entity, dto);
    entity.setPassword(passwordEncoder.encode(dto.getPassword()));
    entity = userRepository.save(entity);
    return new UserDTO(entity);
  }

}
