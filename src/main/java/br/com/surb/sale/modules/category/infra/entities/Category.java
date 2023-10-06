package br.com.surb.sale.modules.category.infra.entities;

import br.com.surb.sale.shared.AppEnums.StatusEnums;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long categoryId;
  private String code;
  private String name;
  @Enumerated(EnumType.STRING)
  private StatusEnums status;
  private Instant createdAt;
  private Instant updatedAt;

  public Category() {
  }

  public Category(Long categoryId, String code, String name, StatusEnums status, Instant createdAt, Instant updatedAt) {
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

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  @PrePersist
  public void prePersist() {
    this.code = UUID.randomUUID().toString();
    this.status = StatusEnums.ENABLED;
    this.createdAt = Instant.now();
  }

  @PreUpdate
  public void preUpdate() {
    updatedAt = Instant.now();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Category category = (Category) o;

    if (!Objects.equals(categoryId, category.categoryId)) return false;
    return Objects.equals(code, category.code);
  }

  @Override
  public int hashCode() {
    int result = categoryId != null ? categoryId.hashCode() : 0;
    result = 31 * result + (code != null ? code.hashCode() : 0);
    return result;
  }
}
