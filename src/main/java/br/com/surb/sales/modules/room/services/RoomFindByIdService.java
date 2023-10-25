package br.com.surb.sales.modules.room.services;


import br.com.surb.sales.modules.room.infra.entities.Room;
import br.com.surb.sales.modules.room.infra.repositories.RoomRepository;
import br.com.surb.sales.modules.room.mapper.RoomMapper;
import br.com.surb.sales.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;


import br.com.surb.sales.api.model.RoomDTO;
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
