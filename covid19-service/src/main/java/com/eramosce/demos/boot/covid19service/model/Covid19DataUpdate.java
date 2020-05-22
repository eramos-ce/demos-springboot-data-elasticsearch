package com.eramosce.demos.boot.covid19service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.GeoPointField;

@Data
@Builder
@Entity
@Document(
    createIndex = true,
    indexName = "covid19dataupdate"
)
public class Covid19DataUpdate {

  @Id
  @GeneratedValue
  private String id;

  @GeoPointField
  private Geometry geometry;
  private int newCases;
  private int newDeaths;
  private int newRecoveries;

  @Data
  @Builder
  public class Geometry {
    private double lat,lon;
  }

}
