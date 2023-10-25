package br.com.surb.sales.modules.room.resources;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import br.com.surb.sales.api.facade.RoomsApi;
import br.com.surb.sales.api.model.RoomDTO;
import br.com.surb.sales.modules.room.services.RoomFindByIdService;
import br.com.surb.sales.shared.AppUtils.AppResponseEntityUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "/rooms")
public class RoomFindByIdResource implements RoomsApi {
  private final RoomFindByIdService roomFindByIdService;
  private final Executor controllersExecutor;

  public RoomFindByIdResource(RoomFindByIdService roomFindByIdService, Executor controllersExecutor) {
    this.roomFindByIdService = roomFindByIdService;
    this.controllersExecutor = controllersExecutor;
  }

  @Override
  @GetMapping(value = "/{roomId}")
  public CompletableFuture<ResponseEntity<RoomDTO>> execute(@PathVariable Long roomId) {
    //return supplyAsync(() -> ResponseEntity.ok(roomFindByIdService.execute(roomId)));
    return supplyAsync(() -> roomFindByIdService.execute(roomId), controllersExecutor).thenApply(r -> AppResponseEntityUtils.ok(r));
  }

}
