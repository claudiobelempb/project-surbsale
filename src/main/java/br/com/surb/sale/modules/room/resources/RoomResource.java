package br.com.surb.sale.modules.room.resources;

import static java.util.concurrent.CompletableFuture.*;

import br.com.surb.sale.api.facade.RoomsApi;
import br.com.surb.sale.api.model.Room;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/rooms")
public class RoomResource implements RoomsApi {
  @Override
  @GetMapping(value = "/{id}")
  public CompletableFuture<ResponseEntity<Room>> handler(@Valid Long roomId) {
    return supplyAsync(() -> ResponseEntity.ok(new Room().roomId(1L).name("Room #1").code("2462f50f-bd5d-4ea4-ac8c" +
      "-84438d350083").seats(4)));
  }
}
