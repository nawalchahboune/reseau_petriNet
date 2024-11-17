package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Metier.ArcEntrant;
import Metier.ArcSortantNormal;
import Metier.ArcVideur;
import Metier.ArcZero;
import Metier.Place;
import Metier.Transition;

class PlaceTests {

	@Test
	void test() {
		Place p1 = new Place();
		Place p2 = new Place();
		Place p3= new Place();
		Place p4 = new Place();
		Transition t = new Transition();
		ArcSortantNormal arcSN= assertDoesNotThrow(()->new ArcSortantNormal(3, p3, t));
		ArcZero arcZero =assertDoesNotThrow(()-> new ArcZero(p1, t));
		ArcVideur arcVideur =assertDoesNotThrow(()-> new ArcVideur(p2, t));
		ArcEntrant arcEntrant =assertDoesNotThrow(()-> new ArcEntrant(4,p4, t));
		
		assertEquals(1,p4.getArcsEntrants().size());
		assertEquals(1,p1.getArcsSortants().size());
		assertEquals(1,p2.getArcsSortants().size());
		assertEquals(1,p3.getArcsSortants().size());
		p4.remove_from_arc_entrant(arcEntrant);
		p3.remove_from_arc_Sortant(arcSN);
		p2.remove_from_arc_Sortant(arcVideur);
		p1.remove_from_arc_Sortant(arcZero);
		assertEquals(0,p4.getArcsEntrants().size());
		assertEquals(0,p1.getArcsSortants().size());
		assertEquals(0,p2.getArcsSortants().size());
		assertEquals(0,p3.getArcsSortants().size());
		
		
		
	}
	@Test
	void testToString() {
	    // Création d'une Place avec des jetons
	    Place P = assertDoesNotThrow(()->new Place(5));

	    // Ajout d'arcs sortants
	    Transition T1 = new Transition();
	    Transition T2 = new Transition();
	    
	    ArcSortantNormal arcSN= assertDoesNotThrow(()->new ArcSortantNormal(3, P, T2));
		
		ArcEntrant arcEntrant =assertDoesNotThrow(()-> new ArcEntrant(4,P, T1));
		
	   
	    // Génération de la chaîne attendue
	    String expected = "place avec 5 :: arcs=> 1 arc(s) sortant(s) normal / 0 arc(s) sortant(s) videur 0 arc(s) sortant(s) zero ///1 arc(s) entrant(s)  ";

	    // Vérification
	    assertEquals(expected, P.toString());
	    
	    
	}


}
