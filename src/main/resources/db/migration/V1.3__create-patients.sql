<<<<<<< HEAD
CREATE TABLE IF NOT EXISTS patients (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    civility VARCHAR(50),
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    datenaissance DATE NOT NULL,
    sexe VARCHAR(10),
    phoneindex VARCHAR(5),
    telephone VARCHAR(15),
    email VARCHAR(50) UNIQUE,
    adresse VARCHAR(100),
    ville VARCHAR(100),
    code_postal VARCHAR(20),
    password VARCHAR(255)
);
=======
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
>>>>>>> b85821c (Ajout du fichier readme.md)
