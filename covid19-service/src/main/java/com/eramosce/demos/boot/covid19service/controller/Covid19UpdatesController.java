package com.eramosce.demos.boot.covid19service.controller;

import com.eramosce.demos.boot.covid19service.dto.ControllerBaseResponse;
import com.eramosce.demos.boot.covid19service.model.Covid19DataUpdate;
import com.eramosce.demos.boot.covid19service.model.Covid19DataUpdate.Geometry;
import com.eramosce.demos.boot.covid19service.service.Covid19UpdatesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/updates")
public class Covid19UpdatesController {

  @Autowired
  private Covid19UpdatesService updatesService;

  /**
   * Test endpoint to verify controller's availability.
   * @return a sample test response
   */
  @RequestMapping("/test")
  public ControllerBaseResponse test() {
    return ControllerBaseResponse.builder()
        .code(200)
        .message("Test request received!")
        .build();
  }

  @RequestMapping("/all")
  public List<Covid19DataUpdate> getAll() {
    return updatesService.getAll();
  }

  @RequestMapping("/testStore")
  public ControllerBaseResponse testStore() {
    Covid19DataUpdate testDataPoint = Covid19DataUpdate.builder()
        .newCases(1)
        .newDeaths(1)
        .newRecoveries(100)
        .geometry(
            Geometry.builder()
                .lat(0.0)
                .lon(1.1)
                .build())
        .build();

    return ControllerBaseResponse.builder()
        .code(200)
        .message(
            updatesService.add(testDataPoint).toString()
        ).build();
  }

}
