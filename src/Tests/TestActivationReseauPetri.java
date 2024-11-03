package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exceptions.ExistingArc;
import Exceptions.NegativeToken;
import Exceptions.NullPlaceException;
import Exceptions.NullTArcException;
import Exceptions.NullTransitionException;
import Exceptions.UnknownPlaceException;
import Exceptions.UnknownTransitionException;
import Metier.ArcEntrant;
import Metier.ArcSortant;
import Metier.ArcSortantNormal;
import Metier.ArcVideur;
import Metier.Place;
import Metier.Reseau_Petri;
import Metier.Transition;

public class TestActivationReseauPetri {
	
	private Reseau_Petri network ;
	//Transition
	private Transition t0;
	//Places entrantes
	private Place p0 ;
	private Place p1 ;
	private Place p2 ;
	private Place p3 ;
	
	//Places sortantes
	private Place p4 ;
	private Place p5 ;
	private Place p6 ;

	public TestActivationReseauPetri() {
		// TODO Auto-generated constructor stub
	}
	
	//Le nom des fonctions de test correspond au code du CAS à tester !!
	
	@BeforeEach
	void setup() throws NegativeToken, NullPlaceException, NullTransitionException {
		//Reseau de Petri
		network = new Reseau_Petri();
		//Transition
		t0 = new Transition();
		//Places entrantes
		p0 = new Place(10);
		p1 = new Place(2);
		p2 = new Place(1);
		p3 = new Place(0);
		
		//Places sortantes
		 p4 = new Place(5);
		 p5 = new Place(3);
		 p6 = new Place(4);	
		
		
	}
	
	@Test
	void testRS0() throws NullTransitionException {
		network.ajouter_Tarnsition(t0);
		network.fireAll();
	}
	@Test
	void testRS1() throws NullPlaceException, NullTransitionException, NullTArcException, ExistingArc, UnknownPlaceException, UnknownTransitionException, NegativeToken {
		network.ajouter_Place(p3);
		network.ajouter_Tarnsition(t0);
		ArcSortantNormal arc0 = new ArcSortantNormal(1,p3, t0);
		network.ajouter_Arc(arc0);
		network.fire(t0);
		
		assertEquals(0,p3.getJetons());
	}
	
	@Test
	void testRS2() throws NullPlaceException, NullTransitionException, NullTArcException, ExistingArc, UnknownPlaceException, UnknownTransitionException, NegativeToken {
		network.ajouter_Place(p1);
		network.ajouter_Tarnsition(t0);
		ArcSortantNormal arc0 = new ArcSortantNormal(1,p1, t0);
		network.ajouter_Arc(arc0);
		network.fire(t0);
		
		assertEquals(1,p1.getJetons());
	}
	
	@Test
	void testRS3() throws NullPlaceException, NullTransitionException, NullTArcException, ExistingArc, UnknownPlaceException, UnknownTransitionException, NegativeToken {
		network.ajouter_Place(p4);
		network.ajouter_Tarnsition(t0);
		ArcSortantNormal arc0 = new ArcSortantNormal(3,p4, t0);
		network.ajouter_Arc(arc0);
		network.fire(t0);
		
		assertEquals(2,p4.getJetons());
	}
	
	@Test
	void testRS4() throws NullPlaceException, NullTransitionException, NullTArcException, ExistingArc, UnknownPlaceException, UnknownTransitionException, NegativeToken {
		network.ajouter_Place(p3);
		network.ajouter_Tarnsition(t0);
		ArcEntrant arc0 = new ArcEntrant(1,p3, t0);
		network.ajouter_Arc(arc0);
		network.fire(t0);
		
		assertEquals(1,p3.getJetons());
	}
	
	@Test
	void testRS5() throws NullPlaceException, NullTransitionException, NullTArcException, ExistingArc, UnknownPlaceException, UnknownTransitionException, NegativeToken {
		network.ajouter_Place(p3);
		network.ajouter_Tarnsition(t0);
		ArcEntrant arc0 = new ArcEntrant(2,p3, t0);
		network.ajouter_Arc(arc0);
		network.fire(t0);
		
		assertEquals(2,p3.getJetons());
	}
	@Test
	void testRS6() throws NullPlaceException, NullTransitionException, NullTArcException, ExistingArc, UnknownPlaceException, UnknownTransitionException, NegativeToken {
		network.ajouter_Place(p1);
		network.ajouter_Tarnsition(t0);
		ArcVideur arc0 = new ArcVideur (p1, t0);
		network.ajouter_Arc(arc0);
		network.fire(t0);
		
		assertEquals(0,p1.getJetons());
	}
	
	@Test
	void testRS7() throws NullPlaceException, NullTransitionException, NullTArcException, ExistingArc, UnknownPlaceException, UnknownTransitionException, NegativeToken {
		network.ajouter_Place(p1);
		network.ajouter_Place(p3);
		network.ajouter_Tarnsition(t0);
		ArcSortantNormal arc0 = new ArcSortantNormal(1,p3, t0);
		ArcEntrant arc1 = new ArcEntrant(1,p1, t0);
		network.ajouter_Arc(arc0);
		network.ajouter_Arc(arc1);
		network.fire(t0);
		
		assertEquals(0,p3.getJetons());
		assertEquals(2,p1.getJetons());
	}
	@Test
	void testRS8() throws NullPlaceException, NullTransitionException, NullTArcException, ExistingArc, UnknownPlaceException, UnknownTransitionException, NegativeToken {
		network.ajouter_Place(p1);
		network.ajouter_Place(p3);
		network.ajouter_Tarnsition(t0);
		ArcVideur arc0 = new ArcVideur (p1, t0);
		ArcEntrant arc1 = new ArcEntrant(2,p3, t0);
		network.ajouter_Arc(arc0);
		network.ajouter_Arc(arc1);
		network.fire(t0);
		
		assertEquals(2,p3.getJetons());
		assertEquals(0,p1.getJetons());
	}

}
