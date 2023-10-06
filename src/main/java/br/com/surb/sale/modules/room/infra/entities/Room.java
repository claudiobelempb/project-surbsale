package br.com.surb.sale.modules.room.infra.entities;

import br.com.surb.sale.shared.AppEnums.StatusEnums;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

public class Room {
  private Long roomId;
  private String code;
  private String name;
  private Integer seats;
  private StatusEnums status;
  private OffsetDateTime createdAt;
  private OffsetDateTime updatedAt;
  private Set<Room> rooms = new HashSet<>();
}
