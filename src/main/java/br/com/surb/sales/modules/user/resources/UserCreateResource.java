package br.com.surb.sales.modules.user.resources;

import br.com.surb.sales.modules.user.dto.UserCreateDTO;
import br.com.surb.sales.modules.user.dto.UserDTO;
import br.com.surb.sales.modules.user.services.UserCreateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/users")
public class UserCreateResource {

  private final UserCreateService userCreateService;

  public UserCreateResource(UserCreateService userCreateService) {
    this.userCreateService = userCreateService;
  }

  @PostMapping
  public ResponseEntity<UserDTO> handle(@Valid @RequestBody UserCreateDTO dto){
    UserDTO userDTO = userCreateService.execute(dto);
    URI uri = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(userDTO.getUserId())
      .toUri();
    return ResponseEntity.created(uri).body(userDTO);
  }

}
