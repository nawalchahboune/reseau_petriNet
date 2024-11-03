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
import Metier.ArcZero;
import Metier.Place;
import Metier.Reseau_Petri;
import Metier.Transition;

public class TestActivationReseauPetri {
	
	private Reseau_Petri network ;
	//Transition
	private Transition t0;
	private Transition t1;
	//Places entrantes
	private Place p0 ;
	private Place p1 ;
	private Place p2 ;
	private Place p3 ;
	
	//Places sortantes
	private Place p4 ;
	private Place p5 ;
	private Place p6 ;
	private Place p7;
	private Place p8;

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
		t1 = new Transition();
		//Places entrantes
		p0 = new Place(10);
		p1 = new Place(2);
		p2 = new Place(1);
		p3 = new Place(0);
		
		//Places sortantes
		 p4 = new Place(5);
		 p5 = new Place(3);
		 p6 = new Place(4);	
		 
		 p7 = new Place(10);
		 p8 = new Place(15);
		 
		
		
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
	
	@Test
	void testARP0() throws NullPlaceException, NullTransitionException, NegativeToken, NullTArcException, ExistingArc, UnknownPlaceException, UnknownTransitionException {
		network.ajouter_Place(p1);
		network.ajouter_Place(p2);
		network.ajouter_Place(p4);
		network.ajouter_Place(p3);
		network.ajouter_Tarnsition(t0);
		ArcSortantNormal arc0 = new ArcSortantNormal(1,p1, t0);
		ArcSortantNormal arc1 = new ArcSortantNormal(1,p2, t0);
		ArcSortantNormal arc2 = new ArcSortantNormal(3,p4, t0);
		network.ajouter_Arc(arc0);
		network.ajouter_Arc(arc1);
		network.ajouter_Arc(arc2);
		
		
		
		ArcEntrant arc3 = new ArcEntrant(7,p3, t0);
		
		network.ajouter_Arc(arc3);
		network.fire(t0);
		assertEquals(true,t0.isTirable());
		assertEquals(1,p1.getJetons());
		assertEquals(0,p2.getJetons());
		assertEquals(2,p4.getJetons());
		assertEquals(7,p3.getJetons());
		
	}
	
	 /*
	 * Trace des tests de la fonction testARP1
	 *
	 * 03/11/2024 16:36 : les jetons des places sortantes ne sont pas mis à jour
	 * 03/11/2024 16:58 : les jetons des places sortantes sont mis à jour correctement
	 */
	@Test
	void testARP1() throws NullPlaceException, NullTransitionException, NegativeToken, NullTArcException, ExistingArc, UnknownPlaceException, UnknownTransitionException {
		network.ajouter_Place(p1);
		network.ajouter_Place(p2);
		network.ajouter_Place(p4);
		network.ajouter_Place(p3);
		network.ajouter_Place(p5);
		network.ajouter_Place(p6);
		network.ajouter_Tarnsition(t0);
		ArcSortantNormal arc0 = new ArcSortantNormal(1,p1, t0);
		ArcSortantNormal arc1 = new ArcSortantNormal(1,p2, t0);
		ArcSortantNormal arc2 = new ArcSortantNormal(3,p4, t0);
		network.ajouter_Arc(arc0);
		network.ajouter_Arc(arc1);
		network.ajouter_Arc(arc2);
		
		
		
		ArcEntrant arc3 = new ArcEntrant(7,p3, t0);
		ArcEntrant arc4 = new ArcEntrant(5,p5, t0);
		ArcEntrant arc5 = new ArcEntrant(4,p6, t0);
		
		network.ajouter_Arc(arc3);
		network.ajouter_Arc(arc4);
		network.ajouter_Arc(arc5);
		
		network.fire(t0);
		
		assertEquals(true,t0.isTirable());
		assertEquals(1,p1.getJetons());
		assertEquals(0,p2.getJetons());
		assertEquals(2,p4.getJetons());
		assertEquals(7,p3.getJetons());
		assertEquals(8,p5.getJetons());
		assertEquals(8,p6.getJetons());
		
		
		
		
	}
	
