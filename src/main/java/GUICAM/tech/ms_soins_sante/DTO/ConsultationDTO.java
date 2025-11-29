package GUICAM.tech.ms_soins_sante.DTO;

import java.time.LocalDate;

public record ConsultationDTO(
        Long consultationId,
        Long patientId,
        Long medecinId,
        Long rendezVousId,
        LocalDate dateConsultation,
        String motif,
        String diagnostic,
        String notes
) {}
