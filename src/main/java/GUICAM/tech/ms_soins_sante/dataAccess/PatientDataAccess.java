package GUICAM.tech.ms_soins_sante.dataAccess;

import GUICAM.tech.ms_soins_sante.entities.PatientEntity;
import GUICAM.tech.ms_soins_sante.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class PatientDataAccess {

    private final PatientRepository patientRepository;

    public List<PatientEntity> findAll() {
        return patientRepository.findAll();
    }

    public Optional<PatientEntity> findById(Long id) {
        return patientRepository.findById(id);
    }

    public PatientEntity save(PatientEntity patient) {
        return patientRepository.save(patient);
    }

    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }
}
