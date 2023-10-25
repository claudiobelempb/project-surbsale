package br.com.surb.sales.unit;

import static br.com.surb.sales.unit.TestConstants.DEFAULT_ROOM_ID;
import br.com.surb.sales.api.model.RoomDTO;
import br.com.surb.sales.modules.room.infra.entities.Room;
import br.com.surb.sales.modules.room.infra.repositories.RoomRepository;
import br.com.surb.sales.modules.room.services.RoomFindByIdService;
import br.com.surb.sales.core.BaseUnitTest;
import br.com.surb.sales.ultis.MapperUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.Optional;

public class RoomFindByIdServiceUnitTest extends BaseUnitTest {
  private RoomFindByIdService victim;

  @Mock
  private RoomRepository roomRepository;

  @BeforeEach
  void setupEach(){
    victim = new RoomFindByIdService(roomRepository, MapperUtils.roomMapper());
  }

  @Test
  void testExecute(){

    Room room = TestDataCreator.newRoomBuilder().roomId(DEFAULT_ROOM_ID).build();
    Mockito.when(roomRepository.findById(DEFAULT_ROOM_ID)).thenReturn(Optional.of(room));
    RoomDTO dto = victim.execute(DEFAULT_ROOM_ID);

    Assertions.assertEquals(room.getRoomId(), dto.getRoomId());
    Assertions.assertEquals(room.getName(), dto.getName());
    Assertions.assertEquals(room.getSeats(), dto.getSeats());

  }
}
