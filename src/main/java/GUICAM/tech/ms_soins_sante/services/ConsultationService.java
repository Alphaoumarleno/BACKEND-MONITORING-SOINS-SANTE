package GUICAM.tech.ms_soins_sante.services;

import GUICAM.tech.ms_soins_sante.DTO.ConsultationDTO;
<<<<<<< HEAD
<<<<<<< HEAD
import GUICAM.tech.ms_soins_sante.devops.metrics.BusinessMetricsConfig;
=======
>>>>>>> b85821c (Ajout du fichier readme.md)
=======
import GUICAM.tech.ms_soins_sante.devops.metrics.BusinessMetricsConfig;
>>>>>>> a19c632 (Ajout du fichier readme.md)
import GUICAM.tech.ms_soins_sante.entities.ConsultationEntity;
import GUICAM.tech.ms_soins_sante.entities.MedecinEntity;
import GUICAM.tech.ms_soins_sante.entities.PatientEntity;
import GUICAM.tech.ms_soins_sante.entities.RendezVousEntity;
import GUICAM.tech.ms_soins_sante.repositories.ConsultationRepository;
import GUICAM.tech.ms_soins_sante.repositories.MedecinRepository;
import GUICAM.tech.ms_soins_sante.repositories.PatientRepository;
import GUICAM.tech.ms_soins_sante.repositories.RendezVousRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultationService {

    private final ConsultationRepository consultationRepository;
    private final PatientRepository patientRepository;
    private final MedecinRepository medecinRepository;
    private final RendezVousRepository rendezVousRepository;
<<<<<<< HEAD
<<<<<<< HEAD
    private final BusinessMetricsConfig metrics;
=======
>>>>>>> b85821c (Ajout du fichier readme.md)
=======
    private final BusinessMetricsConfig metrics;
>>>>>>> a19c632 (Ajout du fichier readme.md)

    public List<ConsultationDTO> getAll() {
        return consultationRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public ConsultationDTO getById(Long id) {
        ConsultationEntity entity = consultationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consultation non trouvée : " + id));
        return toDTO(entity);
    }

    public List<ConsultationDTO> getByPatient(Long patientId) {
        PatientEntity patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient non trouvé : " + patientId));
        return consultationRepository.findByPatient(patient)
                .stream().map(this::toDTO).toList();
    }

    public ConsultationDTO create(ConsultationDTO dto) {
        PatientEntity patient = patientRepository.findById(dto.patientId())
                .orElseThrow(() -> new RuntimeException("Patient non trouvé : " + dto.patientId()));
        MedecinEntity medecin = medecinRepository.findById(dto.medecinId())
                .orElseThrow(() -> new RuntimeException("Médecin non trouvé : " + dto.medecinId()));

        RendezVousEntity rendezVous = null;
        if (dto.rendezVousId() != null) {
            rendezVous = rendezVousRepository.findById(dto.rendezVousId())
                    .orElseThrow(() -> new RuntimeException("Rendez-vous non trouvé : " + dto.rendezVousId()));
        }

        ConsultationEntity e = new ConsultationEntity();
        e.setPatient(patient);
        e.setMedecin(medecin);
        e.setRendezVous(rendezVous);
        e.setDateConsultation(dto.dateConsultation());
        e.setMotif(dto.motif());
        e.setDiagnostic(dto.diagnostic());
        e.setNotes(dto.notes());

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> a19c632 (Ajout du fichier readme.md)
        ConsultationEntity savedEntity = consultationRepository.save(e);

        // Métriques
        metrics.incrementConsultation();

        return toDTO(savedEntity);
    }

    public ConsultationEntity createConsultation(ConsultationEntity c) {
        ConsultationEntity savedConsultation = consultationRepository.save(c);

        // Métriques
        metrics.incrementConsultation();

        return savedConsultation;
<<<<<<< HEAD
=======
        return toDTO(consultationRepository.save(e));
>>>>>>> b85821c (Ajout du fichier readme.md)
=======
>>>>>>> a19c632 (Ajout du fichier readme.md)
    }

    private ConsultationDTO toDTO(ConsultationEntity e) {
        return new ConsultationDTO(
                e.getConsultationId(),
                e.getPatient() != null ? e.getPatient().getPatientId() : null,
                e.getMedecin() != null ? e.getMedecin().getMedecinId() : null,
                e.getRendezVous() != null ? e.getRendezVous().getRendezVousId() : null,
                e.getDateConsultation(),
                e.getMotif(),
                e.getDiagnostic(),
                e.getNotes()
        );
    }
<<<<<<< HEAD
<<<<<<< HEAD
}
=======
}
>>>>>>> b85821c (Ajout du fichier readme.md)
=======
}
>>>>>>> a19c632 (Ajout du fichier readme.md)
