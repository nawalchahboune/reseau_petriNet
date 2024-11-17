# Réseau de Petri - Modélisation en Java

## Description

Ce projet implémente un réseau de Petri à l'aide de classes Java. Un réseau de Petri est un modèle mathématique utilisé pour représenter des systèmes concurrents et distribués. Il est composé de places, de transitions et d'arcs, et est souvent utilisé pour modéliser des processus où des ressources (jetons) sont consommées et produites.

Ce projet permet de créer et de manipuler des réseaux de Petri avec des mécanismes d'activation de transitions et de gestion des jetons dans les places associées.

## Structure du projet

Le projet est structuré en plusieurs classes qui représentent les éléments principaux d'un réseau de Petri.

### 1. **Classe `Place`**
   - Représente une place dans le réseau de Petri.
   - Chaque place possède un certain nombre de jetons et peut avoir des arcs entrants et sortants.
   - Les méthodes principales incluent :
     - `getJetons()`: Obtient le nombre de jetons.
     - `setJetons()`: Définit le nombre de jetons.
     - `enleverJetons()`: Enlève un certain nombre de jetons.
     - `add_to_arc_sortant()` / `add_to_arc_entrant()`: Ajoute des arcs sortants/entrants.

### 2. **Classe `Transition`**
   - Représente une transition dans le réseau de Petri.
   - Elle est liée à des arcs entrants (conditions) et sortants (actions).
   - Les méthodes principales incluent :
     - `setTirable()` / `isTirable()`: Définit ou vérifie si la transition peut être activée (tirée).
     - `add_to_arc_sortant()` / `add_to_arc_entrant()`: Ajoute des arcs sortants/entrants.
     - `remove_from_arc_Sortant()` / `remove_from_arc_entrant()`: Retire des arcs sortants/entrants.

### 3. **Classe `Arc` (Abstraite)**
   - Représente un arc dans le réseau de Petri, connecté à une place et une transition.
   - Les arcs peuvent être entrants ou sortants, et ont un poids (pour modéliser les relations entre places et transitions).

### 4. **Classes `ArcSortant` et `ArcEntrant`**
   - Ces classes sont des sous-classes d'`Arc` et représentent respectivement les arcs sortants et entrants d'une place.
   - Chaque arc sortant ou entrant a un poids et peut être activé (en fonction des jetons dans les places).
   - Les méthodes principales incluent :
     - `update_jeton_place()`: Met à jour le nombre de jetons dans une place.
     - `arcIsFireable()`: Vérifie si un arc peut être activé (si le nombre de jetons de la place associée est suffisant).

### 5. **Classes spécialisées d'arc sortant**
   - **`ArcSortantNormal`** : Arc sortant avec un poids normal.
   - **`ArcVideur`** : Arc sortant qui vide la place associée (remet le nombre de jetons à 0).
   - **`ArcZero`** : Arc sortant qui est activé uniquement lorsque la place associée a exactement 0 jeton.

### 6. **Interface `IReseauPetri`**
   - Déclare les principales opérations permettant de manipuler un réseau de Petri, telles que l'ajout et la suppression de places, de transitions et d'arcs.

## Fonctionnalités

- **Ajout et suppression de places et de transitions** dans le réseau de Petri.
- **Gestion des jetons** : ajout, retrait et mise à jour du nombre de jetons dans chaque place.
- **Activation de transitions** : en fonction des arcs entrants et de la quantité de jetons dans les places associées.
- **Vérification de la "tirabilité"** des transitions : une transition peut être activée si tous les arcs entrants sont activables.
- **Modélisation de différents types d'arcs sortants** (normal, videur, zéro), chacun ayant son propre comportement lors de l'activation de la transition.

## Installation

1. Clonez ce dépôt sur votre machine locale :

   ```bash
   git clone https://github.com/username/repository-name.git

## Utilisation
Voici un exemple simple d'utilisation d'un réseau de Petri avec des places, des transitions et des arcs :


public class Main {
    public static void main(String[] args) {
        try {
            // Création des places avec un nombre de jetons initial
            Place place1 = new Place(5);
            Place place2 = new Place(0);
            
            // Création d'une transition
            Transition transition = new Transition();

            // Création d'un arc entrant et sortant
            ArcEntrant arcEntrant = new ArcEntrant(1, place1, transition);
            ArcSortantNormal arcSortant = new ArcSortantNormal(1, place2, transition);

            // Ajouter l'arc sortant et entrant à la transition
            transition.add_to_arc_sortant(arcSortant);
            transition.add_to_arc_entrant(arcEntrant);

            // Vérifier si la transition peut être activée
            if (transition.isTirable()) {
                // Si tirable, activer la transition
                transition.setTirable(true);
                System.out.println("Transition activée !");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

## Tests
Des tests unitaires sont disponibles dans le dossier Tests. Assurez-vous de les exécuter pour vérifier que le réseau de Petri fonctionne comme prévu.
## Licence
Ce projet est sous licence MIT


   

