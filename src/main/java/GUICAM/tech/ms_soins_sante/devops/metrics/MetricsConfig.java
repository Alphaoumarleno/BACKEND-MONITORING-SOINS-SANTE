package GUICAM.tech.ms_soins_sante.devops.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {

    public MetricsConfig(MeterRegistry registry) {
        registry.config().commonTags(
                "application", "ms-soins-sante",
                "service", "soins"
        );
    }
}
