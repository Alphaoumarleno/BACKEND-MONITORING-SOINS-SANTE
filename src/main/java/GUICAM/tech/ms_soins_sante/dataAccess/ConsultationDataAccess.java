package GUICAM.tech.ms_soins_sante.dataAccess;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> a19c632 (Ajout du fichier readme.md)
import GUICAM.tech.ms_soins_sante.entities.ConsultationEntity;
import GUICAM.tech.ms_soins_sante.repositories.ConsultationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ConsultationDataAccess {

    private final ConsultationRepository consultationRepository;

    public List<ConsultationEntity> findAll() {
        return consultationRepository.findAll();
    }

    public Optional<ConsultationEntity> findById(Long id) {
        return consultationRepository.findById(id);
    }

    public ConsultationEntity save(ConsultationEntity consultation) {
        return consultationRepository.save(consultation);
    }

    public void deleteById(Long id) {
        consultationRepository.deleteById(id);
    }

    public List<ConsultationEntity> findByPatient(Long patientId) {
        // ❗ Correction ici : méthode correcte
        return consultationRepository.findByPatientPatientId(patientId);
    }

    public List<ConsultationEntity> findByMedecin(Long medecinId) {
        return consultationRepository.findByMedecinMedecinId(medecinId);
    }
<<<<<<< HEAD
=======
public class ConsultationDataAccess {
>>>>>>> b85821c (Ajout du fichier readme.md)
=======
>>>>>>> a19c632 (Ajout du fichier readme.md)
}
