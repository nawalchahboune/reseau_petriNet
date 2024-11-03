package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.*;

import Exceptions.ExceedExistingToken;
import Exceptions.ExistingArc;
import Exceptions.ExistingPlace;
import Exceptions.ExistingTransition;
import Exceptions.NegativeToken;
import Exceptions.NegativeWeight;
import Exceptions.NullPlaceException;
import Exceptions.NullTransitionException;
import Metier.ArcEntrant;
import Metier.ArcSortant;
import Metier.ArcSortantNormal;
import Metier.ArcVideur;
import Metier.ArcZero;
import Metier.Place;
import Metier.Reseau_Petri;
import Metier.Transition;

class TestsCreation {
	
	
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


	@Test
	void test() {
		
	}
	//creation reseau de petri avec constructeur vide
	@Test
	void testCreerReseauDePetriVide() {
	    network = new Reseau_Petri();
	    assertNotNull(network, "Le réseau de Petri doit être créé.");
	    assertEquals(0, network.getTransitions().size(), "Le réseau de Petri doit être vide.");
	    assertEquals(0, network.getPlaces().size(), "Le réseau de Petri doit être vide.");
	    assertEquals(0, network.getArcs().size(), "Le réseau de Petri doit être vide.");
	}
	
	//creation place
	
	@Test
	void testCreationPlaceSansEntrees() {
		Place p = new Place();
		assertEquals(0, p.getJetons());
		assertEquals(0, p.getArcsSortants().size());
		assertEquals(0, p.getArcsEntrants().size());
		
		
		
	}
	 @Test
	    void testCreationPlaceAvecJetonPositifOuNul()   {
	        // Cas valide: nombre de jetons positif ou nul
	        Place p1 =assertDoesNotThrow(()-> new Place(0));// Crée une place avec 0 jetons
	        Place p2 =assertDoesNotThrow(()-> new Place(3));// Crée une place avec 3 jetons
	        
	        assertEquals(0, p1.getJetons(), "La place p1 doit avoir 0 jetons.");
	        assertEquals(3, p2.getJetons(), "La place p2 doit avoir 3 jetons.");
	        assertEquals(0, p1.getArcsSortants().size(), "La place p1 ne doit pas avoir d'arcs sortants.");
	        assertEquals(0, p2.getArcsEntrants().size(), "La place p2 ne doit pas avoir d'arcs entrants.");
	    }

		@Test
		void testCreationPlaceEntreJetonNegative() {
			Exception exception = assertThrows(NegativeToken.class, () -> {
	            new Place(-1); // Crée une place avec -1 jeton, ce qui devrait lever une exception
	        });
			assertEquals("negative Token !!!", exception.getMessage());
			
			
		}
		
		///creation transition 
		
		@Test
		void testCreationTransitionSansEntrees() {
			Transition t = new Transition();
			assertEquals(0, t.getArcsSortants().size());
			assertEquals(0, t.getArcsEntrants().size());
			assertEquals("transition, Isolée",t.toString());
			
		}
		// no sense when creating transition with arcs entrant and sortant !!
		/* @Test
		void testCreationTransitionEntreesArcsEntrants() throws NullPlaceException, NullTransitionException, NegativeToken, ExistingArc {
			ArcSortantNormal arcE1= new ArcSortantNormal(1, new Place(2), new Transition());
			ArrayList<ArcSortant> arcsE = new ArrayList<ArcSortant>();
			arcsE.add(arcE1);
			Transition t = new Transition(arcsE, null);
			assertEquals(null, t.getArcsSortants());
			assertEquals(1, t.getArcsEntrants().size());
			
		}
		@Test
		void testCreationTransitionEntreesArcsSortants() throws NullPlaceException, NullTransitionException, NegativeToken, ExistingArc {
			ArcEntrant arcS1= new ArcEntrant(1, new Place(2), new Transition());
			ArrayList<ArcEntrant> arcsS = new ArrayList<ArcEntrant>();
			arcsS.add(arcS1);
			Transition t = new Transition(null, arcsS);
			assertEquals(null, t.getArcsEntrants());
			assertEquals(1, t.getArcsSortants().size());
			
		}
		@Test
		void testCreationTransitionEntreesArcsEntrantsEtSortants() throws NullPlaceException, NullTransitionException, NegativeToken, ExistingArc {
			ArcSortantNormal arcE1= new ArcSortantNormal(1, new Place(2), new Transition());
			ArrayList<ArcSortant> arcsE = new ArrayList<ArcSortant>();
			arcsE.add(arcE1);
			ArcEntrant arcS1= new ArcEntrant(1, new Place(2), new Transition());
			ArcEntrant arcS2= new ArcEntrant(1, new Place(3), new Transition());
			ArrayList<ArcEntrant> arcsS = new ArrayList<ArcEntrant>();
			arcsS.add(arcS1);
			arcsS.add(arcS2);
			Transition t = new Transition(arcsE, arcsS);
			assertEquals(2, t.getArcsSortants().size());
			assertEquals(1, t.getArcsEntrants().size());
			assertEquals(0, t.getArcsEntrants().size());
			
			
		}*/
		//creation arcs
		