	@Test
	void testARP2() throws NullPlaceException, NullTransitionException, NegativeToken, NullTArcException, ExistingArc, UnknownPlaceException, UnknownTransitionException {
		network.ajouter_Place(p1);
		network.ajouter_Place(p2);
		network.ajouter_Place(p4);
		network.ajouter_Place(p3);
		network.ajouter_Place(p5);
		network.ajouter_Place(p6);
		network.ajouter_Tarnsition(t0);
		ArcSortantNormal arc0 = new ArcSortantNormal(3,p1, t0);
		ArcSortantNormal arc1 = new ArcSortantNormal(1,p2, t0);
		ArcSortantNormal arc2 = new ArcSortantNormal(3,p4, t0);
		network.ajouter_Arc(arc0);
		network.ajouter_Arc(arc1);
		network.ajouter_Arc(arc2);
		
		
		
		ArcEntrant arc3 = new ArcEntrant(7,p3, t0);
		ArcEntrant arc4 = new ArcEntrant(5,p5, t0);
		ArcEntrant arc5 = new ArcEntrant(4,p6, t0);
		
		network.ajouter_Arc(arc3);
		network.ajouter_Arc(arc4);
		network.ajouter_Arc(arc5);
		
		network.fire(t0);
		
		assertEquals(false,t0.isTirable());
		assertEquals(2,p1.getJetons());
		assertEquals(1,p2.getJetons());
		assertEquals(0,p3.getJetons());
		assertEquals(5,p4.getJetons());
		assertEquals(3,p5.getJetons());
		assertEquals(4,p6.getJetons());
		
		
		
		
	}
	
	@Test
	void testARP3() throws NullPlaceException, NullTransitionException, NegativeToken, NullTArcException, ExistingArc, UnknownPlaceException, UnknownTransitionException {
		network.ajouter_Place(p1);
		network.ajouter_Place(p2);
		network.ajouter_Place(p4);
		network.ajouter_Place(p3);
		network.ajouter_Place(p5);
		network.ajouter_Place(p6);
		network.ajouter_Tarnsition(t0);
		ArcSortantNormal arc0 = new ArcSortantNormal(3,p1, t0);
		ArcSortantNormal arc1 = new ArcSortantNormal(6,p2, t0);
		ArcSortantNormal arc2 = new ArcSortantNormal(10,p4, t0);
		network.ajouter_Arc(arc0);
		network.ajouter_Arc(arc1);
		network.ajouter_Arc(arc2);
		
		
		
		ArcEntrant arc3 = new ArcEntrant(7,p3, t0);
		ArcEntrant arc4 = new ArcEntrant(5,p5, t0);
		ArcEntrant arc5 = new ArcEntrant(4,p6, t0);
		
		network.ajouter_Arc(arc3);
		network.ajouter_Arc(arc4);
		network.ajouter_Arc(arc5);
		
		network.fire(t0);
		
		assertEquals(false,t0.isTirable());
		assertEquals(2,p1.getJetons());
		assertEquals(1,p2.getJetons());
		assertEquals(0,p3.getJetons());
		assertEquals(5,p4.getJetons());
		assertEquals(3,p5.getJetons());
		assertEquals(4,p6.getJetons());
		
		
		
		
		
	}
	
