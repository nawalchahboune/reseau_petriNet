package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exceptions.ExistingArc;
import Exceptions.NegativeToken;
import Exceptions.NullPlaceException;
import Exceptions.NullTransitionException;
import Metier.ArcEntrant;
import Metier.ArcSortant;
import Metier.ArcSortantNormal;
import Metier.Place;
import Metier.Transition;

class TestsAffichage {

	@Test
	public void testAfficherTransitionIsolée() {
	    Transition transition = new Transition(); // Transition sans arcs
	    String result = transition.toString(); // Appel de la méthode d'affichage
	    assertEquals("transition, Isolée", result, "La transition isolée doit s'afficher sans arcs.");
	}

	@Test
	public void testAffocherTransitionAvecArcsEntrants() throws NullPlaceException, NullTransitionException, NegativeToken {
	    Transition t = new Transition();
	    ArcSortantNormal arc = new ArcSortantNormal(1, new Place(0), t); // poids modifié pour éviter la confusion avec zéro
	    try {
			t.add_to_arc_entrant(arc);
		} catch (ExistingArc e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

	    String expectedOutput = "transition, 0 arc(s) sortant(s) // arc(s) entrant(s) ==> 1 arc(s) entrant(s) normal / 0 arc(s) entrant(s) videur / 0 arc(s) entrant(s) zero .";
	    String result = t.toString();
	    assertEquals(expectedOutput, result, "L'affichage de la transition avec un arc entrant doit correspondre au format attendu.");
	}
	@Test
	public void testAfficherTransitionAvecArcsSortants() throws NullPlaceException, NullTransitionException, NegativeToken {
	    Transition t = new Transition();
	    ArcEntrant arc = new ArcEntrant(1, new Place(0),t); // Ajout d'un arc sortant avec un poids

	    try {
			t.add_to_arc_sortant(arc);
		} catch (ExistingArc e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

	    String expectedOutput = "transition, 1 arc(s) sortant(s) ";
	    String result = t.toString();
	    assertEquals(expectedOutput, result, "L'affichage de la transition avec un arc sortant doit correspondre au format attendu.");
	}
	@Test
	public void testAfficherTransitionAvecArcsEntrantsEtSortants() throws NullPlaceException, NullTransitionException, NegativeToken {
	    // Création de la transition
	    Transition t = new Transition();

	    // Création et ajout d'un arc entrant
	    ArcSortantNormal arcEntrant = new ArcSortantNormal(1, new Place(2), t);
	    try {
			t.add_to_arc_entrant(arcEntrant);
		} catch (ExistingArc e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

	    // Création et ajout d'un arc sortant
	    ArcEntrant arcSortant = new ArcEntrant(1, new Place(0),t);
	    try {
			t.add_to_arc_sortant(arcSortant);
		} catch (ExistingArc e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

	    // Résultat attendu (format d'affichage attendu)
	    String expectedOutput = "transition, 1 arc(s) sortant(s) // arc(s) entrant(s) ==> 1 arc(s) entrant(s) normal / 0 arc(s) entrant(s) videur / 0 arc(s) entrant(s) zero .";
	    String result = t.toString();

	    // Vérification du résultat
	    assertEquals(expectedOutput, result, "L'affichage de la transition avec des arcs entrants et sortants doit correspondre au format attendu.");
	}





}
