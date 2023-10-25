package br.com.surb.sales.modules.category.resource;

import br.com.surb.sales.modules.category.infra.entities.Category;
import br.com.surb.sales.modules.category.service.CategoryFindAllService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryFindAllResource {

  private final CategoryFindAllService categoryFindAllService;

  public CategoryFindAllResource(CategoryFindAllService categoryFindAllService) {
    this.categoryFindAllService = categoryFindAllService;
  }


  @GetMapping
  public ResponseEntity<List<Category>> handle(){
    List<Category> categories = categoryFindAllService.execute();
    return ResponseEntity.ok().body(categories);
  }
}
