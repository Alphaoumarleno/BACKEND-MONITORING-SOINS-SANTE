package GUICAM.tech.ms_soins_sante.DTO;

import GUICAM.tech.ms_soins_sante.entities.Civility;

import java.time.LocalDate;

public record PatientDTO(
        Long patientId,
        Civility civility,
        String nom,
        String prenom,
        String sexe,
        String phoneindex,
        String telephone,
        String email,
        String adresse,
        String ville,
        LocalDate datenaissance,
        String codePostal,
        String password
) {}
