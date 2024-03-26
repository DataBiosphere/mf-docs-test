package bio.terra.mfdoctest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mfdoctest.sam")
public record SamConfiguration(String basePath) {}
