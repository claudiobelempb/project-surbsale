package br.com.surb.sale.modules.room.infra.repositories;

import br.com.surb.sale.modules.room.infra.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
