package br.com.surb.sale.modules.category.resource;

import br.com.surb.sale.modules.category.dto.CategoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoryFindByIdResource {

  /*@GetMapping
  public ResponseEntity<CategoryDTO> handle(@RequestBody CategoryDTO dto){
   return null;
  }*/
}
