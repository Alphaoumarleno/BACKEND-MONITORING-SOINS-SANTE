package GUICAM.tech.ms_soins_sante.repository;

import GUICAM.tech.ms_soins_sante.entities.RendezVousEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVousEntity, Long> {
    List<RendezVousEntity> findByPatientPatientId(Long patientId);
    List<RendezVousEntity> findByMedecinMedecinId(Long medecinId);
    boolean existsByMedecinMedecinIdAndDateRendezVousAndHeureRendezVous(Long medecinId, LocalDate date, LocalTime heure);
    List<RendezVousEntity> findByMedecinMedecinIdAndDateRendezVous(Long medecinId, LocalDate date);
}