		@Test
		//je peux encore dire su y aura pas d'excpetion!! 
		//s'assurer d'exsisting arc aussi  !!! 
		void testCreationArcSansException()  {
			ArcSortantNormal arc1 = assertDoesNotThrow(()->
				new ArcSortantNormal(2, new Place(), new Transition()) 			
			);
			ArcVideur arc2 = assertDoesNotThrow(()->
			new ArcVideur(new Place(3), new Transition())
			);
			//ici 3 en question 
			ArcZero arc3 = assertDoesNotThrow(()->
			new ArcZero(new Place(0), new Transition())
			);
			ArcEntrant arc4 =assertDoesNotThrow(()->
			new ArcEntrant(4, new Place(8), new Transition())
			);
			//pour arc sortant normal
			assertEquals(2, arc1.getPoids());
			assertEquals(0, arc1.getPlace().getJetons());
			assertEquals(0,arc1.getPlace().getArcsEntrants().size());
			assertEquals(1,arc1.getPlace().getArcsSortants().size());
			assertEquals(1, arc1.getTransition().getArcsEntrants().size());
			assertEquals(0, arc1.getTransition().getArcsSortants().size());
			// pour arc videu :
			assertEquals(3, arc2.getPlace().getJetons());
			assertEquals(0,arc2.getPlace().getArcsEntrants().size());
			assertEquals(1,arc2.getPlace().getArcsSortants().size());
			assertEquals(1, arc2.getTransition().getArcsEntrants().size());
			assertEquals(0, arc2.getTransition().getArcsSortants().size());
			// pour arc zero 
			assertEquals(0, arc3.getPlace().getJetons());
			assertEquals(0,arc3.getPlace().getArcsEntrants().size());
			assertEquals(1,arc3.getPlace().getArcsSortants().size());
			assertEquals(1, arc3.getTransition().getArcsEntrants().size());
			assertEquals(0, arc3.getTransition().getArcsSortants().size());
			// pour arc entrant de la place
			assertEquals(4, arc4.getPoids());
			assertEquals(8, arc4.getPlace().getJetons());
			assertEquals(1,arc4.getPlace().getArcsEntrants().size());
			assertEquals(0,arc4.getPlace().getArcsSortants().size());
			assertEquals(0, arc4.getTransition().getArcsEntrants().size());
			assertEquals(1, arc4.getTransition().getArcsSortants().size());
			
		}
		@Test
		void testCreationArcAvecException() {
			// pour arc sortant normal
			Exception exception11 = assertThrows(NegativeWeight.class, () -> {
				new ArcSortantNormal(-2, new Place(), new Transition());
	        });
			assertEquals("arc avec poids negatif !!!", exception11.getMessage());
			
			Exception exception12 = assertThrows(NullPlaceException.class, () -> {
				new ArcSortantNormal(2, null, new Transition());
	        });
			assertEquals("place est null !!! ", exception12.getMessage());
			
			Exception exception13 = assertThrows(NullTransitionException.class, () -> {
				new ArcSortantNormal(2, new Place(), null);
	        });
			assertEquals("transition null !!", exception13.getMessage());
			
			// pour arc viseur 
			Exception exception21 = assertThrows(NullPlaceException.class, () -> {
				new ArcVideur(null, new Transition());
	        });
			assertEquals("place est null !!! ", exception21.getMessage());
			
			Exception exception22 = assertThrows(NullTransitionException.class, () -> {
				new ArcVideur(new Place(), null);
	        });
			assertEquals("transition null !!", exception22.getMessage());
			
			 // pour arc zéro 
			Exception exception31 = assertThrows(NullPlaceException.class, () -> {
				new ArcZero(null, new Transition());
	        });
			assertEquals("place est null !!! ", exception21.getMessage());
			
			Exception exception32 = assertThrows(NullTransitionException.class, () -> {
				new ArcZero(new Place(), null);
	        });
			assertEquals("transition null !!", exception22.getMessage());
			// pour arc entrant de la place 
			Exception exception41 = assertThrows(NegativeWeight.class, () -> {
				new ArcEntrant(-2, new Place(), new Transition());
	        });
			assertEquals("arc avec poids negatif !!!", exception41.getMessage());
			
			Exception exception42 = assertThrows(NullPlaceException.class, () -> {
				new ArcEntrant(2, null, new Transition());
	        });
			assertEquals("place est null !!! ", exception42.getMessage());
			
			Exception exception43 = assertThrows(NullTransitionException.class, () -> {
				new ArcEntrant(2, new Place(), null);
	        });
			assertEquals("transition null !!", exception43.getMessage());
			
		
		}
		
		
		// pour les opérations sur les jetons  d'une place :: 
		
