package br.com.surb.sales.modules.role.dto;

import br.com.surb.sales.modules.role.infra.entities.Role;
import br.com.surb.sales.shared.AppEnums.StatusEnums;

import java.time.Instant;


public class RoleDTO {

  private Long roleId;
  private String code;
  private String authority;
  private StatusEnums status;
  private Instant createdAt;
  private Instant updatedAt;

  public RoleDTO(){}

  public RoleDTO(Long roleId, String code, String authority, StatusEnums status, Instant createdAt, Instant updatedAt) {
    this.roleId = roleId;
    this.code = code;
    this.authority = authority;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public RoleDTO(Role entity){
    roleId = entity.getRoleId();
    code = entity.getCode();
    authority = entity.getAuthority();
    status = entity.getStatus();
    createdAt = entity.getCreatedAt();
    updatedAt = getUpdatedAt();
  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

  public StatusEnums getStatus() {
    return status;
  }

  public void setStatus(StatusEnums status) {
    this.status = status;
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
}
