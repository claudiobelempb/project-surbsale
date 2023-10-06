package br.com.surb.sale.modules.category.dto;

import br.com.surb.sale.shared.AppEnums.StatusEnums;

import java.io.Serializable;
import java.time.Instant;

public class CategoryDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long categoryId;
  private String code;
  private String name;
  private StatusEnums status;
  private Instant createdAt;
  private Instant updatedAt;

  public CategoryDTO() {
  }

  public CategoryDTO(Long categoryId, String code, String name, StatusEnums status, Instant createdAt, Instant updatedAt) {
    this.categoryId = categoryId;
    this.code = code;
    this.name = name;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