		@Test
		void TestAjoutJetonsPlace()  {
			Place p = assertDoesNotThrow(() -> new Place(1)); 
			
			
			Exception exception = assertThrows(NegativeToken.class, () -> {
		           p.setJetons(-1); // Crée une place avec -1 jeton, ce qui devrait lever une exception
		        });
				assertEquals("negative Token !!!", exception.getMessage());
			
				assertEquals(1, p.getJetons() );
				assertDoesNotThrow(()->p.setJetons(5));
				assertEquals(5, p.getJetons());
				
			
		}
		
		@Test
		void TestEnleverJetonsPlace()  {
			Place p = assertDoesNotThrow(() -> new Place(3)); 
			
			
			Exception exception = assertThrows(ExceedExistingToken.class, () -> {
		           p.enleverJetons(4);
		           // Crée une place avec -1 jeton, ce qui devrait lever une exception
		        });
				assertEquals("you try to remove more than what is inside : place", exception.getMessage());

				assertEquals(3, p.getJetons() );
				assertDoesNotThrow(()->p.enleverJetons(3));
				assertEquals(0, p.getJetons());
				
				
			
		}
		
		
		// test arcs Doublés :: 
		@Test 
		void TestExistingArc() {
			Place p = assertDoesNotThrow(()-> new Place());
			Transition t= new Transition();
			ArcEntrant arc1=assertDoesNotThrow(()-> new ArcEntrant(0, p, t));
			Exception exception = assertThrows(ExistingArc.class, () -> {
				new ArcEntrant(0, p, t);
		           
		        });
			assertEquals("arc already exists", exception.getMessage());
		
		}
		
		
		@Test 
		void TestExistingPlace() {
			Place p = new Place();
			Reseau_Petri network= new Reseau_Petri();
			assertDoesNotThrow(()->{
				network.ajouter_Place(p);
			});

			assertEquals(1, network.getPlaces().size());
			
			Exception exception = assertThrows(ExistingPlace.class, () -> {
		        network.ajouter_Place(p);
		    });
			assertEquals("place deja existe!", exception.getMessage());
		}
		@Test 
		void TestExistingTransition() {
			Transition t = new Transition();
			Reseau_Petri network= new Reseau_Petri();
			assertDoesNotThrow(()->{
				network.ajouter_Tarnsition(t);
			});

			assertEquals(1, network.getTransitions().size());
			
			Exception exception = assertThrows(ExistingTransition.class, () -> {
		        network.ajouter_Tarnsition(t);
		    });
			assertEquals("transition deja existe!", exception.getMessage());
		}
		

			
		
		}
		
		

