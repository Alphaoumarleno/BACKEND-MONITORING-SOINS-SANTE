package GUICAM.tech.ms_soins_sante.controller;

import GUICAM.tech.ms_soins_sante.DTO.PatientDTO;
import GUICAM.tech.ms_soins_sante.services.PatientService;  // ← import valide
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public List<PatientDTO> getAll() {
        return patientService.getAll();
    }

    @GetMapping("/{id}")
    public PatientDTO getById(@PathVariable Long id) {
        return patientService.getById(id);
    }

    @PostMapping
    public PatientDTO create(@RequestBody PatientDTO dto) {
        return patientService.create(dto);
    }

    @PutMapping("/{id}")
    public PatientDTO update(@PathVariable Long id, @RequestBody PatientDTO dto) {
        return patientService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        patientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
