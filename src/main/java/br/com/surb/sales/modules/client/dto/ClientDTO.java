package br.com.surb.sales.modules.client.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ClientDTO {
  private Long clientId;
  private String name;

  public ClientDTO(){}

  public ClientDTO(Long clientId, String name) {
    this.clientId = clientId;
    this.name = name;
  }

  public Long getClientId() {
    return clientId;
  }

  public void setClientId(Long clientId) {
    this.clientId = clientId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
