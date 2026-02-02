<<<<<<< HEAD
<<<<<<< HEAD
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
=======
package GUICAM.tech.ms_soins_sante.metrics;
=======
package GUICAM.tech.ms_soins_sante.devops.metrics;
>>>>>>> a19c632 (Ajout du fichier readme.md)

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {
<<<<<<< HEAD
>>>>>>> b85821c (Ajout du fichier readme.md)
=======

    public MetricsConfig(MeterRegistry registry) {
        registry.config().commonTags(
                "application", "ms-soins-sante",
                "service", "soins"
        );
    }
>>>>>>> a19c632 (Ajout du fichier readme.md)
}
