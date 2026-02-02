package GUICAM.tech.ms_soins_sante.controller;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> a19c632 (Ajout du fichier readme.md)
import GUICAM.tech.ms_soins_sante.DTO.ConsultationDTO;
import GUICAM.tech.ms_soins_sante.services.ConsultationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultations")
@RequiredArgsConstructor
public class ConsultationController {

    private final ConsultationService consultationService;

    @GetMapping
    public List<ConsultationDTO> getAll() {
        return consultationService.getAll();
    }

    @GetMapping("/{id}")
    public ConsultationDTO getById(@PathVariable Long id) {
        return consultationService.getById(id);
    }

    @GetMapping("/patient/{patientId}")
    public List<ConsultationDTO> getByPatient(@PathVariable Long patientId) {
        return consultationService.getByPatient(patientId);
    }

    @PostMapping
    public ConsultationDTO create(@RequestBody ConsultationDTO dto) {
        return consultationService.create(dto);
    }
<<<<<<< HEAD
=======
public class ConsultationController {
>>>>>>> b85821c (Ajout du fichier readme.md)
=======
>>>>>>> a19c632 (Ajout du fichier readme.md)
}
