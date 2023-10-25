package br.com.surb.sales.integration;

import br.com.surb.sales.api.facade.RoomsApi;
import br.com.surb.sales.core.BaseIntegrationTest;
import br.com.surb.sales.unit.TestConstants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RoomFindByIdServiceIntegrationTest extends BaseIntegrationTest {

  @Autowired
  private RoomsApi roomsApi;



  @Override
  protected void setupEach() throws Exception{
    //setLocalHostBasePath(roomsApi.getRequest(), "/api/v1");
  }

  @Test
  void test(){
    roomsApi.execute(TestConstants.DEFAULT_ROOM_ID);
  }
}
