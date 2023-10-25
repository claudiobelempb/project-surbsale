package br.com.surb.sales.modules.category.service;

import br.com.surb.sales.modules.category.infra.entities.Category;
import br.com.surb.sales.modules.category.infra.repositories.CategoryRepository;
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
