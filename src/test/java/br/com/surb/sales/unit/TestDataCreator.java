package br.com.surb.sales.unit;

import static br.com.surb.sales.unit.TestConstants.*;
import br.com.surb.sales.modules.room.infra.entities.Room;

public final class TestDataCreator {
  private TestDataCreator(){}

  public static Room.Builder newRoomBuilder(){
    return Room.newBuilder().name(DEFAULT_ROOM_NAME).seats(DEFAULT_ROOM_SEATS);
  }
}
