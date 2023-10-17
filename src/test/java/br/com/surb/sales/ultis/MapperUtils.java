package br.com.surb.sales.ultis;

import br.com.surb.sale.modules.room.mapper.RoomMapper;
import org.mapstruct.factory.Mappers;

public final class MapperUtils {

  private MapperUtils(){}

  public static RoomMapper roomMapper(){
    return Mappers.getMapper(RoomMapper.class);
  }
}
