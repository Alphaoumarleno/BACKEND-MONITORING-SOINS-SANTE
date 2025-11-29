package GUICAM.tech.ms_soins_sante.repositories;

import GUICAM.tech.ms_soins_sante.entities.RendezVousEntity;
import GUICAM.tech.ms_soins_sante.entities.MedecinEntity;
import GUICAM.tech.ms_soins_sante.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVousEntity, Long> {

    List<RendezVousEntity> findByPatient(PatientEntity patient);

    List<RendezVousEntity> findByMedecin(MedecinEntity medecin);
}
