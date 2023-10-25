package br.com.surb.sales.modules.client.dto.mapper;

import br.com.surb.sales.modules.client.dto.ClientDTO;
import br.com.surb.sales.modules.client.infra.entities.Client;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class ClientMapper {

  public static ClientDTO toCreateDTO(Client entity) {
    ClientDTO dto = new ClientDTO();
    dto.setName(entity.getName());
    return dto;
  }

  public static ClientDTO toUpdateDTO(Client entity) {
    ClientDTO dto = new ClientDTO();
    dto.setName(entity.getName());
    return dto;
  }
}
