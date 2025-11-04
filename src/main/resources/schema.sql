DROP DATABASE IF EXISTS db_soins_santes;
USE db_soins_santes;
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

CREATE TABLE Patients (
    patient_id INT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    date_naissance DATE NOT NULL,
    sexe VARCHAR(10),  -- Généralement suffisant pour "masculin", "féminin", etc.
    phoneindex VARCHAR(5),
    telephone VARCHAR(15),  -- Utilisation de VARCHAR pour permettre les codes pays, formats variés
    email VARCHAR(50) UNIQUE, -- Ajout de UNIQUE pour garantir des emails uniques
    adresse VARCHAR(100),
    ville VARCHAR(100),
    code_postal VARCHAR(20)  -- Augmentation de la taille pour des formats variés
);

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

CREATE TABLE Administrateur (
    administ_id INT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    specialite VARCHAR(50),
    phone_index VARCHAR(5),
    telephone VARCHAR(15),
    email VARCHAR(100) NOT NULL,
    numero_ordre VARCHAR(50),
    disponibilite VARCHAR(50),
    statut VARCHAR(50) NOT NULL
);