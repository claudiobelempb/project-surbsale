package br.com.surb.sales.modules.user.mapper;

import br.com.surb.sales.modules.role.dto.RoleDTO;
import br.com.surb.sales.modules.role.infra.entities.Role;
import br.com.surb.sales.modules.role.infra.repositories.RoleRepository;
import br.com.surb.sales.modules.user.dto.UserDTO;
import br.com.surb.sales.modules.user.infra.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  private static RoleRepository roleRepository;

  public UserMapper(RoleRepository roleRepository){
    this.roleRepository = roleRepository;
  }

  public static void copyToDto(User entity, UserDTO dto) {
    entity.setFirstName(dto.getFirstName());
    entity.setLastName(dto.getLastName());
    entity.setEmail(dto.getEmail());
    entity.setBirth(dto.getBirth());

    entity.getRoles().clear();
    for (RoleDTO i : dto.getRoles()){
      Role role = roleRepository.getById(i.getRoleId());
      entity.getRoles().add(role);
    }
  }

}
