package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exceptions.ExistingArc;
import Exceptions.NegativeToken;
import Exceptions.NegativeWeight;
import Exceptions.NullPlaceException;
import Exceptions.NullTransitionException;
import Metier.ArcEntrant;
import Metier.ArcSortant;
import Metier.ArcSortantNormal;
import Metier.Place;
import Metier.Transition;

class TestsAffichage {
	
	
	// Test de l'affichage d'une transition isolée, sans arcs
	@Test
	public void testAfficherTransitionIsolée() {
	    Transition transition = new Transition(); // Transition sans arcs
	    String result = transition.toString(); // Appel de la méthode d'affichage
	    assertEquals("transition, Isolée", result, "La transition isolée doit s'afficher sans arcs.");
	}
	// Test de l'affichage d'une transition avec un arc entrant uniquement
	@Test
	public void testAfficherTransitionAvecArcsEntrants() {
	    Transition t = new Transition();
	    Place p  = assertDoesNotThrow(()-> new Place(0));
	    ArcSortantNormal arc = assertDoesNotThrow(()-> new ArcSortantNormal(1, p, t)); // poids modifié pour éviter la confusion avec zéro
	 
	
	 // Format attendu pour une transition avec un arc entrant normal
	    String expectedOutput = "transition, 0 arc(s) sortant(s) // arc(s) entrant(s) ==> 1 arc(s) entrant(s) normal / 0 arc(s) entrant(s) videur / 0 arc(s) entrant(s) zero .";

	    String result = t.toString(); // Résultat de l'affichage de la transition
	    assertEquals(expectedOutput, result, "L'affichage de la transition avec un arc entrant doit correspondre au format attendu.");
	}
	
	// Test de l'affichage d'une transition avec un arc sortant uniquement
	@Test
	public void testAfficherTransitionAvecArcsSortants() {
	    Transition t = new Transition();
	    ArcEntrant arc = assertDoesNotThrow(()-> new ArcEntrant(1, new Place(0),t)); // Ajout d'un arc sortant avec un poids

	    // Format attendu pour une transition avec un arc sortant
	    String expectedOutput = "transition, 1 arc(s) sortant(s) ";
	    String result = t.toString();  	 // Résultat de l'affichage de la transition
	    assertEquals(expectedOutput, result, "L'affichage de la transition avec un arc sortant doit correspondre au format attendu.");
	}
	
	// Test de l'affichage d'une transition avec un arc entrant et un arc sortant
	@Test
	public void testAfficherTransitionAvecArcsEntrantsEtSortants() {
	    
		
	    Transition t = new Transition();
	    ArcSortantNormal arcEntrant =assertDoesNotThrow(()-> new ArcSortantNormal(1, new Place(2), t));
	   
	    ArcEntrant arcSortant = assertDoesNotThrow(()-> new ArcEntrant(1, new Place(0),t));
	    

	    // Format attendu pour une transition avec un arc sortant
	    String expectedOutput = "transition, 1 arc(s) sortant(s) // arc(s) entrant(s) ==> 1 arc(s) entrant(s) normal / 0 arc(s) entrant(s) videur / 0 arc(s) entrant(s) zero .";
	    String result = t.toString();  // Résultat de l'affichage de la transition

	    
	    assertEquals(expectedOutput, result, "L'affichage de la transition avec des arcs entrants et sortants doit correspondre au format attendu.");
	}





}
