package Tests;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exceptions.ExistingArc;
import Exceptions.ExistingPlace;
import Exceptions.ExistingTransition;
import Exceptions.NegativeToken;
import Exceptions.NegativeWeight;
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
		network =  assertDoesNotThrow(()-> new Reseau_Petri());
		//Transition
		t0 =  assertDoesNotThrow(()-> new Transition());
		t1 = assertDoesNotThrow(()-> new Transition());
		//Places entrantes
		p0 = assertDoesNotThrow(()-> new Place(10));
		p1 = assertDoesNotThrow(()-> new Place(2));
		p2 = assertDoesNotThrow(()-> new Place(1));
		p3 = assertDoesNotThrow(()-> new Place(0));
		
		//Places sortantes
		 p4 = assertDoesNotThrow(()->new Place(5));
		 p5 =  assertDoesNotThrow(()->new Place(3));
		 p6 =  assertDoesNotThrow(()->new Place(4));	
		 
		 p7 =assertDoesNotThrow(()-> new Place(10));
		 p8 = assertDoesNotThrow(()-> new Place(15));
		 
		
		
	}
	/*
	@Test
	void testRS0() throws NullTransitionException, ExistingTransition {
		network.ajouter_Tarnsition(t0);
		network.fireAll();
	}
	*/
	@Test
	void testRS1() throws NullPlaceException, NullTransitionException, NullTArcException, ExistingArc, UnknownPlaceException, UnknownTransitionException, NegativeToken, ExistingPlace, NegativeWeight, ExistingTransition {
	    
		network.ajouter_Place(p3);
		network.ajouter_Tarnsition(t0);
		ArcSortantNormal arc0 = new ArcSortantNormal(1,p3, t0);
		network.ajouter_Arc(arc0);
		network.fire(t0);
		
		assertEquals(0,p3.getJetons());
		
		Exception e = assertThrows(NullTransitionException.class, ()->{
			network.fire(null);
		});
		assertEquals("transition null !!", e.getMessage());
	}
	
	@Test
	void testRS2() {
		/*
		 * 
		 * */
		assertDoesNotThrow(()-> network.ajouter_Place(p1));
		assertDoesNotThrow(()-> network.ajouter_Tarnsition(t0));
		 ArcSortantNormal arc0 =  assertDoesNotThrow(()->new ArcSortantNormal(1,p1, t0));
		 assertDoesNotThrow(()-> network.ajouter_Arc(arc0));
		 assertDoesNotThrow(()-> network.fire(t0));
		
		assertEquals(1,p1.getJetons());
	}
	
	@Test
	void testRS3() {
		assertDoesNotThrow(()-> network.ajouter_Place(p4));
		assertDoesNotThrow(()-> network.ajouter_Tarnsition(t0));
		ArcSortantNormal arc0 = assertDoesNotThrow(()->  new ArcSortantNormal(3,p4, t0));
		assertDoesNotThrow(()-> network.ajouter_Arc(arc0));
		assertDoesNotThrow(()-> network.fire(t0));
		
		assertEquals(2,p4.getJetons());
	}
	
	@Test
	void testRS4() {
		assertDoesNotThrow(()-> network.ajouter_Place(p3));
		assertDoesNotThrow(()-> network.ajouter_Tarnsition(t0));
		ArcEntrant arc0 = assertDoesNotThrow(()->new ArcEntrant(1,p3, t0));
		assertDoesNotThrow(()->network.ajouter_Arc(arc0));
		assertDoesNotThrow(()->network.fire(t0));
		
		assertEquals(1,p3.getJetons());
	}
	
	@Test
	void testRS5() {
		assertDoesNotThrow(()-> network.ajouter_Place(p3));
		assertDoesNotThrow(()-> network.ajouter_Tarnsition(t0));
		 ArcEntrant arc0 = assertDoesNotThrow(()-> new ArcEntrant(2,p3, t0));
		 assertDoesNotThrow(()->network.ajouter_Arc(arc0));
		 assertDoesNotThrow(()->network.fire(t0));
		
		assertEquals(2,p3.getJetons());
	}
	@Test
	void testRS6() {
		assertDoesNotThrow(()-> network.ajouter_Place(p1));
		assertDoesNotThrow(()-> network.ajouter_Tarnsition(t0));
		ArcVideur arc0 = assertDoesNotThrow(()->  new ArcVideur (p1, t0));
		assertDoesNotThrow(()-> network.ajouter_Arc(arc0));
		assertDoesNotThrow(()-> network.fire(t0));
		
		assertEquals(0,p1.getJetons());
	}
	
	@Test
	void testRS7() {
		assertDoesNotThrow(()-> network.ajouter_Place(p1));
		
		assertDoesNotThrow(()-> network.ajouter_Place(p3));
		assertDoesNotThrow(()-> network.ajouter_Tarnsition(t0));
		ArcSortantNormal arc0 =  assertDoesNotThrow(()->new ArcSortantNormal(1,p3, t0));
		ArcEntrant arc1 =  assertDoesNotThrow(()->new ArcEntrant(1,p1, t0));
		assertDoesNotThrow(()->network.ajouter_Arc(arc0));
		assertDoesNotThrow(()->network.ajouter_Arc(arc1));
		assertDoesNotThrow(()->network.fire(t0));
		
		assertEquals(0,p3.getJetons());
		assertEquals(2,p1.getJetons());
	}
	@Test
	void testRS8() throws NullPlaceException, NullTransitionException, NullTArcException, ExistingArc, UnknownPlaceException, UnknownTransitionException, NegativeToken, ExistingPlace, NegativeWeight, ExistingTransition {
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
	void testARP0() {
		/*Activation avec jetons 
			suffisants sur tous les arcs et 
			un seul arc sortant de la 
			transition 
			
			
			La transition est activée, les jetons dans les places 
			entrantes sont réduits, et augmentés dans la place 
			sortante 
		 * 
		 * */
		assertDoesNotThrow(()-> network.ajouter_Place(p1));
		assertDoesNotThrow(()-> network.ajouter_Place(p2));
		assertDoesNotThrow(()-> network.ajouter_Place(p4));
		assertDoesNotThrow(()-> network.ajouter_Place(p3));
		assertDoesNotThrow(()->network.ajouter_Tarnsition(t0));
		ArcSortantNormal arc0 =assertDoesNotThrow(()-> new ArcSortantNormal(1,p1, t0));
		ArcSortantNormal arc1 =  assertDoesNotThrow(()->new ArcSortantNormal(1,p2, t0));
		ArcSortantNormal arc2 = assertDoesNotThrow(()-> new ArcSortantNormal(3,p4, t0));
		
		assertDoesNotThrow(()->network.ajouter_Arc(arc0));
		assertDoesNotThrow(()->network.ajouter_Arc(arc1));
		assertDoesNotThrow(()->network.ajouter_Arc(arc2));
		
		ArcEntrant arc3 = assertDoesNotThrow(()-> new ArcEntrant(7,p3, t0));
		
		
		
		assertDoesNotThrow(()->network.ajouter_Arc(arc3));
		
		assertEquals(true,t0.isTirable());
		assertDoesNotThrow(()->network.fire(t0));
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
	void testARP1() {
		
		/* Activation avec jetons 
		suffisants sur tous les arcs et 
		plusieurs arc sortant de la 
		transition 
		
		*La transition est activée, les jetons dans les places 
			entrantes sont réduits, et augmentés dans les places 
			sortantes 
		*
		*/
		
		assertDoesNotThrow(()->network.ajouter_Place(p1));
		assertDoesNotThrow(()->network.ajouter_Place(p2));
		assertDoesNotThrow(()->network.ajouter_Place(p4));
		assertDoesNotThrow(()->network.ajouter_Place(p3));
		assertDoesNotThrow(()->network.ajouter_Place(p5));
		assertDoesNotThrow(()->network.ajouter_Place(p6));
		assertDoesNotThrow(()->network.ajouter_Tarnsition(t0));
		ArcSortantNormal arc0 =  assertDoesNotThrow(()->new ArcSortantNormal(1,p1, t0));
		ArcSortantNormal arc1 =  assertDoesNotThrow(()->new ArcSortantNormal(1,p2, t0));
		ArcSortantNormal arc2 =  assertDoesNotThrow(()->new ArcSortantNormal(3,p4, t0));
		assertDoesNotThrow(()->network.ajouter_Arc(arc0));
		assertDoesNotThrow(()->network.ajouter_Arc(arc1));
		assertDoesNotThrow(()->network.ajouter_Arc(arc2));
		
		
		
		ArcEntrant arc3 =  assertDoesNotThrow(()->new ArcEntrant(7,p3, t0));
		ArcEntrant arc4 =  assertDoesNotThrow(()->new ArcEntrant(5,p5, t0));
		ArcEntrant arc5 = assertDoesNotThrow(()->  new ArcEntrant(4,p6, t0));
		
		assertDoesNotThrow(()->network.ajouter_Arc(arc3));
		assertDoesNotThrow(()->network.ajouter_Arc(arc4));
		assertDoesNotThrow(()->network.ajouter_Arc(arc5));
		
		
		assertEquals(true,t0.isTirable());
		assertDoesNotThrow(()->network.fire(t0));
		
		assertEquals(1,p1.getJetons());
		assertEquals(0,p2.getJetons());
		assertEquals(2,p4.getJetons());
		assertEquals(7,p3.getJetons());
		assertEquals(8,p5.getJetons());
		assertEquals(8,p6.getJetons());
		
		
		
		
	}
	
	@Test
	void testARP2() {
		/*Activation avec jetons 
          insuffisants sur un arc 
          
          
          La transition ne s'active pas, les jetons restent 
          inchangés 
		 * 
		 * */
		assertDoesNotThrow(()->network.ajouter_Place(p1));
		assertDoesNotThrow(()->network.ajouter_Place(p2));
		assertDoesNotThrow(()->network.ajouter_Place(p4));
		assertDoesNotThrow(()->network.ajouter_Place(p3));
		assertDoesNotThrow(()->network.ajouter_Place(p5));
		assertDoesNotThrow(()-> network.ajouter_Place(p6));
		assertDoesNotThrow(()->network.ajouter_Tarnsition(t0));
		ArcSortantNormal arc0 = assertDoesNotThrow(()-> new ArcSortantNormal(3,p1, t0));
		ArcSortantNormal arc1 =assertDoesNotThrow(()-> new ArcSortantNormal(1,p2, t0));
		ArcSortantNormal arc2 =assertDoesNotThrow(()-> new ArcSortantNormal(3,p4, t0));
		assertDoesNotThrow(()->network.ajouter_Arc(arc0));
		assertDoesNotThrow(()->network.ajouter_Arc(arc1));
		assertDoesNotThrow(()->network.ajouter_Arc(arc2));
		
		
		
		ArcEntrant arc3 = assertDoesNotThrow(()-> new ArcEntrant(7,p3, t0));
		ArcEntrant arc4 = assertDoesNotThrow(()->new ArcEntrant(5,p5, t0));
		ArcEntrant arc5 =assertDoesNotThrow(()-> new ArcEntrant(4,p6, t0));
		
		assertDoesNotThrow(()->network.ajouter_Arc(arc3));
		assertDoesNotThrow(()->network.ajouter_Arc(arc4));
		assertDoesNotThrow(()->network.ajouter_Arc(arc5));
		
		assertDoesNotThrow(()->network.fire(t0));
		
		assertEquals(false,t0.isTirable());
		assertEquals(2,p1.getJetons());
		assertEquals(1,p2.getJetons());
		assertEquals(0,p3.getJetons());
		assertEquals(5,p4.getJetons());
		assertEquals(3,p5.getJetons());
		assertEquals(4,p6.getJetons());
		
		
		
		
	}
	@Test
	void testARP3() {
		/*Activation avec jetons 
           insuffisants sur plusieurs arcs 
           
           La transition ne s'active pas, les jetons restent 
           inchangés 
		 * 
		 * */
	    assertDoesNotThrow(() -> network.ajouter_Place(p1));
	    assertDoesNotThrow(() -> network.ajouter_Place(p2));
	    assertDoesNotThrow(() -> network.ajouter_Place(p4));
	    assertDoesNotThrow(() -> network.ajouter_Place(p3));
	    assertDoesNotThrow(() -> network.ajouter_Place(p5));
	    assertDoesNotThrow(() -> network.ajouter_Place(p6));
	    assertDoesNotThrow(() -> network.ajouter_Tarnsition(t0));

	    ArcSortantNormal arc0 = assertDoesNotThrow(() -> new ArcSortantNormal(3, p1, t0));
	    ArcSortantNormal arc1 = assertDoesNotThrow(() -> new ArcSortantNormal(6, p2, t0));
	    ArcSortantNormal arc2 = assertDoesNotThrow(() -> new ArcSortantNormal(10, p4, t0));
	    
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc0));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc1));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc2));

	    ArcEntrant arc3 = assertDoesNotThrow(() -> new ArcEntrant(7, p3, t0));
	    ArcEntrant arc4 = assertDoesNotThrow(() -> new ArcEntrant(5, p5, t0));
	    ArcEntrant arc5 = assertDoesNotThrow(() -> new ArcEntrant(4, p6, t0));

	    assertDoesNotThrow(() -> network.ajouter_Arc(arc3));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc4));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc5));

	    assertDoesNotThrow(() -> network.fire(t0));

	    // Assertions finales pour vérifier les états
	    assertEquals(false, t0.isTirable());
	    assertEquals(2, p1.getJetons());
	    assertEquals(1, p2.getJetons());
	    assertEquals(0, p3.getJetons());
	    assertEquals(5, p4.getJetons());
	    assertEquals(3, p5.getJetons());
	    assertEquals(4, p6.getJetons());
	}

	
	@Test
	void testARP4() {
		/*Places avec un nombre exact 
          de jetons requis par les 
          différents poids des arcs 
          
          La transition s'active, les jetons sont ajustés en 
          fonction des poids de chaque arc 
		 * 
		 * */
	    assertDoesNotThrow(() -> network.ajouter_Place(p1));
	    assertDoesNotThrow(() -> network.ajouter_Place(p2));
	    assertDoesNotThrow(() -> network.ajouter_Place(p4));
	    assertDoesNotThrow(() -> network.ajouter_Place(p3));
	    assertDoesNotThrow(() -> network.ajouter_Place(p5));
	    assertDoesNotThrow(() -> network.ajouter_Place(p6));
	    assertDoesNotThrow(() -> network.ajouter_Tarnsition(t0));
	    
	    ArcSortantNormal arc0 = assertDoesNotThrow(() -> new ArcSortantNormal(2, p1, t0));
	    ArcSortantNormal arc1 = assertDoesNotThrow(() -> new ArcSortantNormal(1, p2, t0));
	    ArcSortantNormal arc2 = assertDoesNotThrow(() -> new ArcSortantNormal(5, p4, t0));
	    
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc0));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc1));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc2));

	    ArcEntrant arc3 = assertDoesNotThrow(() -> new ArcEntrant(7, p3, t0));
	    ArcEntrant arc4 = assertDoesNotThrow(() -> new ArcEntrant(5, p5, t0));
	    ArcEntrant arc5 = assertDoesNotThrow(() -> new ArcEntrant(4, p6, t0));

	    assertDoesNotThrow(() -> network.ajouter_Arc(arc3));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc4));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc5));

	    assertEquals(true, t0.isTirable());
	    assertDoesNotThrow(() -> network.fire(t0));
	    assertEquals(0, p1.getJetons());
	    assertEquals(0, p2.getJetons());
	    assertEquals(0, p4.getJetons());
	    assertEquals(7, p3.getJetons());
	    assertEquals(8, p5.getJetons());
	    assertEquals(8, p6.getJetons());
	}

	
	@Test
	void testARP5() {
		/*Arcs avec une place ayant 0 
           jeton et un arc Zéro 
           
           
           La transition est activée, les jetons dans les places 
           entrantes sont réduits, et augmentés dans les places 
           sortantes 
           
		 * */
	    assertDoesNotThrow(() -> network.ajouter_Place(p1));
	    assertDoesNotThrow(() -> network.ajouter_Place(p2));
	    assertDoesNotThrow(() -> network.ajouter_Place(p3));
	    assertDoesNotThrow(() -> network.ajouter_Place(p5));
	    assertDoesNotThrow(() -> network.ajouter_Place(p6));
	    assertDoesNotThrow(() -> network.ajouter_Tarnsition(t0));

	    ArcSortantNormal arc0 = assertDoesNotThrow(() -> new ArcSortantNormal(2, p1, t0));
	    ArcSortantNormal arc1 = assertDoesNotThrow(() -> new ArcSortantNormal(1, p2, t0));
	    ArcZero arc2 = assertDoesNotThrow(() -> new ArcZero(p3, t0));

	    assertDoesNotThrow(() -> network.ajouter_Arc(arc0));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc1));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc2));

	    ArcEntrant arc4 = assertDoesNotThrow(() -> new ArcEntrant(5, p5, t0));
	    ArcEntrant arc5 = assertDoesNotThrow(() -> new ArcEntrant(4, p6, t0));

	    assertDoesNotThrow(() -> network.ajouter_Arc(arc4));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc5));

	    assertEquals(true, t0.isTirable());
	    assertDoesNotThrow(() -> network.fire(t0));
	    assertEquals(0, p1.getJetons());
	    assertEquals(0, p2.getJetons());
	    assertEquals(0, p3.getJetons());
	    assertEquals(8, p5.getJetons());
	    assertEquals(8, p6.getJetons());
	}

	
	@Test
	void testARP6() {
		/*Activation avec jetons 
          suffisants sur tous les arcs et 
          un arc videur
          
          La transition est activée, les jetons dans les places 
          entrantes sont réduits, et augmentés dans les places 
          sortantes 
           
		 * */
	    assertDoesNotThrow(() -> network.ajouter_Place(p1));
	    assertDoesNotThrow(() -> network.ajouter_Place(p2));
	    assertDoesNotThrow(() -> network.ajouter_Place(p4));
	    assertDoesNotThrow(() -> network.ajouter_Place(p3));
	    assertDoesNotThrow(() -> network.ajouter_Place(p5));
	    assertDoesNotThrow(() -> network.ajouter_Place(p6));
	    assertDoesNotThrow(() -> network.ajouter_Tarnsition(t0));

	    ArcSortantNormal arc0 = assertDoesNotThrow(() -> new ArcSortantNormal(1, p1, t0));
	    ArcSortantNormal arc1 = assertDoesNotThrow(() -> new ArcSortantNormal(1, p2, t0));
	    ArcVideur arc2 = assertDoesNotThrow(() -> new ArcVideur(p4, t0));

	    assertDoesNotThrow(() -> network.ajouter_Arc(arc0));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc1));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc2));

	    ArcEntrant arc3 = assertDoesNotThrow(() -> new ArcEntrant(7, p3, t0));
	    ArcEntrant arc4 = assertDoesNotThrow(() -> new ArcEntrant(5, p5, t0));
	    ArcEntrant arc5 = assertDoesNotThrow(() -> new ArcEntrant(4, p6, t0));

	    assertDoesNotThrow(() -> network.ajouter_Arc(arc3));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc4));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc5));

	    assertEquals(true, t0.isTirable());
	    assertDoesNotThrow(() -> network.fire(t0));
	    assertEquals(1, p1.getJetons());
	    assertEquals(0, p2.getJetons());
	    assertEquals(0, p4.getJetons());
	    assertEquals(7, p3.getJetons());
	    assertEquals(8, p5.getJetons());
	    assertEquals(8, p6.getJetons());
	}

	
	@Test
	void testARP7() {
		/*
		 * Activation avec jetons non 
			nuls suffisants sur tous les arcs 
			et un arc videur et un arc zéro 
			
			
		 * La transition ne s'active pas, les jetons restent 
           inchangés 
		 * */
	    assertDoesNotThrow(() -> network.ajouter_Place(p1));
	    assertDoesNotThrow(() -> network.ajouter_Place(p4));
	    assertDoesNotThrow(() -> network.ajouter_Place(p3));
	    assertDoesNotThrow(() -> network.ajouter_Place(p5));
	    assertDoesNotThrow(() -> network.ajouter_Place(p6));
	    assertDoesNotThrow(() -> network.ajouter_Tarnsition(t0));

	    ArcSortantNormal arc0 = assertDoesNotThrow(() -> new ArcSortantNormal(1, p1, t0));
	    ArcZero arc1 = assertDoesNotThrow(() -> new ArcZero(p3, t0));
	    ArcVideur arc2 = assertDoesNotThrow(() -> new ArcVideur(p4, t0));

	    assertDoesNotThrow(() -> network.ajouter_Arc(arc0));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc1));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc2));

	    ArcEntrant arc4 = assertDoesNotThrow(() -> new ArcEntrant(5, p5, t0));
	    ArcEntrant arc5 = assertDoesNotThrow(() -> new ArcEntrant(4, p6, t0));

	    assertDoesNotThrow(() -> network.ajouter_Arc(arc4));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc5));

	    assertEquals(true, t0.isTirable());
	    assertDoesNotThrow(() -> network.fire(t0));
	    assertEquals(1, p1.getJetons());
	    assertEquals(0, p3.getJetons());
	    assertEquals(0, p4.getJetons());
	    assertEquals(8, p5.getJetons());
	    assertEquals(8, p6.getJetons());
	}

	
	@Test
	void testARP8() {
		/*Activation du réseau avec 
			deux transitions et plusieurs 
			places et plusieurs arcs chaque 
			place ayant un nombre de 
			jetons supérieurs ou égal au 
			nombre d’arc
			
			Les transitions s’activent, les jetons sont changés
		 * 
		 * */
	    assertDoesNotThrow(() -> network.ajouter_Place(p1));
	    assertDoesNotThrow(() -> network.ajouter_Place(p2));
	    assertDoesNotThrow(() -> network.ajouter_Place(p3));
	    assertDoesNotThrow(() -> network.ajouter_Place(p4));
	    assertDoesNotThrow(() -> network.ajouter_Place(p5));
	    assertDoesNotThrow(() -> network.ajouter_Place(p6));
	    assertDoesNotThrow(() -> network.ajouter_Place(p7));
	    assertDoesNotThrow(() -> network.ajouter_Place(p8));
	    assertDoesNotThrow(() -> network.ajouter_Tarnsition(t0));
	    assertDoesNotThrow(() -> network.ajouter_Tarnsition(t1));

	    ArcSortantNormal arc0 = assertDoesNotThrow(() -> new ArcSortantNormal(1, p1, t0));
	    ArcSortantNormal arc1 = assertDoesNotThrow(() -> new ArcSortantNormal(1, p2, t0));
	    ArcSortantNormal arc2 = assertDoesNotThrow(() -> new ArcSortantNormal(3, p4, t0));
	    ArcSortantNormal arc4 = assertDoesNotThrow(() -> new ArcSortantNormal(2, p7, t1));

	    assertDoesNotThrow(() -> network.ajouter_Arc(arc0));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc1));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc2));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc4));

	    ArcEntrant arc5 = assertDoesNotThrow(() -> new ArcEntrant(7, p3, t0));
	    ArcEntrant arc6 = assertDoesNotThrow(() -> new ArcEntrant(5, p5, t0));
	    ArcEntrant arc7 = assertDoesNotThrow(() -> new ArcEntrant(4, p6, t0));
	    ArcEntrant arc3 = assertDoesNotThrow(() -> new ArcEntrant(1, p8, t1));
	    ArcEntrant arc8 = assertDoesNotThrow(() -> new ArcEntrant(1, p7, t0));

	    assertDoesNotThrow(() -> network.ajouter_Arc(arc5));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc6));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc7));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc8));
	    assertDoesNotThrow(() -> network.ajouter_Arc(arc3));

	    assertEquals(true, t0.isTirable());
	    assertEquals(true, t1.isTirable());
	    assertDoesNotThrow(() -> network.fireAll());
	    assertEquals(1, p1.getJetons());
	    assertEquals(0, p2.getJetons());
	    assertEquals(7, p3.getJetons());
	    assertEquals(2, p4.getJetons());
	    assertEquals(8, p5.getJetons());
	    assertEquals(8, p6.getJetons());
	    assertEquals(9, p7.getJetons());
	    assertEquals(16, p8.getJetons());
	}


}
