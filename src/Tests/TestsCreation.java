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

	private Reseau_Petri network;
	// Transition
	private Transition t0;
	private Transition t1;
	// Places entrantes
	private Place p0;
	private Place p1;
	private Place p2;
	private Place p3;

	// Places sortantes
	private Place p4;
	private Place p5;
	private Place p6;

	@Test
	void test() {

	}

	// // Vérifie la création d'un réseau de Petri vide
	@Test
	void CRP0() {
		network = new Reseau_Petri();
		assertNotNull(network, "Le réseau de Petri doit être créé.");
		assertEquals(0, network.getTransitions().size(), "Le réseau de Petri doit être vide.");
		assertEquals(0, network.getPlaces().size(), "Le réseau de Petri doit être vide.");
		assertEquals(0, network.getArcs().size(), "Le réseau de Petri doit être vide.");
	}

	//

	 // Test de création d'une place sans paramètres

	@Test
	void CP0() {
		Place p = new Place();
		assertEquals(0, p.getJetons());
		assertEquals(0, p.getArcsSortants().size());
		assertEquals(0, p.getArcsEntrants().size());

	}

    // Test de création d'une place avec jetons positifs
	@Test
	void CP1() {
		// Cas valide: nombre de jetons positif ou nul
		Place p1 = assertDoesNotThrow(() -> new Place(0));// Crée une place avec 0 jetons
		Place p2 = assertDoesNotThrow(() -> new Place(3));// Crée une place avec 3 jetons

		assertEquals(0, p1.getJetons(), "La place p1 doit avoir 0 jetons.");
		assertEquals(3, p2.getJetons(), "La place p2 doit avoir 3 jetons.");
		assertEquals(0, p1.getArcsSortants().size(), "La place p1 ne doit pas avoir d'arcs sortants.");
		assertEquals(0, p2.getArcsEntrants().size(), "La place p2 ne doit pas avoir d'arcs entrants.");
	}

    // Test de création d'une place avec un nombre négatif de jetons
	@Test
	void CP2() {
		Exception exception = assertThrows(NegativeToken.class, () -> {
			new Place(-1); // Crée une place avec -1 jeton, ce qui devrait lever une exception
		});
		assertEquals("negative Token !!!", exception.getMessage());

	}

	  // Vérifie la création d'une transition sans arcs

	@Test
	void CT0() {
		Transition t = new Transition();
		assertEquals(0, t.getArcsSortants().size());
		assertEquals(0, t.getArcsEntrants().size());
		assertEquals("transition, Isolée", t.toString());

	}
	 // Tests de création d'arcs avec différents types

	@Test
	void CA0() {
		 // Création d'arcs avec différents types pour vérifier leur bon fonctionnement
		ArcSortantNormal arc1 = assertDoesNotThrow(() -> new ArcSortantNormal(2, new Place(), new Transition()));
		ArcVideur arc2 = assertDoesNotThrow(() -> new ArcVideur(new Place(3), new Transition()));
		ArcZero arc3 = assertDoesNotThrow(() -> new ArcZero(new Place(0), new Transition()));
		ArcEntrant arc4 = assertDoesNotThrow(() -> new ArcEntrant(4, new Place(8), new Transition()));
		// Vérification des attributs pour chaque type d'arc
		
		// pour arc sortant normal
		assertEquals(2, arc1.getPoids());
		assertEquals(0, arc1.getPlace().getJetons());
		assertEquals(0, arc1.getPlace().getArcsEntrants().size());
		assertEquals(1, arc1.getPlace().getArcsSortants().size());
		assertEquals(1, arc1.getTransition().getArcsEntrants().size());
		assertEquals(0, arc1.getTransition().getArcsSortants().size());
		// pour arc videu :
		assertEquals(3, arc2.getPlace().getJetons());
		assertEquals(0, arc2.getPlace().getArcsEntrants().size());
		assertEquals(1, arc2.getPlace().getArcsSortants().size());
		assertEquals(1, arc2.getTransition().getArcsEntrants().size());
		assertEquals(0, arc2.getTransition().getArcsSortants().size());
		// pour arc zero
		assertEquals(0, arc3.getPlace().getJetons());
		assertEquals(0, arc3.getPlace().getArcsEntrants().size());
		assertEquals(1, arc3.getPlace().getArcsSortants().size());
		assertEquals(1, arc3.getTransition().getArcsEntrants().size());
		assertEquals(0, arc3.getTransition().getArcsSortants().size());
		// pour arc entrant de la place
		assertEquals(4, arc4.getPoids());
		assertEquals(8, arc4.getPlace().getJetons());
		assertEquals(1, arc4.getPlace().getArcsEntrants().size());
		assertEquals(0, arc4.getPlace().getArcsSortants().size());
		assertEquals(0, arc4.getTransition().getArcsEntrants().size());
		assertEquals(1, arc4.getTransition().getArcsSortants().size());

	}
	// Test des exceptions pour des valeurs incorrectes dans les arcs
	@Test
	void CA1() {
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

		// pour arc videur
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
	
	 // Test des opérations sur les jetons dans une place

	@Test
	void CAJ() {
		Place p = assertDoesNotThrow(() -> new Place(1));

		Exception exception = assertThrows(NegativeToken.class, () -> {
			p.setJetons(-1); // Crée une place avec -1 jeton, ce qui devrait lever une exception
		});
		assertEquals("negative Token !!!", exception.getMessage());

		assertEquals(1, p.getJetons());
		assertDoesNotThrow(() -> p.setJetons(5));
		assertEquals(5, p.getJetons());

	}
	// Test de suppression de jetons en excès dans une place
	@Test
	void CEJ() {
		Place p = assertDoesNotThrow(() -> new Place(3));

		Exception exception = assertThrows(ExceedExistingToken.class, () -> {
			p.enleverJetons(4);
			// Crée une place avec -1 jeton, ce qui devrait lever une exception
		});
		assertEquals("you try to remove more than what is inside : place", exception.getMessage());

		assertEquals(3, p.getJetons());
		assertDoesNotThrow(() -> p.enleverJetons(3));
		assertEquals(0, p.getJetons());

	}
	// Vérifie le réglage et la vérification des poids dans les arcs
	@Test
	void CCW0() {
		Place p1 = assertDoesNotThrow(() -> new Place());
		Transition t1 = new Transition();
		Place p2 = assertDoesNotThrow(() -> new Place());
		Transition t2 = new Transition();
		ArcEntrant arc1 = assertDoesNotThrow(() -> new ArcEntrant(0, p1, t1));
		ArcSortantNormal arc2 = assertDoesNotThrow(() -> new ArcSortantNormal(0, p2, t2));
		assertEquals(0, arc1.getPoids());
		assertEquals(0, arc2.getPoids());
		assertDoesNotThrow(() -> arc1.setPoids(2));
		assertDoesNotThrow(() -> arc2.setPoids(2));
		assertEquals(2, arc1.getPoids());
		assertEquals(2, arc2.getPoids());

	}
	 // Vérifie la gestion des arcs en double
	@Test
	void CCW1() {
		Place p1 = assertDoesNotThrow(() -> new Place());
		Transition t1 = new Transition();
		Place p2 = assertDoesNotThrow(() -> new Place());
		Transition t2 = new Transition();
		ArcEntrant arc1 = assertDoesNotThrow(() -> new ArcEntrant(0, p1, t1));
		ArcSortantNormal arc2 = assertDoesNotThrow(() -> new ArcSortantNormal(0, p2, t2));

		Exception exception = assertThrows(NegativeWeight.class, () -> {
			arc1.setPoids(-3);
			// Crée une place avec -1 jeton, ce qui devrait lever une exception
		});
		assertEquals("arc avec poids negatif !!!", exception.getMessage());
		Exception exception2 = assertThrows(NegativeWeight.class, () -> {
			arc2.setPoids(-3);
			// Crée une place avec -1 jeton, ce qui devrait lever une exception
		});
		assertEquals("arc avec poids negatif !!!", exception2.getMessage());

		assertEquals(0, arc1.getPoids());
		assertEquals(0, arc2.getPoids());
	}

	// Vérifie la gestion des places déjà existantes dans le réseau
	@Test
	void TEA() {
		Place p = assertDoesNotThrow(() -> new Place());
		Transition t = new Transition();
		ArcEntrant arc1 = assertDoesNotThrow(() -> new ArcEntrant(0, p, t));
		Exception exception = assertThrows(ExistingArc.class, () -> {
			new ArcEntrant(0, p, t);

		});
		assertEquals("arc already exists", exception.getMessage());

	}
	// Vérifie la gestion des transitions déjà existantes dans le réseau
	@Test
	void TEP() {
		Place p = new Place();
		Reseau_Petri network = new Reseau_Petri();
		assertDoesNotThrow(() -> {
			network.ajouter_Place(p);
		});

		assertEquals(1, network.getPlaces().size());

		Exception exception = assertThrows(ExistingPlace.class, () -> {
			network.ajouter_Place(p);
		});
		assertEquals("place deja existe!", exception.getMessage());
	}

	@Test
	void TET() {
		Transition t = new Transition();
		Transition t2 = new Transition();
		Reseau_Petri network = new Reseau_Petri();
		assertDoesNotThrow(() -> {
			network.ajouter_Tarnsition(t);
		});
		assertDoesNotThrow(() -> {
			network.ajouter_Tarnsition(t2);
		});

		assertEquals(2, network.getTransitions().size());

		Exception exception = assertThrows(ExistingTransition.class, () -> {
			network.ajouter_Tarnsition(t);
		});
		assertEquals(2, network.getTransitions().size());
		assertEquals("transition deja existe!", exception.getMessage());
	}
	@Test 
	void creationArcVideur() {
		Transition t = new Transition();
		Place p=assertDoesNotThrow(()->  new Place(2));
		Exception e =assertThrows(NullPlaceException.class, () -> {
			new ArcVideur(null, t);}); 
			assertEquals("place est null !!! ", e.getMessage());
			Exception e2 =assertThrows(NullTransitionException.class, () -> {
				new ArcVideur(p, null);}); 
				assertEquals("transition null !!", e2.getMessage());
				Place p2 = assertDoesNotThrow(() -> 
					new Place(0));
				Transition t2 = new Transition();
				ArcVideur aV= assertDoesNotThrow(()->
					new ArcVideur(p2, t2)
				);
				assertEquals(false, aV.arcIsFireable());

				Transition t3 = new Transition();
				Place p3 =assertDoesNotThrow(()-> new Place(2));
			ArcVideur arcVi= assertDoesNotThrow(()-> new ArcVideur(p3, t3));
			assertEquals(true,arcVi.arcIsFireable() );
			assertDoesNotThrow(()->arcVi.update_jeton_place());
			assertEquals(0, p3.getJetons());
			assertEquals(1,t3.getArcsEntrants().size());
			Exception e4 =assertThrows(ExistingArc.class, () -> {new ArcVideur(p3, t3);}); 
				assertEquals("arc already exists", e4.getMessage());
				
				Transition t4 = new Transition();
				Place p4 =assertDoesNotThrow(()-> new Place(2));
			ArcVideur arcVi2 = assertDoesNotThrow(()->new ArcVideur(p4, t4));
			assertEquals(true, arcVi2.equals(arcVi2));
			assertEquals(false,arcVi.equals(arcVi2));
			assertEquals(false, arcVi.equals(t3));
			assertEquals(false,arcVi.equals(aV));
			
		
			
		
	}

}
