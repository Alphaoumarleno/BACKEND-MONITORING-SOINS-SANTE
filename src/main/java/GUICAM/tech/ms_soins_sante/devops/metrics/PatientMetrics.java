<<<<<<< HEAD
<<<<<<< HEAD
package GUICAM.tech.ms_soins_sante.devops.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PatientMetrics {

    private final Counter patientCreated;
    private final Counter patientUpdated;
    private final Counter patientDeleted;

    public PatientMetrics(MeterRegistry registry) {

        this.patientCreated = Counter.builder("patients_created_total")
                .description("Nombre total de patients créés")
                .tag("application", "ms-soins-sante")
                .register(registry);

        this.patientUpdated = Counter.builder("patients_updated_total")
                .description("Nombre total de patients mis à jour")
                .tag("application", "ms-soins-sante")
                .register(registry);

        this.patientDeleted = Counter.builder("patients_deleted_total")
                .description("Nombre total de patients supprimés")
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
public class PatientMetrics {
<<<<<<< HEAD
>>>>>>> b85821c (Ajout du fichier readme.md)
=======

    private final Counter patientCreated;
    private final Counter patientUpdated;
    private final Counter patientDeleted;

    public PatientMetrics(MeterRegistry registry) {

        this.patientCreated = Counter.builder("patients_created_total")
                .description("Nombre total de patients créés")
                .tag("application", "ms-soins-sante")
                .register(registry);

        this.patientUpdated = Counter.builder("patients_updated_total")
                .description("Nombre total de patients mis à jour")
                .tag("application", "ms-soins-sante")
                .register(registry);

        this.patientDeleted = Counter.builder("patients_deleted_total")
                .description("Nombre total de patients supprimés")
                .tag("application", "ms-soins-sante")
                .register(registry);
    }
>>>>>>> a19c632 (Ajout du fichier readme.md)
}
