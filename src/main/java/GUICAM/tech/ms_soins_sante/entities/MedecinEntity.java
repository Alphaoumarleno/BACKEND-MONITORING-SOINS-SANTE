package GUICAM.tech.ms_soins_sante.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medecins")
public class MedecinEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medecin_id")
    private Long medecinId;

    private String nom;
    private String prenom;
    private String specialite;
    private String phoneindex;
    private String telephone;
    private String email;
    @Column(name = "numero_ordre")
    private String numeroOrdre;
    private String disponibilite;
    private String statut;

    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL)
    private List<RendezVousEntity> rendezVousList;
}
