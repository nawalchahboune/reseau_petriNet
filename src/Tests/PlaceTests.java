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
	    Place P1 = assertDoesNotThrow(()->new Place(5));
	    Place P2 = assertDoesNotThrow(()->new Place(5));
	    Place P3 = assertDoesNotThrow(()->new Place(5));
	    Place P4 = assertDoesNotThrow(()->new Place(5));

	    // Ajout d'arcs sortants
	    Transition T1 = new Transition();
	    Transition T2 = new Transition();
	    
	    ArcSortantNormal arcSN= assertDoesNotThrow(()->new ArcSortantNormal(3, P1, T2));
	    ArcVideur arcV=  assertDoesNotThrow(()->new ArcVideur(P2, T2));
	    ArcZero arcZero=  assertDoesNotThrow(()->new ArcZero(P3, T2));
		ArcEntrant arcEntrant1 =assertDoesNotThrow(()-> new ArcEntrant(4,P1, T1));
		ArcEntrant arcEntrant2 =assertDoesNotThrow(()-> new ArcEntrant(4,P2, T1));
		ArcEntrant arcEntrant3 =assertDoesNotThrow(()-> new ArcEntrant(4,P3, T1));
		
	
	    // Génération de la chaîne attendue
	    String expected1 = "place avec 5 :: arcs=> 1 arc(s) sortant(s) normal / 0 arc(s) sortant(s) videur 0 arc(s) sortant(s) zero ///1 arc(s) entrant(s)  ";
	    String expected2 = "place avec 5 :: arcs=> 0 arc(s) sortant(s) normal / 1 arc(s) sortant(s) videur 0 arc(s) sortant(s) zero ///1 arc(s) entrant(s)  ";
	    String expected3 = "place avec 5 :: arcs=> 0 arc(s) sortant(s) normal / 0 arc(s) sortant(s) videur 1 arc(s) sortant(s) zero ///1 arc(s) entrant(s)  ";

	    // Vérification
	    assertEquals(expected1, P1.toString());
	    assertEquals(expected2, P2.toString());
	    assertEquals(expected3, P3.toString());
	    
	    
	}


}
