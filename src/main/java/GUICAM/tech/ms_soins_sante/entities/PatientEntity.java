package GUICAM.tech.ms_soins_sante.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="patients")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long patientId;

    @Enumerated(EnumType.STRING)
    private Civility civility;
    private String nom;
    private String prenom;
    private String sexe;
    private String phoneindex;
    private String telephone;
    private String email;
    private String adresse;
    private String ville;
    @Column(name = "datenaissance")
    private LocalDate datenaissance;
    @Column(name = "code_postal")
    private String codePostal;
    private String password;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<RendezVousEntity> rendezVousList;

}
