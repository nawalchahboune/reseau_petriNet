package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Metier.ArcEntrant;
import Metier.ArcSortantNormal;
import Metier.ArcVideur;
import Metier.Place;
import Metier.Reseau_Petri;
import Metier.Transition;

class TestSuppression {
	
	// Test de suppression de places et transitions du réseau de Petri
	@Test
	void SPT0() {
		   Reseau_Petri  network = new Reseau_Petri();
		   /// Initialisation de deux places et deux transitions sans erreurs
		   Place p1 =assertDoesNotThrow(()-> new Place(2));
		   Place p2 =assertDoesNotThrow(()-> new Place(2));
		   Transition t2 =assertDoesNotThrow(()-> new Transition());
		   Transition t = assertDoesNotThrow(()-> new Transition());
		   
		   // Ajout des places et transitions au réseau
		   assertDoesNotThrow(()-> network.ajouter_Place(p1));
		   assertDoesNotThrow(()-> network.ajouter_Place(p2));
		   assertDoesNotThrow(()-> network.ajouter_Tarnsition(t));
		   assertDoesNotThrow(()-> network.ajouter_Tarnsition(t2));
		   
		   // Vérification de l'état initial du réseau : 2 places et 2 transitions ajoutées
		   assertEquals(2, network.getPlaces().size());
		   assertEquals(2, network.getTransitions().size());

	        // Suppression de la place p2 et de la transition t
		   assertDoesNotThrow(()-> network.supprimer_Place(p2));
		   assertDoesNotThrow(()-> network.supprimer_Tarnsition(t));
		   // Vérification que le réseau contient maintenant une seule place et une seule transition
		   assertEquals(1, network.getPlaces().size());
		   assertEquals(1, network.getTransitions().size());
	
		   
	}
	
	// Test de suppression et de réajout d'arcs, avec maintien de places et transitions
	@Test 
	void SPT1() {
		   Reseau_Petri  network = new Reseau_Petri();
		// Initialisation de trois places et d'une transition
		   Place p1 =assertDoesNotThrow(()-> new Place(2));
		   Place p2 =assertDoesNotThrow(()-> new Place(2));
		   Place p3 =assertDoesNotThrow(()-> new Place(2));
		   Transition t = assertDoesNotThrow(()-> new Transition());
		   
		// Création et ajout d'arcs connectant les places à la transition
		   ArcSortantNormal arc1= assertDoesNotThrow(()-> new ArcSortantNormal(1, p1, t));
		   ArcVideur arc2 = assertDoesNotThrow( ()-> new ArcVideur(p2, t));
		   ArcEntrant arc3= assertDoesNotThrow(()-> new ArcEntrant(1, p3, t));
		   
		// Ajout des places, transition et arcs au réseau
		   assertDoesNotThrow(()->network.ajouter_Place(p1));
		   assertDoesNotThrow(()->network.ajouter_Place(p2));
		   assertDoesNotThrow(()->network.ajouter_Place(p3));
		   
		   assertDoesNotThrow(()->network.ajouter_Tarnsition(t));
		   
		   assertDoesNotThrow(()->network.ajouter_Arc(arc1));
		   assertDoesNotThrow(()->network.ajouter_Arc(arc2));
		   assertDoesNotThrow(()->network.ajouter_Arc(arc3));
		   
		// Vérification de l'état initial : 3 arcs, 3 places et 1 transition
		   assertEquals(3, network.getArcs().size());
		   assertEquals(3, network.getPlaces().size());
		   assertEquals(1, network.getTransitions().size());
		// Suppression de deux arcs
		   assertDoesNotThrow(()->network.supprimer_Arc(arc1));
		   assertDoesNotThrow(()->network.supprimer_Arc(arc3));
		   
		   
		// Vérification de l'état après suppression : 1 arc restant
		   assertEquals(1, network.getArcs().size());
		   assertEquals(3, network.getPlaces().size());
		   assertEquals(1, network.getTransitions().size());
		   
		// Réajout de l'arc supprimé arc3 pour vérification du bon fonctionnement
		   assertDoesNotThrow(()->network.ajouter_Arc(arc3));
		   
		   // Vérification finale : 2 arcs présents après le réajout
		   assertEquals(2, network.getArcs().size());
		   assertEquals(3, network.getPlaces().size());
		   assertEquals(1, network.getTransitions().size()); 
		   
		   
	}

}
