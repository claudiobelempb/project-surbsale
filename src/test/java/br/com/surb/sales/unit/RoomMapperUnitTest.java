package br.com.surb.sales.unit;

import static br.com.surb.sales.unit.TestConstants.DEFAULT_ROOM_ID;
import br.com.surb.sales.api.model.RoomDTO;
import br.com.surb.sales.modules.room.infra.entities.Room;
import br.com.surb.sales.modules.room.mapper.RoomMapper;
import br.com.surb.sales.core.BaseUnitTest;
import br.com.surb.sales.ultis.MapperUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoomMapperUnitTest extends BaseUnitTest {
  private RoomMapper victim;

  @BeforeEach
  void setupEach(){
    victim = MapperUtils.roomMapper();
  }

  @Test
  void testFromEntityToDto(){
    Room room = TestDataCreator.newRoomBuilder().roomId(DEFAULT_ROOM_ID).build();
    RoomDTO dto = victim.fromEntityToDto(room);

    Assertions.assertEquals(room.getRoomId(), dto.getRoomId());
    Assertions.assertEquals(room.getName(), dto.getName());
    Assertions.assertEquals(room.getSeats(), dto.getSeats());

  }
}
