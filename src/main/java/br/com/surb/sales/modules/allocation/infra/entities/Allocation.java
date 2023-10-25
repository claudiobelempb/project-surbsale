package br.com.surb.sales.modules.allocation.infra.entities;

import br.com.surb.sales.modules.room.infra.entities.Room;
import br.com.surb.sales.modules.user.infra.entities.User;

import java.time.OffsetDateTime;

public class Allocation {
  private Long allocationId;
  private String code;
  private Room room;
  private User user;
  private String subject;
  private OffsetDateTime startAt;
  private OffsetDateTime endAt;
  private OffsetDateTime createdAt;
  private OffsetDateTime updatedAt;
}
