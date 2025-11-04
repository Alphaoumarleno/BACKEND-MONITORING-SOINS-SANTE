package GUICAM.tech.ms_soins_sante.controller;

import GUICAM.tech.ms_soins_sante.entities.RendezVousEntity;
import GUICAM.tech.ms_soins_sante.service.RendezVousService;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rendezvous")
public class RendezVousController {
    private final RendezVousService service;

    public RendezVousController(RendezVousService service) {
        this.service = service;

    }
    @PostMapping
    public ResponseEntity<RendezVousEntity> creer(@RequestBody CreateRdvRequest req) {
        RendezVousEntity rdv = service.creerRendezVous(req.getPatientId(), req.getMedecinId(),
                req.getDate(), req.getHeure(), req.getMotif());
        return ResponseEntity.ok(rdv);
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<List<RendezVousEntity>> rdvParPatient(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRdvByPatient(id));
    }

    @GetMapping("/medecin/{id}")
    public ResponseEntity<List<RendezVousEntity>> rdvParMedecin(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRdvByMedecin(id));
    }

    @PutMapping("/{id}/confirmer")
    public ResponseEntity<RendezVous> confirmer(@PathVariable Long id) {
        return ResponseEntity.ok(service.confirmerRdv(id));
    }

    @PutMapping("/{id}/annuler")
    public ResponseEntity<RendezVous> annuler(@PathVariable Long id) {
        return ResponseEntity.ok(service.annulerRdv(id));
    }

    @GetMapping("/medecin/{id}/disponibilite")
    public ResponseEntity<List<RendezVous>> disponibilite(@PathVariable Long id,
                                                          @RequestParam("date") String date) {
        // parse date expected format: yyyy-MM-dd
        java.time.LocalDate d = java.time.LocalDate.parse(date);
        return ResponseEntity.ok(service.disponibiliteMedecin(id, d));
    }
}

