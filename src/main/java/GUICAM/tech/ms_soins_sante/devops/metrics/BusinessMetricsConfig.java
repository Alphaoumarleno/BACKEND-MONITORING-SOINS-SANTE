package GUICAM.tech.ms_soins_sante.devops.metrics;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> a19c632 (Ajout du fichier readme.md)
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.DistributionSummary;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import com.google.common.util.concurrent.AtomicDouble; // ← Import corrigé
@Configuration
public class BusinessMetricsConfig {

    private final MeterRegistry meterRegistry;

    // === Counters ===
    public final Counter patientsCreatedCounter;
    public final Counter rdvCreatedCounter;
    public final Counter consultationsCreatedCounter;

    // === Histogram / Summary ===
    public final DistributionSummary rdvDelaySummary;

    // === Gauge ===
    private final AtomicDouble businessActivityRate = new AtomicDouble(0);

    public BusinessMetricsConfig(MeterRegistry registry) {
        this.meterRegistry = registry;

        // Patients
        this.patientsCreatedCounter = Counter.builder("santeplus_patients_created_total")
                .description("Total patients créés")
                .register(registry);

        // RDV
        this.rdvCreatedCounter = Counter.builder("santeplus_rdv_created_total")
                .description("Total RDV créés")
                .register(registry);

        // Consultations
        this.consultationsCreatedCounter = Counter.builder("santeplus_consultations_created_total")
                .description("Total consultations créées")
                .register(registry);

        // Historique temps RDV
        this.rdvDelaySummary = DistributionSummary.builder("santeplus_rdv_delay_minutes")
                .description("Temps entre deux RDV en minutes")
                .register(registry);

        // Gauge taux activité
        Gauge.builder("santeplus_business_activity_rate", businessActivityRate, AtomicDouble::get)
                .description("Taux activité business (%)")
                .register(registry);
    }

    // Mise à jour du taux business (exécution chaque minute)
    @Scheduled(fixedRate = 60000)
    public void updateBusinessRate() {
        double rdvToday = 0;  // TODO: appeler ton repository
        double maxPossible = 100; // à définir selon ton business

        businessActivityRate.set((rdvToday / maxPossible) * 100.0);
    }

    public void updateRdvDelay(double minutes) {
        rdvDelaySummary.record(minutes);
    }

    public void incrementPatient() {
        patientsCreatedCounter.increment();
    }

    public void incrementRdv() {
        rdvCreatedCounter.increment();
    }

    public void incrementConsultation() {
        consultationsCreatedCounter.increment();
    }
<<<<<<< HEAD
=======
public class BusinessMetricsConfig {
>>>>>>> b85821c (Ajout du fichier readme.md)
=======
>>>>>>> a19c632 (Ajout du fichier readme.md)
}
