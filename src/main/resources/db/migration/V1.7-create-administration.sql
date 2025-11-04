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
