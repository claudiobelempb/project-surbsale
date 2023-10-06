package br.com.surb.sale.modules.category.service;

import br.com.surb.sale.modules.category.infra.entities.Category;
import br.com.surb.sale.modules.category.infra.repositories.CategoryRepository;
import br.com.surb.sale.modules.user.dto.UserCreateDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryFindAllService {

  private final CategoryRepository categoryRepository;

  public CategoryFindAllService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Transactional(readOnly = true)
  public List<Category> execute() {
    return categoryRepository.findAll();
  }

}
