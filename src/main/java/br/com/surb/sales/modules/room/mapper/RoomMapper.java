package br.com.surb.sales.modules.room.mapper;


import br.com.surb.sales.modules.room.infra.entities.Room;
import br.com.surb.sales.api.model.RoomDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public abstract class RoomMapper {
  public abstract RoomDTO fromEntityToDto(Room room);
}
