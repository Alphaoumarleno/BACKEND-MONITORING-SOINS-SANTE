package GUICAM.tech.ms_soins_sante.service;

import GUICAM.tech.ms_soins_sante.entities.MedecinEntity;
import GUICAM.tech.ms_soins_sante.entities.PatientEntity;
import GUICAM.tech.ms_soins_sante.entities.RendezVousEntity;
import GUICAM.tech.ms_soins_sante.entities.StatutRendezVous;
import GUICAM.tech.ms_soins_sante.repository.MedecinRepository;
import GUICAM.tech.ms_soins_sante.repository.PatientRepository;
import GUICAM.tech.ms_soins_sante.repository.RendezVousRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@Transactional
public class RendezVousService {

    private final RendezVousRepository rdvRepo;
    private final PatientRepository patientRepo;
    private final MedecinRepository medecinRepo;

    public RendezVousService(RendezVousRepository rdvRepo,
                             PatientRepository patientRepo,
                             MedecinRepository medecinRepo) {
        this.rdvRepo = rdvRepo;
        this.patientRepo = patientRepo;
        this.medecinRepo = medecinRepo;
    }

    public RendezVousEntity creerRendezVous(Long patientId, Long medecinId, LocalDate date, LocalTime heure, String motif) {
        if (!patientRepo.existsById(patientId)) {
            throw new IllegalArgumentException("Patient introuvable: " + patientId);
        }
        if (!medecinRepo.existsById(medecinId)) {
            throw new IllegalArgumentException("Médecin introuvable: " + medecinId);
        }
        if (rdvRepo.existsByMedecinMedecinIdAndDateRendezVousAndHeureRendezVous(medecinId, date, heure)) {
            throw new IllegalStateException("Médecin non disponible à cette date/heure");
        }

        PatientEntity p = patientRepo.findById(patientId).orElseThrow();
        MedecinEntity m = medecinRepo.findById(medecinId).orElseThrow();

        RendezVousEntity rdv = new RendezVousEntity();
        rdv.setPatient(p);
        rdv.setMedecin(m);
        rdv.setDateRendezVous(date);
        rdv.setHeureRendezVous(heure);
        rdv.setMotif(motif);
        rdv.setStatut(StatutRendezVous.EN_ATTENTE);

        return rdvRepo.save(rdv);
    }

    public List<RendezVousEntity> getRdvByPatient(Long patientId) {
        return rdvRepo.findByPatientPatientId(patientId);
    }

    public List<RendezVousEntity> getRdvByMedecin(Long medecinId) {
        return rdvRepo.findByMedecinMedecinId(medecinId);
    }

    public RendezVousEntity confirmerRdv(Long id) {
        RendezVousEntity rdv = rdvRepo.findById(id).orElseThrow();
        rdv.setStatut(StatutRendezVous.CONFIRME);
        return rdvRepo.save(rdv);
    }

    public RendezVousEntity annulerRdv(Long id) {
        RendezVousEntity rdv = rdvRepo.findById(id).orElseThrow();
        rdv.setStatut(StatutRendezVous.ANNULE);
        return rdvRepo.save(rdv);
    }

    public List<RendezVousEntity> disponibiliteMedecin(Long medecinId, LocalDate date) {
        return rdvRepo.findByMedecinMedecinIdAndDateRendezVous(medecinId, date);
    }
}
