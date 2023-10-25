package br.com.surb.sales.modules.product.infra.entities;


import br.com.surb.sales.shared.AppEnums.StatusEnums;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long productId;
  private String code;
  private String description;
  private BigDecimal price;
  private StatusEnums status;
  private Instant createdAt;
  private Instant updatedAt;

  public Product() {
  }

  public Product(Long productId, String description, BigDecimal price, StatusEnums status, Instant createdAt, Instant updatedAt) {
    this.productId = productId;
    this.description = description;
    this.price = price;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
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
    this.createdAt = Instant.now();
    this.status = StatusEnums.ENABLED;
  }

  @PreUpdate
  public void preUpdate() {
    updatedAt = Instant.now();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Product product = (Product) o;

    if (!Objects.equals(productId, product.productId)) return false;
    return Objects.equals(description, product.description);
  }

  @Override
  public int hashCode() {
    int result = productId != null ? productId.hashCode() : 0;
    result = 31 * result + (description != null ? description.hashCode() : 0);
    return result;
  }
}
