package GUICAM.tech.ms_soins_sante.services;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> a19c632 (Ajout du fichier readme.md)
import GUICAM.tech.ms_soins_sante.DTO.PatientDTO;
import GUICAM.tech.ms_soins_sante.devops.metrics.BusinessMetricsConfig;
import GUICAM.tech.ms_soins_sante.entities.PatientEntity;
import GUICAM.tech.ms_soins_sante.repositories.PatientRepository; // ← CORRECTION DÉFINITIVE
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
<<<<<<< HEAD
public class PatientService {
    private final BusinessMetricsConfig metrics;

    private final PatientRepository patientRepository;

    public List<PatientDTO> getAll() {
        return patientRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public PatientDTO getById(Long id) {
        PatientEntity entity = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient non trouvé : " + id));
        return toDTO(entity);
    }

    public PatientDTO create(PatientDTO dto) {
        PatientEntity entity = new PatientEntity();
        fillEntity(entity, dto);
        PatientEntity savedEntity = patientRepository.save(entity);
        metrics.incrementPatient(); // ← Appel des métriques ici
        return toDTO(savedEntity);
    }

    public PatientDTO update(Long id, PatientDTO dto) {
        PatientEntity entity = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient non trouvé : " + id));

        fillEntity(entity, dto);

        return toDTO(patientRepository.save(entity));
    }

    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

    private void fillEntity(PatientEntity entity, PatientDTO dto) {
        entity.setCivility(dto.civility());
        entity.setNom(dto.nom());
        entity.setPrenom(dto.prenom());
        entity.setSexe(dto.sexe());
        entity.setPhoneindex(dto.phoneindex());
        entity.setTelephone(dto.telephone());
        entity.setEmail(dto.email());
        entity.setAdresse(dto.adresse());
        entity.setVille(dto.ville());
        entity.setDatenaissance(dto.datenaissance());
        entity.setCodePostal(dto.codePostal());
        entity.setPassword(dto.password());
    }

    private PatientDTO toDTO(PatientEntity e) {
        return new PatientDTO(
                e.getPatientId(),
                e.getCivility(),
                e.getNom(),
                e.getPrenom(),
                e.getSexe(),
                e.getPhoneindex(),
                e.getTelephone(),
                e.getEmail(),
                e.getAdresse(),
                e.getVille(),
                e.getDatenaissance(),
                e.getCodePostal(),
                e.getPassword()
        );
    } // ← Accolade fermante ajoutée ici

    // La méthode createPatient a été fusionnée avec la méthode create existante
    // L'appel à metrics.incrementPatient() a été déplacé dans la méthode create()
}
=======
public class PatientService {
}
>>>>>>> b85821c (Ajout du fichier readme.md)
=======
public class PatientService {
    private final BusinessMetricsConfig metrics;

    private final PatientRepository patientRepository;

    public List<PatientDTO> getAll() {
        return patientRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public PatientDTO getById(Long id) {
        PatientEntity entity = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient non trouvé : " + id));
        return toDTO(entity);
    }

    public PatientDTO create(PatientDTO dto) {
        PatientEntity entity = new PatientEntity();
        fillEntity(entity, dto);
        PatientEntity savedEntity = patientRepository.save(entity);
        metrics.incrementPatient(); // ← Appel des métriques ici
        return toDTO(savedEntity);
    }

    public PatientDTO update(Long id, PatientDTO dto) {
        PatientEntity entity = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient non trouvé : " + id));

        fillEntity(entity, dto);

        return toDTO(patientRepository.save(entity));
    }

    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

    private void fillEntity(PatientEntity entity, PatientDTO dto) {
        entity.setCivility(dto.civility());
        entity.setNom(dto.nom());
        entity.setPrenom(dto.prenom());
        entity.setSexe(dto.sexe());
        entity.setPhoneindex(dto.phoneindex());
        entity.setTelephone(dto.telephone());
        entity.setEmail(dto.email());
        entity.setAdresse(dto.adresse());
        entity.setVille(dto.ville());
        entity.setDatenaissance(dto.datenaissance());
        entity.setCodePostal(dto.codePostal());
        entity.setPassword(dto.password());
    }

    private PatientDTO toDTO(PatientEntity e) {
        return new PatientDTO(
                e.getPatientId(),
                e.getCivility(),
                e.getNom(),
                e.getPrenom(),
                e.getSexe(),
                e.getPhoneindex(),
                e.getTelephone(),
                e.getEmail(),
                e.getAdresse(),
                e.getVille(),
                e.getDatenaissance(),
                e.getCodePostal(),
                e.getPassword()
        );
    } // ← Accolade fermante ajoutée ici

    // La méthode createPatient a été fusionnée avec la méthode create existante
    // L'appel à metrics.incrementPatient() a été déplacé dans la méthode create()
}
>>>>>>> a19c632 (Ajout du fichier readme.md)
