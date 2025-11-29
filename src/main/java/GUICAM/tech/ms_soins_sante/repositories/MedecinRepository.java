package GUICAM.tech.ms_soins_sante.repositories;

import GUICAM.tech.ms_soins_sante.entities.MedecinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<MedecinEntity, Long> {
}
