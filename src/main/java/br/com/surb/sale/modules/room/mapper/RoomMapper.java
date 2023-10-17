package br.com.surb.sale.modules.room.mapper;

import br.com.surb.sale.api.model.RoomDTO;
import br.com.surb.sale.modules.room.infra.entities.Room;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public abstract class RoomMapper {
  public abstract RoomDTO fromEntityToDto(Room room);
}
