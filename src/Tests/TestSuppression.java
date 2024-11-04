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
	

	@Test
	void testSupressionPlaceEtTransition() {
		   Reseau_Petri  network = new Reseau_Petri();
		   Place p1 =assertDoesNotThrow(()-> new Place(2));
		   Place p2 =assertDoesNotThrow(()-> new Place(2));
		   Transition t2 =assertDoesNotThrow(()-> new Transition());
		   Transition t = assertDoesNotThrow(()-> new Transition());
		   assertDoesNotThrow(()-> network.ajouter_Place(p1));
		   assertDoesNotThrow(()-> network.ajouter_Place(p2));
		   assertDoesNotThrow(()-> network.ajouter_Tarnsition(t));
		   assertDoesNotThrow(()-> network.ajouter_Tarnsition(t2));
		   

		   assertEquals(2, network.getPlaces().size());
		   assertEquals(2, network.getTransitions().size());
		   
		   assertDoesNotThrow(()-> network.supprimer_Place(p2));
		   assertDoesNotThrow(()-> network.supprimer_Tarnsition(t));
		   
		   assertEquals(1, network.getPlaces().size());
		   assertEquals(1, network.getTransitions().size());
	
		   
	}
	@Test 
	void testSupressionArc() {
		 Reseau_Petri  network = new Reseau_Petri();
		   Place p1 =assertDoesNotThrow(()-> new Place(2));
		   Place p2 =assertDoesNotThrow(()-> new Place(2));
		   Place p3 =assertDoesNotThrow(()-> new Place(2));
		   Transition t = assertDoesNotThrow(()-> new Transition());
		   ArcSortantNormal arc1= assertDoesNotThrow(()-> new ArcSortantNormal(1, p1, t));
		   ArcVideur arc2 = assertDoesNotThrow( ()-> new ArcVideur(p2, t));
		   ArcEntrant arc3= assertDoesNotThrow(()-> new ArcEntrant(1, p3, t));
		   assertDoesNotThrow(()->network.ajouter_Place(p1));
		   assertDoesNotThrow(()->network.ajouter_Place(p2));
		   assertDoesNotThrow(()->network.ajouter_Place(p3));
		   
		   assertDoesNotThrow(()->network.ajouter_Tarnsition(t));
		   
		   assertDoesNotThrow(()->network.ajouter_Arc(arc1));
		   assertDoesNotThrow(()->network.ajouter_Arc(arc2));
		   assertDoesNotThrow(()->network.ajouter_Arc(arc3));
		   
		   assertEquals(3, network.getArcs().size());
		   assertEquals(3, network.getPlaces().size());
		   assertEquals(1, network.getTransitions().size());
		   
		   assertDoesNotThrow(()->network.supprimer_Arc(arc1));
		   assertDoesNotThrow(()->network.supprimer_Arc(arc3));
		   
		   assertEquals(1, network.getArcs().size());
		   assertEquals(3, network.getPlaces().size());
		   assertEquals(1, network.getTransitions().size());
		   
		   assertDoesNotThrow(()->network.ajouter_Arc(arc3));
		   
		   assertEquals(2, network.getArcs().size());
		   assertEquals(3, network.getPlaces().size());
		   assertEquals(1, network.getTransitions().size()); 
		   
		   
	}

}
