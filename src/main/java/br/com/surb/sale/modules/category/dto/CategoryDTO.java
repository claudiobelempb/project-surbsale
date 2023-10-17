package br.com.surb.sale.modules.category.dto;

import br.com.surb.sale.shared.AppEnums.StatusEnums;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public class CategoryDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private UUID categoryId;
  private String name;
  private StatusEnums status;
  private Instant createdAt;
  private Instant updatedAt;

  public CategoryDTO() {
  }

  public CategoryDTO(UUID categoryId, String name, StatusEnums status, Instant createdAt,
                     Instant updatedAt) {
    this.categoryId = categoryId;
    this.name = name;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public UUID getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(UUID categoryId) {
    this.categoryId = categoryId;
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
