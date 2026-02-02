CREATE TABLE rendezVous (
    rendezVous_id INT PRIMARY KEY,
    date DATE NOT NULL,
    motif VARCHAR(100) NOT NULL,
    heure TIME NOT NULL,
    patient_id INT NOT NULL,
    medecin_id INT NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
    FOREIGN KEY (medecin_id) REFERENCES medecins(medecin_id)
);