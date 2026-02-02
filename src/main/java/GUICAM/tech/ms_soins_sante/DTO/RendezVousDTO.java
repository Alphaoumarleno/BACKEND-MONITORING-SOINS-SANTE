package GUICAM.tech.ms_soins_sante.DTO;

import GUICAM.tech.ms_soins_sante.entities.StatutRendezVous;

import java.time.LocalDate;
import java.time.LocalTime;

public record RendezVousDTO(
        Long rendezVousId,
        Long patientId,
        Long medecinId,
        LocalDate dateRendezVous,
        LocalTime heureRendezVous,
        StatutRendezVous statut,
        String motif
) {}
