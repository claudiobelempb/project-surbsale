package br.com.surb.sale.modules.room.services;

import br.com.surb.sale.api.model.RoomDTO;
import br.com.surb.sale.modules.room.infra.entities.Room;
import br.com.surb.sale.modules.room.infra.repositories.RoomRepository;
import br.com.surb.sale.modules.room.mapper.RoomMapper;
import br.com.surb.sale.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
public class RoomFindByIdService {

  private final RoomRepository roomRepository;
  private final RoomMapper roomMapper;

  public RoomFindByIdService(RoomRepository roomRepository, RoomMapper roomMapper) {
    this.roomRepository = roomRepository;
    this.roomMapper = roomMapper;
  }

  public RoomDTO execute(Long roomId){
    Objects.requireNonNull(roomId);
    Room room = roomRepository.findById(roomId).orElseThrow(() -> new AppEntityNotFoundException("Id not found " + roomId));
    return roomMapper.fromEntityToDto(room);
  }
}
