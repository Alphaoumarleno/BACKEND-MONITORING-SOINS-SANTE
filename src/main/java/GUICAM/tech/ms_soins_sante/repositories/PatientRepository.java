package GUICAM.tech.ms_soins_sante.repositories;

import GUICAM.tech.ms_soins_sante.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
}
