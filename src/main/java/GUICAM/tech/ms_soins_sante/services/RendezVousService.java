package GUICAM.tech.ms_soins_sante.services;

import GUICAM.tech.ms_soins_sante.DTO.RendezVousDTO;
import GUICAM.tech.ms_soins_sante.entities.MedecinEntity;
import GUICAM.tech.ms_soins_sante.entities.PatientEntity;
import GUICAM.tech.ms_soins_sante.entities.RendezVousEntity;
import GUICAM.tech.ms_soins_sante.repositories.MedecinRepository;
import GUICAM.tech.ms_soins_sante.repositories.PatientRepository;
import GUICAM.tech.ms_soins_sante.repositories.RendezVousRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RendezVousService {

    private final RendezVousRepository rendezVousRepository;
    private final PatientRepository patientRepository;
    private final MedecinRepository medecinRepository;

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

        return toDTO(rendezVousRepository.save(entity));
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
}
