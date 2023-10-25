package br.com.surb.sales.modules.user.dto;

import br.com.surb.sales.modules.role.dto.RoleDTO;
import br.com.surb.sales.modules.user.infra.entities.User;
import br.com.surb.sales.shared.AppConstants.AppValidatorConstants;
import br.com.surb.sales.shared.AppEnums.StatusEnums;


import javax.validation.constraints.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class UserDTO {
  private Long userId;
  private String code;

  @NotBlank(message = AppValidatorConstants.REQUIRED_FIELD)
  private String firstName;

  @NotBlank(message = AppValidatorConstants.REQUIRED_FIELD)
  private String lastName;

  private String birth;

  @Email(message = AppValidatorConstants.REQUIRED_EMAIL)
  @NotBlank(message = AppValidatorConstants.REQUIRED_FIELD)
  private String email;

  private Instant createdAt;

  private Instant updatedAt;

  private StatusEnums status;

  private final Set<RoleDTO> roles = new HashSet<>();

  public UserDTO() {
  }

  public UserDTO(Long userId, String code, String firstName, String lastName, String birth, String email, Instant createdAt, Instant updatedAt, StatusEnums status) {
    this.userId = userId;
    this.code = code;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birth = birth;
    this.email = email;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.status = status;
  }

  public UserDTO(User entity){
    userId = entity.getUserId();
    code = entity.getCode();
    firstName = entity.getFirstName();
    lastName = entity.getLastName();
    birth = entity.getBirth();
    email = entity.getEmail();
    status = entity.getStatus();
    createdAt = entity.getCreatedAt();
    updatedAt = entity.getUpdatedAt();
    entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getBirth() {
    return birth;
  }

  public void setBirth(String birth) {
    this.birth = birth;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Set<RoleDTO> getRoles() {
    return roles;
  }
}