	@Test
	void testARP4() throws NullPlaceException, NullTransitionException, NegativeToken, NullTArcException, ExistingArc, UnknownPlaceException, UnknownTransitionException {
		network.ajouter_Place(p1);
		network.ajouter_Place(p2);
		network.ajouter_Place(p4);
		network.ajouter_Place(p3);
		network.ajouter_Place(p5);
		network.ajouter_Place(p6);
		network.ajouter_Tarnsition(t0);
		ArcSortantNormal arc0 = new ArcSortantNormal(2,p1, t0);
		ArcSortantNormal arc1 = new ArcSortantNormal(1,p2, t0);
		ArcSortantNormal arc2 = new ArcSortantNormal(5,p4, t0);
		network.ajouter_Arc(arc0);
		network.ajouter_Arc(arc1);
		network.ajouter_Arc(arc2);
		
		
		
		ArcEntrant arc3 = new ArcEntrant(7,p3, t0);
		ArcEntrant arc4 = new ArcEntrant(5,p5, t0);
		ArcEntrant arc5 = new ArcEntrant(4,p6, t0);
		
		network.ajouter_Arc(arc3);
		network.ajouter_Arc(arc4);
		network.ajouter_Arc(arc5);
		
		network.fire(t0);
		
		assertEquals(true,t0.isTirable());
		assertEquals(0,p1.getJetons());
		assertEquals(0,p2.getJetons());
		assertEquals(0,p4.getJetons());
		assertEquals(7,p3.getJetons());
		assertEquals(8,p5.getJetons());
		assertEquals(8,p6.getJetons());
		
		
		
		
	}
	
	@Test
	void testARP5() throws NullPlaceException, NullTransitionException, NegativeToken, NullTArcException, ExistingArc, UnknownPlaceException, UnknownTransitionException {
		network.ajouter_Place(p1);
		network.ajouter_Place(p2);
		network.ajouter_Place(p3);
		network.ajouter_Place(p5);
		network.ajouter_Place(p6);
		network.ajouter_Tarnsition(t0);
		ArcSortantNormal arc0 = new ArcSortantNormal(2,p1, t0);
		ArcSortantNormal arc1 = new ArcSortantNormal(1,p2, t0);
		ArcZero arc2 = new ArcZero(p3, t0);
		network.ajouter_Arc(arc0);
		network.ajouter_Arc(arc1);
		network.ajouter_Arc(arc2);
		
		
		
		
		ArcEntrant arc4 = new ArcEntrant(5,p5, t0);
		ArcEntrant arc5 = new ArcEntrant(4,p6, t0);
		
		
		network.ajouter_Arc(arc4);
		network.ajouter_Arc(arc5);
		
		network.fire(t0);
		
		assertEquals(true,t0.isTirable());
		assertEquals(0,p1.getJetons());
		assertEquals(0,p2.getJetons());
		assertEquals(0,p3.getJetons());
		assertEquals(8,p5.getJetons());
		assertEquals(8,p6.getJetons());
		
	
	}
	
	
	@Test
	void testARP6() throws NullPlaceException, NullTransitionException, NegativeToken, NullTArcException, ExistingArc, UnknownPlaceException, UnknownTransitionException {
		network.ajouter_Place(p1);
		network.ajouter_Place(p2);
		network.ajouter_Place(p4);
		network.ajouter_Place(p3);
		network.ajouter_Place(p5);
		network.ajouter_Place(p6);
		network.ajouter_Tarnsition(t0);
		ArcSortantNormal arc0 = new ArcSortantNormal(1,p1, t0);
		ArcSortantNormal arc1 = new ArcSortantNormal(1,p2, t0);
		ArcVideur arc2 = new ArcVideur(p4, t0);
		network.ajouter_Arc(arc0);
		network.ajouter_Arc(arc1);
		network.ajouter_Arc(arc2);
		
		
		
		ArcEntrant arc3 = new ArcEntrant(7,p3, t0);
		ArcEntrant arc4 = new ArcEntrant(5,p5, t0);
		ArcEntrant arc5 = new ArcEntrant(4,p6, t0);
		
		network.ajouter_Arc(arc3);
		network.ajouter_Arc(arc4);
		network.ajouter_Arc(arc5);
		
		network.fire(t0);
		
		assertEquals(true,t0.isTirable());
		assertEquals(1,p1.getJetons());
		assertEquals(0,p2.getJetons());
		assertEquals(0,p4.getJetons());
		assertEquals(7,p3.getJetons());
		assertEquals(8,p5.getJetons());
		assertEquals(8,p6.getJetons());
		
		
		
		
	}
	
