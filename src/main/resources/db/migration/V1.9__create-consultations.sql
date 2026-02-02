CREATE TABLE consultations (
    consultation_id INT PRIMARY KEY AUTO_INCREMENT,
    date_consultation DATE NOT NULL,
    motif VARCHAR(255),
    diagnostic VARCHAR(255),
    notes VARCHAR(255),
    patient_id INT NOT NULL,
    medecin_id INT NOT NULL,
    rendezVous_id INT,
    FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
    FOREIGN KEY (medecin_id) REFERENCES medecins(medecin_id),
    FOREIGN KEY (rendezVous_id) REFERENCES rendezVous(rendezVous_id)
);
