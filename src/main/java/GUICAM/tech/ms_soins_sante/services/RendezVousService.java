package GUICAM.tech.ms_soins_sante.services;

import GUICAM.tech.ms_soins_sante.DTO.RendezVousDTO;
<<<<<<< HEAD
<<<<<<< HEAD
import GUICAM.tech.ms_soins_sante.devops.metrics.BusinessMetricsConfig;
=======
>>>>>>> b85821c (Ajout du fichier readme.md)
=======
import GUICAM.tech.ms_soins_sante.devops.metrics.BusinessMetricsConfig;
>>>>>>> a19c632 (Ajout du fichier readme.md)
import GUICAM.tech.ms_soins_sante.entities.MedecinEntity;
import GUICAM.tech.ms_soins_sante.entities.PatientEntity;
import GUICAM.tech.ms_soins_sante.entities.RendezVousEntity;
import GUICAM.tech.ms_soins_sante.repositories.MedecinRepository;
import GUICAM.tech.ms_soins_sante.repositories.PatientRepository;
import GUICAM.tech.ms_soins_sante.repositories.RendezVousRepository;
<<<<<<< HEAD
<<<<<<< HEAD
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
=======
>>>>>>> b85821c (Ajout du fichier readme.md)
=======
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
>>>>>>> a19c632 (Ajout du fichier readme.md)
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RendezVousService {

    private final RendezVousRepository rendezVousRepository;
    private final PatientRepository patientRepository;
    private final MedecinRepository medecinRepository;
<<<<<<< HEAD
<<<<<<< HEAD
    private final BusinessMetricsConfig metrics;
    private final MeterRegistry meterRegistry;
=======
>>>>>>> b85821c (Ajout du fichier readme.md)
=======
    private final BusinessMetricsConfig metrics;
    private final MeterRegistry meterRegistry;
>>>>>>> a19c632 (Ajout du fichier readme.md)

    public List<RendezVousDTO> getAll() {
        return rendezVousRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public RendezVousDTO getById(Long id) {
        RendezVousEntity entity = rendezVousRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rendez-vous non trouvé : " + id));
        return toDTO(entity);
    }

    public List<RendezVousDTO> getByPatient(Long patientId) {
        PatientEntity patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient non trouvé : " + patientId));

        return rendezVousRepository.findByPatient(patient)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public List<RendezVousDTO> getByMedecin(Long medecinId) {
        MedecinEntity medecin = medecinRepository.findById(medecinId)
                .orElseThrow(() -> new RuntimeException("Médecin non trouvé : " + medecinId));

        return rendezVousRepository.findByMedecin(medecin)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public RendezVousDTO create(RendezVousDTO dto) {
        PatientEntity patient = patientRepository.findById(dto.patientId())
                .orElseThrow(() -> new RuntimeException("Patient non trouvé : " + dto.patientId()));

        MedecinEntity medecin = medecinRepository.findById(dto.medecinId())
                .orElseThrow(() -> new RuntimeException("Médecin non trouvé : " + dto.medecinId()));

        RendezVousEntity entity = new RendezVousEntity();
        entity.setPatient(patient);
        entity.setMedecin(medecin);
        entity.setDateRendezVous(dto.dateRendezVous());
        entity.setHeureRendezVous(dto.heureRendezVous());
        entity.setStatut(dto.statut());
        entity.setMotif(dto.motif());

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> a19c632 (Ajout du fichier readme.md)
        RendezVousEntity savedEntity = rendezVousRepository.save(entity);

        // Métriques
        metrics.incrementRdv();

        // TODO: calcul temps depuis dernier RDV
        long minutes = 0; // à calculer
        metrics.updateRdvDelay(minutes);

        // Métrique par spécialité
        incrementRdvBySpecialiteCounter(medecin.getSpecialite());

        return toDTO(savedEntity);
    }

    public RendezVousEntity createRdv(RendezVousEntity rdv) {
        RendezVousEntity savedRdv = rendezVousRepository.save(rdv);

        // Métriques
        metrics.incrementRdv();

        // TODO: calcul temps depuis dernier RDV
        long minutes = 0; // à calculer
        metrics.updateRdvDelay(minutes);

        // Métrique par spécialité
        if (rdv.getMedecin() != null && rdv.getMedecin().getSpecialite() != null) {
            incrementRdvBySpecialiteCounter(rdv.getMedecin().getSpecialite());
        }

        return savedRdv;
<<<<<<< HEAD
=======
        return toDTO(rendezVousRepository.save(entity));
>>>>>>> b85821c (Ajout du fichier readme.md)
=======
>>>>>>> a19c632 (Ajout du fichier readme.md)
    }

    public void delete(Long id) {
        rendezVousRepository.deleteById(id);
    }

    private RendezVousDTO toDTO(RendezVousEntity e) {
        return new RendezVousDTO(
                e.getRendezVousId(),
                e.getPatient() != null ? e.getPatient().getPatientId() : null,
                e.getMedecin() != null ? e.getMedecin().getMedecinId() : null,
                e.getDateRendezVous(),
                e.getHeureRendezVous(),
                e.getStatut(),
                e.getMotif()
        );
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> a19c632 (Ajout du fichier readme.md)

    private void incrementRdvBySpecialiteCounter(String specialite) {
        Counter counter = Counter.builder("santeplus_rdv_by_specialite_total")
                .tag("specialite", specialite)
                .register(meterRegistry);
        counter.increment();
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> b85821c (Ajout du fichier readme.md)
=======
}
>>>>>>> a19c632 (Ajout du fichier readme.md)
