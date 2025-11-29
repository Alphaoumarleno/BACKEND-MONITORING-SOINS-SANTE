package GUICAM.tech.ms_soins_sante.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rendezVous")
public class RendezVousEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rendezVous_id")
    private Long rendezVousId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    private PatientEntity patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medecin_id", referencedColumnName = "medecin_id")
    private MedecinEntity medecin;

    // Dans ta table SQL, les colonnes s’appellent "date" et "heure"
    @Column(name = "date")
    private LocalDate dateRendezVous;

    @Column(name = "heure")
    private LocalTime heureRendezVous;

    @Enumerated(EnumType.STRING)
    private StatutRendezVous statut;

    private String motif;
}
