package com.eramosce.demos.boot.covid19service.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Builder
public class ControllerBaseResponse {

  private int code;
  private String message;

}
