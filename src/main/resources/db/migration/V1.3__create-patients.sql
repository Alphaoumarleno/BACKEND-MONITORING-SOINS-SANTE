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