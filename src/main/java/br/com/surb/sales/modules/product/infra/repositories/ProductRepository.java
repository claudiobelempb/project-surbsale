package br.com.surb.sales.modules.product.infra.repositories;

import br.com.surb.sales.modules.product.infra.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
