package GUICAM.tech.ms_soins_sante.entities;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> a19c632 (Ajout du fichier readme.md)
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "consultations")
public class ConsultationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consultation_id")
    private Long consultationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    private PatientEntity patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medecin_id", referencedColumnName = "medecin_id")
    private MedecinEntity medecin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rendezVous_id", referencedColumnName = "rendezVous_id")
    private RendezVousEntity rendezVous;

    @Column(name = "date_consultation")
    private LocalDate dateConsultation;

    private String motif;
    private String diagnostic;
    private String notes;
<<<<<<< HEAD
=======
public class ConsultationEntity {
>>>>>>> b85821c (Ajout du fichier readme.md)
=======
>>>>>>> a19c632 (Ajout du fichier readme.md)
}
