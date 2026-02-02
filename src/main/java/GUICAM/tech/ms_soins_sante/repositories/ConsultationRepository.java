package GUICAM.tech.ms_soins_sante.repositories;

import GUICAM.tech.ms_soins_sante.entities.ConsultationEntity;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import GUICAM.tech.ms_soins_sante.entities.PatientEntity;
>>>>>>> b85821c (Ajout du fichier readme.md)
=======
>>>>>>> a19c632 (Ajout du fichier readme.md)
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultationRepository extends JpaRepository<ConsultationEntity, Long> {

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> a19c632 (Ajout du fichier readme.md)
    // Déjà présent
    List<ConsultationEntity> findByPatient(GUICAM.tech.ms_soins_sante.entities.PatientEntity patient);

    // ➕ Ajout obligatoire pour corriger l'erreur
    List<ConsultationEntity> findByPatientPatientId(Long patientId);

    // (Optionnel si tu veux aussi récupérer par medecin)
    List<ConsultationEntity> findByMedecinMedecinId(Long medecinId);
<<<<<<< HEAD
=======
    List<ConsultationEntity> findByPatient(PatientEntity patient);
>>>>>>> b85821c (Ajout du fichier readme.md)
=======
>>>>>>> a19c632 (Ajout du fichier readme.md)
}