	@Test
	void testARP7() throws NullPlaceException, NullTransitionException, NegativeToken, NullTArcException, ExistingArc, UnknownPlaceException, UnknownTransitionException {
		network.ajouter_Place(p1);
		network.ajouter_Place(p4);
		network.ajouter_Place(p3);
		network.ajouter_Place(p5);
		network.ajouter_Place(p6);
		network.ajouter_Tarnsition(t0);
		ArcSortantNormal arc0 = new ArcSortantNormal(1,p1, t0);
		ArcZero arc1 = new ArcZero(p3, t0);
		ArcVideur arc2 = new ArcVideur(p4, t0);
		network.ajouter_Arc(arc0);
		network.ajouter_Arc(arc1);
		network.ajouter_Arc(arc2);
		
		
		
		
		ArcEntrant arc4 = new ArcEntrant(5,p5, t0);
		ArcEntrant arc5 = new ArcEntrant(4,p6, t0);
		
		
		network.ajouter_Arc(arc4);
		network.ajouter_Arc(arc5);
		
		network.fire(t0);
		
		assertEquals(true,t0.isTirable());
		assertEquals(1,p1.getJetons());
		assertEquals(0,p3.getJetons());
		assertEquals(0,p4.getJetons());
		assertEquals(8,p5.getJetons());
		assertEquals(8,p6.getJetons());
		
		
		
		
	}
	
	@Test
	void testARP8() throws NullPlaceException, NullTransitionException, NegativeToken, NullTArcException, ExistingArc, UnknownPlaceException, UnknownTransitionException {
		network.ajouter_Place(p1);
		network.ajouter_Place(p2);
		network.ajouter_Place(p3);
		network.ajouter_Place(p4);
		network.ajouter_Place(p5);
		network.ajouter_Place(p6);
		network.ajouter_Place(p7);
		network.ajouter_Place(p8);
		network.ajouter_Tarnsition(t0);
		network.ajouter_Tarnsition(t1);
		ArcSortantNormal arc0 = new ArcSortantNormal(1,p1, t0);
		ArcSortantNormal arc1 = new ArcSortantNormal(1,p2, t0);
		ArcSortantNormal arc2 = new ArcSortantNormal(3,p4, t0);
		ArcSortantNormal arc4 = new ArcSortantNormal(2,p7, t1);
		network.ajouter_Arc(arc0);
		network.ajouter_Arc(arc1);
		network.ajouter_Arc(arc2);
		network.ajouter_Arc(arc4);
		
		
		
		ArcEntrant arc5 = new ArcEntrant(7,p3, t0);
		ArcEntrant arc6 = new ArcEntrant(5,p5, t0);
		ArcEntrant arc7 = new ArcEntrant(4,p6, t0);
		ArcEntrant arc3 = new ArcEntrant(1,p8,t1);
		ArcEntrant arc8 = new ArcEntrant(1,p7, t0);
		network.ajouter_Arc(arc5);
		network.ajouter_Arc(arc6);
		network.ajouter_Arc(arc7);
		network.ajouter_Arc(arc8);
		network.ajouter_Arc(arc3);
		
		network.fireAll();
		
		
		assertEquals(true,t0.isTirable());
		assertEquals(true,t1.isTirable());
		assertEquals(1,p1.getJetons());
		assertEquals(0,p2.getJetons());
		assertEquals(7,p3.getJetons());
		assertEquals(2,p4.getJetons());
		assertEquals(8,p5.getJetons());
		assertEquals(8,p6.getJetons());
		assertEquals(9,p7.getJetons());
		assertEquals(16,p8.getJetons());
		
	}

}
