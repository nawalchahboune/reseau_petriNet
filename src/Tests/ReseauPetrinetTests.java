package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exceptions.ExistingArc;
import Exceptions.NullPlaceException;
import Exceptions.NullTArcException;
import Exceptions.NullTransitionException;
import Metier.ArcEntrant;
import Metier.ArcSortant;
import Metier.ArcSortantNormal;
import Metier.Place;
import Metier.Reseau_Petri;
import Metier.Transition;

class ReseauPetrinetTests {

	@Test
	void test() {
		
		
		Reseau_Petri network = new Reseau_Petri();
		Transition t0 = new Transition();
		Place p1 =  assertDoesNotThrow( ()->new Place(2));
		Place p2 = assertDoesNotThrow( ()->new Place(1));
		Place p3 = assertDoesNotThrow( ()-> new Place(4));
		Transition t1= new Transition();
		ArcSortantNormal arcp1t1= assertDoesNotThrow( ()->new ArcSortantNormal(1, p1, t1));
		ArcEntrant arct1p2 = assertDoesNotThrow( ()->  new ArcEntrant(1, p2, t1));
		ArcEntrant arct1p3 = assertDoesNotThrow( ()->  new ArcEntrant(1, p3, t1));
		
		
		assertDoesNotThrow( ()->network.ajouter_Place(p1));
		assertDoesNotThrow( ()->network.ajouter_Place(p2));
		assertDoesNotThrow( ()->network.ajouter_Place(p3));
		assertDoesNotThrow( ()->network.ajouter_Tarnsition(t1));
		assertDoesNotThrow( ()->network.ajouter_Arc(arcp1t1));
		assertDoesNotThrow( ()->network.ajouter_Arc(arct1p2));
		assertDoesNotThrow( ()->network.ajouter_Arc(arct1p3));
		String exp= "transition, 2 arc(s) sortant(s) // arc(s) entrant(s) ==> 1 arc(s) entrant(s) normal / 0 arc(s) entrant(s) videur / 0 arc(s) entrant(s) zero ."+"\n"+
				
				"place avec 2 :: arcs=> 1 arc(s) sortant(s) normal / 0 arc(s) sortant(s) videur 0 arc(s) sortant(s) zero ///0 arc(s) entrant(s)  "+"\n"+
				"place avec 1 :: arcs=> 0 arc(s) sortant(s) normal / 0 arc(s) sortant(s) videur 0 arc(s) sortant(s) zero ///1 arc(s) entrant(s)  "+"\n"+
				"place avec 4 :: arcs=> 0 arc(s) sortant(s) normal / 0 arc(s) sortant(s) videur 0 arc(s) sortant(s) zero ///1 arc(s) entrant(s)  "+"\n"+
				"arc simple poids 1 ( place avec 2 jetons vers transition"+"\n"+
				"arc simple poids 1( transition vers place avec  1 jetons"+"\n"+
				"arc simple poids 1( transition vers place avec  4 jetons"+"\n";
		
		

	   assertEquals(exp, network.toString());
	}
	
	@Test
	void modificationJetons() {
		Reseau_Petri network = new Reseau_Petri();
		Transition t0 = new Transition();
		Place p1 =  assertDoesNotThrow( ()->new Place(2));
		Place p2 = assertDoesNotThrow( ()->new Place(1));
		Place p3 = assertDoesNotThrow( ()-> new Place(4));
		Transition t1= new Transition();
		ArcSortantNormal arcp1t1= assertDoesNotThrow( ()->new ArcSortantNormal(1, p1, t1));
		ArcEntrant arct1p2 = assertDoesNotThrow( ()->  new ArcEntrant(1, p2, t1));
		ArcEntrant arct1p3 = assertDoesNotThrow( ()->  new ArcEntrant(1, p3, t1));
		
		
		assertDoesNotThrow( ()->network.ajouter_Place(p1));
		assertDoesNotThrow( ()->network.ajouter_Place(p2));
		assertDoesNotThrow( ()->network.ajouter_Place(p3));
		assertDoesNotThrow( ()->network.ajouter_Tarnsition(t1));
		assertDoesNotThrow( ()->network.ajouter_Arc(arcp1t1));
		assertDoesNotThrow( ()->network.ajouter_Arc(arct1p2));
		assertDoesNotThrow( ()->network.ajouter_Arc(arct1p3));
		Exception e = assertThrows(NullPlaceException.class, ()->{
			network.ajouterJetons(null, 3);
		});
		assertEquals("place est null !!! ", e.getMessage());
		
		Exception e2 = assertThrows(NullTArcException.class, ()->{
			network.changerPoids(null, 0);
		});
		assertEquals("arc null !!! ", e2.getMessage());
		assertEquals(4, p3.getJetons());
		assertDoesNotThrow(()->network.ajouterJetons(p3, 2));
		assertEquals(6, p3.getJetons());
		assertDoesNotThrow(()->network.enleverJetons(p3, 3));
		assertEquals(3, p3.getJetons());
		assertDoesNotThrow(()->network.changerPoids(arcp1t1, 4));
		assertEquals(4, arcp1t1.getPoids());
		Exception e3 = assertThrows(ExistingArc.class, ()->{
			network.ajouter_Arc(arct1p3);
		});
		assertEquals("arc already exists", e3.getMessage());
		Exception e4 = assertThrows(NullTArcException.class, ()->{
			network.ajouter_Arc(null);
		});
		assertEquals("arc null !!! ", e4.getMessage());
		
		Exception e5 = assertThrows(NullPlaceException.class, ()->{
			network.ajouter_Place(null);
		});
		assertEquals("place est null !!! ", e5.getMessage());
		Exception e6 = assertThrows(NullTransitionException.class, ()->{
			network.ajouter_Tarnsition(null);
		});
		assertEquals("transition null !!", e6.getMessage());
		
		
		
		
	}

}
