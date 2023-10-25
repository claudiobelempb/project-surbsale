package br.com.surb.sales.modules.user.dto;

import br.com.surb.sales.modules.user.infra.entities.User;
import br.com.surb.sales.modules.user.validation.UserCreateValid;
import br.com.surb.sales.shared.AppEnums.StatusEnums;

import java.time.Instant;

@UserCreateValid
public class UserCreateDTO extends UserDTO {
  private String password;

  public UserCreateDTO() {

  }

  public UserCreateDTO(Long userId, String code, String firstName, String lastName, String birth, String email, Instant createdAt, Instant updatedAt, StatusEnums status, String password) {
    super(userId, code, firstName, lastName, birth, email, createdAt, updatedAt, status);
    this.password = password;
  }

  public UserCreateDTO(User entity, String password) {
    super(entity);
    this.password = password;
  }

  public UserCreateDTO(User entity) {
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
