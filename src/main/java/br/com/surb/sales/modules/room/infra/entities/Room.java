package br.com.surb.sales.modules.room.infra.entities;

import static java.util.Objects.isNull;
import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_room")
public class Room implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long roomId;

  private String code;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private Integer seats;

  @Column(nullable = false)

  private Boolean active;
  private OffsetDateTime createdAt;
  private OffsetDateTime updatedAt;

  public Room() {
  }

  private Room(Long roomId, String code, String name, Integer seats, Boolean active, OffsetDateTime createdAt,
         OffsetDateTime updatedAt) {
    this.roomId = roomId;
    this.code = code;
    this.name = name;
    this.seats = seats;
    this.active = active;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Long getRoomId() {
    return roomId;
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public Integer getSeats() {
    return seats;
  }

  public Boolean getActive() {
    return active;
  }

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  @PrePersist
  public void prePersist() {
    if(isNull(active)){
      this.active = true;
    }
    if(isNull(code)) {
      this.code = UUID.randomUUID().toString();
    }
    if(isNull(createdAt)) {
      this.createdAt = OffsetDateTime.now();
    }
  }

  @PreUpdate
  public void preUpdate() {
    if(isNull(updatedAt)) {
      updatedAt = OffsetDateTime.now();
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Room room = (Room) o;

    if (!Objects.equals(roomId, room.roomId)) return false;
    return Objects.equals(code, room.code);
  }

  @Override
  public int hashCode() {
    int result = roomId != null ? roomId.hashCode() : 0;
    result = 31 * result + (code != null ? code.hashCode() : 0);
    return result;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {
    private Long roomId;
    private String code;
    private String name;
    private Integer seats;
    private Boolean active;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    private Builder() {
    }

    public Builder roomId(Long roomId) {
      this.roomId = roomId;
      return this;
    }

    public Builder code(String code) {
      this.code = code;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder seats(Integer seats) {
      this.seats = seats;
      return this;
    }

    public Builder active(Boolean active) {
      this.active = active;
      return this;
    }

    public Builder createdAt(OffsetDateTime createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    public Builder updatedAt(OffsetDateTime updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    public Room build() {
      return new Room(roomId, code, name, seats, active, createdAt, updatedAt);
    }
  }
}
