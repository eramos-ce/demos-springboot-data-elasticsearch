package com.eramosce.demos.boot.covid19service.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories (
    "com.eramos.demos.boot.covid19service.repository"
)
@ConfigurationProperties(
    prefix = "covid19.service.elasticsearch"
)
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

  private String host;
  private String port;

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }

  @Override
  public RestHighLevelClient elasticsearchClient() {
    final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
        .connectedTo(String.format("%s:%s", host, port))
        .build();
    return RestClients.create(clientConfiguration).rest();
  }
}
