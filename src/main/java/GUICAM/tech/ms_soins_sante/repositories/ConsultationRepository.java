package GUICAM.tech.ms_soins_sante.repositories;

import GUICAM.tech.ms_soins_sante.entities.ConsultationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultationRepository extends JpaRepository<ConsultationEntity, Long> {

    // Déjà présent
    List<ConsultationEntity> findByPatient(GUICAM.tech.ms_soins_sante.entities.PatientEntity patient);

    // ➕ Ajout obligatoire pour corriger l'erreur
    List<ConsultationEntity> findByPatientPatientId(Long patientId);

    // (Optionnel si tu veux aussi récupérer par medecin)
    List<ConsultationEntity> findByMedecinMedecinId(Long medecinId);
}
