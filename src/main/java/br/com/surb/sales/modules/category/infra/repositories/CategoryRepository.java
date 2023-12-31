package br.com.surb.sales.modules.category.infra.repositories;

import br.com.surb.sales.modules.category.infra.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
