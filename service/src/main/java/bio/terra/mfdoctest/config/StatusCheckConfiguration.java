package bio.terra.mfdoctest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mfdoctest.status-check")
public record StatusCheckConfiguration(
    boolean enabled,
    int pollingIntervalSeconds,
    int startupWaitSeconds,
    int stalenessThresholdSeconds) {}
