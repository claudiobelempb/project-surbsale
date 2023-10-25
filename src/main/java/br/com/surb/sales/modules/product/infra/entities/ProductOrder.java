package br.com.surb.sales.modules.product.infra.entities;

import br.com.surb.sales.modules.client.infra.entities.Client;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_product_order")
public class ProductOrder {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderId;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client client;

  private LocalDate createdAt;

  @Column(length = 20, precision = 2)
  private BigDecimal amount;

}
