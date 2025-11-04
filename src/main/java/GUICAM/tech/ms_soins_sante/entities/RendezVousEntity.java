package GUICAM.tech.ms_soins_sante.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RendezVous")
public class RendezVousEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rendezVous_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    private PatientEntity patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medecin_id", referencedColumnName = "medecin_id")
    private MedecinEntity medecin;

    @Column(name = "date_rdv")
    private LocalDate dateRendezVous;

    @Column(name = "heure_rdv")
    private LocalTime heureRendezVous;

    @Enumerated(EnumType.STRING)
    private StatutRendezVous statut;

    private String motif;
    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL)
    private List<RendezVousEntity> rendezVousList;

}

