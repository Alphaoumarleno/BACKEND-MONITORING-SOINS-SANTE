package GUICAM.tech.ms_soins_sante.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "administration")
public class AdministrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "administ_id")
    private Long administId;

    private String nom;
    private String prenom;
    private String specialite;
    private String phone_index;
    private String telephone;
    private String email;
    private String numero_ordre;
    private String disponibilite;
    private String statut;
}
