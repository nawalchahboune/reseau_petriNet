package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Metier.ArcEntrant;
import Metier.ArcSortantNormal;
import Metier.Place;
import Metier.Reseau_Petri;
import Metier.Transition;

class testFireAll {

	@Test
	void testFireAll() {
		 Reseau_Petri network= new Reseau_Petri();
		 // Création des places avec un nombre de jetons initial
		 Place place1 =assertDoesNotThrow(()-> new Place(5));
		 Place place2 = assertDoesNotThrow(()->new Place(6));
		 
		 // Création d'une transition
		 Transition transition = new Transition();

		 // Création d'un arc entrant et sortant
		 ArcEntrant arcEntrant = assertDoesNotThrow(()->new ArcEntrant(1, place1, transition));
		 ArcSortantNormal arcSortant =assertDoesNotThrow(()-> new ArcSortantNormal(1, place2, transition));
		Transition t2= new Transition();
		 ArcEntrant arcEntrant2 = assertDoesNotThrow(()->new ArcEntrant(1, place1, t2));
		 ArcSortantNormal arcSortant2 =assertDoesNotThrow(()-> new ArcSortantNormal(1, place2, t2));
		 assertDoesNotThrow(()-> network.ajouter_Place(place1));
		 assertDoesNotThrow(()->network.ajouter_Place(place2));
		 assertDoesNotThrow(()->network.ajouter_Tarnsition( transition));
		 assertDoesNotThrow(()->network.ajouter_Tarnsition( t2));
		 assertDoesNotThrow(()->network.ajouter_Arc(arcEntrant));
		 assertDoesNotThrow(()->network.ajouter_Arc(arcSortant));
		 assertDoesNotThrow(()->network.ajouter_Arc(arcEntrant2));
		 assertDoesNotThrow(()->network.ajouter_Arc(arcSortant2));
		 network.fireAll();
		 assertEquals(11,place1.getJetons());
		 assertEquals(0, place2.getJetons());
		 assertEquals(false,transition.isTirable());
		 assertEquals(false, t2.isTirable());
	}

}
