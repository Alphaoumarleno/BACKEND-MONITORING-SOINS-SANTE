package GUICAM.tech.ms_soins_sante.DTO;

public record AdministrationDTO(
        String nom,
        String prenom,
        String specialite,
        String phone_index,
        String email,
        String numero_ordre,
        String disponibilite,
        String statut
) {}
