<<<<<<< HEAD
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
=======
CREATE TABLE IF NOT EXISTS patients (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    civility VARCHAR(50),
>>>>>>> a19c632 (Ajout du fichier readme.md)
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    datenaissance DATE NOT NULL,
    sexe VARCHAR(10),
    phoneindex VARCHAR(5),
    telephone VARCHAR(15),
    email VARCHAR(50) UNIQUE,
    adresse VARCHAR(100),
    ville VARCHAR(100),
<<<<<<< HEAD
    code_postal VARCHAR(20)  -- Augmentation de la taille pour des formats variés
);
>>>>>>> b85821c (Ajout du fichier readme.md)
=======
    code_postal VARCHAR(20),
    password VARCHAR(255)
);
>>>>>>> a19c632 (Ajout du fichier readme.md)
