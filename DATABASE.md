# FstBank EJB Project

## Description
Ce projet est une application bancaire basée sur **EJB** et **WildFly**.  
La base de données utilisée est **H2 en mémoire**, donc **toutes les données sont perdues à l’arrêt du serveur**.  
Idéal pour le développement et les tests.

---

## Prérequis
- Java JDK 19 ou supérieur
- WildFly 38.0.1.Final
- Maven (si vous voulez compiler le projet)

---

## Installation et exécution

1. **Cloner le projet**
- bash :
    git clone <URL_DU_PROJET>
    cd <nom_du_projet> 

## Démarrer WildFly
Assurez-vous que WildFly est installé.
Lancer le serveur avec : 
 -  C:\wildfly-38.0.1.Final\bin\standalone.bat
 ou 
 - faire un : cd C:\wildfly-38.0.1.Final\bin 
   puis  : standalone.bat 

- L’H2 database sera créée automatiquement en mémoire au démarrage.

## Déployer le projet
Copier le .jar compilé dans :
- C:\wildfly-38.0.1.Final\standalone\deployments\

WildFly va automatiquement déployer le fichier.
