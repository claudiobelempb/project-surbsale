package br.com.surb.sale.modules.product.infra.entities;

import br.com.surb.sale.modules.client.infra.entities.Client;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ProductItemOrder {
  private UUID itemId;
  private Client client;
  private LocalDate createdAt;
  private BigDecimal amount;
}
