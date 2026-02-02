# 👶 MS-GESTION-NAISSANCES  
### Système de gestion des déclarations de naissance

🎓 **Projet académique – Cycle Ingénieur (Cloud & Systèmes Distribués)**

---

## 🧭 Vue d’ensemble

**MS-GESTION-NAISSANCES** est une application **full-stack** destinée à la gestion et à la
digitalisation des déclarations de naissance au sein d’un établissement de santé
ou d’une administration d’état civil.

Le projet est structuré autour :
- d’un **backend Spring Boot** exposant une API REST sécurisée,
- d’un **frontend React** (dossier `website-naissance`) pour l’interface utilisateur,
- d’un **pipeline CI/CD** pour l’automatisation des builds et du déploiement.

---
![Schéma d’architecture](screenshots/login.png)
## 🎯 Objectifs du projet

- Digitaliser le processus de déclaration de naissance
- Centraliser et sécuriser les données d’état civil
- Réduire les erreurs et les doublons
- Assurer la traçabilité des opérations
- Mettre en place une architecture full-stack maintenable
- Automatiser l’intégration et le déploiement via CI/CD

---

##  Architecture du système
![Schéma d’architecture](screenshots/architecture.png)
**Frontend (React – website-naissance)**  
⬇ API REST  
**Backend (Spring Boot)**  
⬇  
**Base de données relationnelle**

L’architecture repose sur une séparation claire :
- présentation (React),
- logique métier (Spring Services),
- persistance (Spring Data JPA).

---

## 📁 Structure du projet

```text
MS-GESTION-NAISSANCES/
├── src/                     # Backend Spring Boot
│   ├── main/
│   └── test/
├── website-naissance/       # Frontend React
│   ├── src/
│   ├── public/
│   └── package.json
├── .github/workflows/       # CI/CD (GitHub Actions)
├── pom.xml                  # Configuration Maven
└── README.md
