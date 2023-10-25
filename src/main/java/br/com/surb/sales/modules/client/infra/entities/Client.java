package br.com.surb.sales.modules.client.infra.entities;

import br.com.surb.sales.modules.product.infra.entities.ProductOrder;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_client")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long clientId;
  private String name;

  @OneToMany(mappedBy = "client")
  private Set<ProductOrder> productOrders;

  public Client(){}

  public Client(Long clientId, String name) {
    this.clientId = clientId;
    this.name = name;
  }

  public Long getClientId() {
    return clientId;
  }

  public void setClientId(Long clientId) {
    this.clientId = clientId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<ProductOrder> getProductOrders() {
    return productOrders;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Client client = (Client) o;

    return Objects.equals(clientId, client.clientId);
  }

  @Override
  public int hashCode() {
    return clientId != null ? clientId.hashCode() : 0;
  }
}
