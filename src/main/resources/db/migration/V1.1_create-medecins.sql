CREATE TABLE Medecins (
    medecin_id INT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    specialite VARCHAR(50),
    phoneindex VARCHAR(5),
    telephone VARCHAR(15),  -- Changement en VARCHAR pour les numéros de téléphone
    email VARCHAR(100) NOT NULL, -- Augmenté pour accommoder des adresses complètes
    numero_ordre VARCHAR(50),
    disponibilite VARCHAR(50),
    statut VARCHAR(50)
);
