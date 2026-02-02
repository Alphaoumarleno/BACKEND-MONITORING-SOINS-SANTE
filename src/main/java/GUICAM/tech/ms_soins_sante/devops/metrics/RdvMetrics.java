<<<<<<< HEAD
<<<<<<< HEAD
package GUICAM.tech.ms_soins_sante.devops.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class RdvMetrics {

    private final Counter rdvCreated;
    private final Counter rdvUpdated;
    private final Counter rdvDeleted;

    public RdvMetrics(MeterRegistry registry) {

        this.rdvCreated = Counter.builder("rdv_created_total")
                .description("Nombre total de rendez-vous créés")
                .tag("application", "ms-soins-sante")
                .register(registry);

        this.rdvUpdated = Counter.builder("rdv_updated_total")
                .description("Nombre total de rendez-vous mis à jour")
                .tag("application", "ms-soins-sante")
                .register(registry);

        this.rdvDeleted = Counter.builder("rdv_deleted_total")
                .description("Nombre total de rendez-vous supprimés")
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
public class RdvMetrics {
<<<<<<< HEAD
>>>>>>> b85821c (Ajout du fichier readme.md)
=======

    private final Counter rdvCreated;
    private final Counter rdvUpdated;
    private final Counter rdvDeleted;

    public RdvMetrics(MeterRegistry registry) {

        this.rdvCreated = Counter.builder("rdv_created_total")
                .description("Nombre total de rendez-vous créés")
                .tag("application", "ms-soins-sante")
                .register(registry);

        this.rdvUpdated = Counter.builder("rdv_updated_total")
                .description("Nombre total de rendez-vous mis à jour")
                .tag("application", "ms-soins-sante")
                .register(registry);

        this.rdvDeleted = Counter.builder("rdv_deleted_total")
                .description("Nombre total de rendez-vous supprimés")
                .tag("application", "ms-soins-sante")
                .register(registry);
    }
>>>>>>> a19c632 (Ajout du fichier readme.md)
}
