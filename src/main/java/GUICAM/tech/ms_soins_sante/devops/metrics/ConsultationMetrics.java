<<<<<<< HEAD
<<<<<<< HEAD
package GUICAM.tech.ms_soins_sante.devops.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ConsultationMetrics {

    private final Counter consultationCreated;
    private final Counter consultationUpdated;
    private final Counter consultationCanceled;

    public ConsultationMetrics(MeterRegistry registry) {

        this.consultationCreated = Counter.builder("consultation_created_total")
                .description("Nombre total de consultations créées")
                .tag("application", "ms-soins-sante")
                .register(registry);

        this.consultationUpdated = Counter.builder("consultation_updated_total")
                .description("Nombre total de consultations modifiées")
                .tag("application", "ms-soins-sante")
                .register(registry);

        this.consultationCanceled = Counter.builder("consultation_canceled_total")
                .description("Nombre total de consultations annulées")
                .tag("application", "ms-soins-sante")
                .register(registry);
    }
=======
package GUICAM.tech.ms_soins_sante.metrics;
=======
package GUICAM.tech.ms_soins_sante.devops.metrics;
>>>>>>> a19c632 (Ajout du fichier readme.md)

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ConsultationMetrics {
<<<<<<< HEAD
>>>>>>> b85821c (Ajout du fichier readme.md)
=======

    private final Counter consultationCreated;
    private final Counter consultationUpdated;
    private final Counter consultationCanceled;

    public ConsultationMetrics(MeterRegistry registry) {

        this.consultationCreated = Counter.builder("consultation_created_total")
                .description("Nombre total de consultations créées")
                .tag("application", "ms-soins-sante")
                .register(registry);

        this.consultationUpdated = Counter.builder("consultation_updated_total")
                .description("Nombre total de consultations modifiées")
                .tag("application", "ms-soins-sante")
                .register(registry);

        this.consultationCanceled = Counter.builder("consultation_canceled_total")
                .description("Nombre total de consultations annulées")
                .tag("application", "ms-soins-sante")
                .register(registry);
    }
>>>>>>> a19c632 (Ajout du fichier readme.md)
}
