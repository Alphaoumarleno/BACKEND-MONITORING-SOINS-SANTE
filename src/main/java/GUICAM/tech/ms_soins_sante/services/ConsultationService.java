package GUICAM.tech.ms_soins_sante.services;

import GUICAM.tech.ms_soins_sante.DTO.ConsultationDTO;
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

        return toDTO(consultationRepository.save(e));
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
}
