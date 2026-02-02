package GUICAM.tech.ms_soins_sante.repositories;

import GUICAM.tech.ms_soins_sante.entities.ConsultationEntity;
import GUICAM.tech.ms_soins_sante.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultationRepository extends JpaRepository<ConsultationEntity, Long> {

    List<ConsultationEntity> findByPatient(PatientEntity patient);
}
