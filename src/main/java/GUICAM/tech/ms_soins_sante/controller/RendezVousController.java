package GUICAM.tech.ms_soins_sante.controller;

import GUICAM.tech.ms_soins_sante.DTO.RendezVousDTO;
import GUICAM.tech.ms_soins_sante.services.RendezVousService; // ← IMPORT CORRIGÉ
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rendezvous")
@RequiredArgsConstructor
public class RendezVousController {

    private final RendezVousService rendezVousService;

    @GetMapping
    public List<RendezVousDTO> getAll() {
        return rendezVousService.getAll();
    }

    @GetMapping("/{id}")
    public RendezVousDTO getById(@PathVariable Long id) {
        return rendezVousService.getById(id);
    }

    @GetMapping("/patient/{patientId}")
    public List<RendezVousDTO> getByPatient(@PathVariable Long patientId) {
        return rendezVousService.getByPatient(patientId);
    }

    @GetMapping("/medecin/{medecinId}")
    public List<RendezVousDTO> getByMedecin(@PathVariable Long medecinId) {
        return rendezVousService.getByMedecin(medecinId);
    }

    @PostMapping
    public RendezVousDTO create(@RequestBody RendezVousDTO dto) {
        return rendezVousService.create(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rendezVousService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
