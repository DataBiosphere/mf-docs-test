package bio.terra.mfdoctest.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import bio.terra.mfdoctest.config.StatusCheckConfiguration;
import bio.terra.mfdoctest.model.SystemStatus;
import bio.terra.mfdoctest.model.SystemStatusSystems;
import java.util.Map;
import org.junit.jupiter.api.Test;

class BaseStatusServiceTest {

  @Test
  void getCurrentStatus() {
    var config = new StatusCheckConfiguration(true, 0, 0, 10);
    BaseStatusService service = new BaseStatusService(config);
    var status = new SystemStatusSystems().ok(true);
    service.registerStatusCheck("test", () -> status);
    assertThat(service.getCurrentStatus(), is(new SystemStatus().ok(false)));
    service.checkStatus();
    assertThat(
        service.getCurrentStatus(),
        is(new SystemStatus().ok(true).systems(Map.of("test", status))));
  }
}
