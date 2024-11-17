package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exceptions.NegativeToken;
import Metier.ArcSortantNormal;
import Metier.Place;
import Metier.Transition;

class ArcSortantNormalTests {

	@Test
	void testToStringArc() {
	    // Création d'une place et d'une transition
		Place p = assertDoesNotThrow(()->new Place(4));
	    Transition t = new Transition();
	    
	    // Création de l'arc avec un poids de 1
	    
	    ArcSortantNormal arc = assertDoesNotThrow(()->new ArcSortantNormal(3,p, t));
	   assertDoesNotThrow(()-> arc.setPoids(1));// Poids de l'arc
	    
	    String expected = "arc simple poids 1 ( place avec 4 jetons vers transition";
	    
	    // Vérification
	    assertEquals(expected, arc.toString());
	}
	@Test
	void testUpdateJetons() {
		Place p = assertDoesNotThrow(()->new Place(4));
	    Transition t = new Transition();
	    
	    // Création de l'arc avec un poids de 1
	    
	    ArcSortantNormal arc = assertDoesNotThrow(()->new ArcSortantNormal(5,p, t));
	   
	   Exception e = assertThrows(NegativeToken.class,()-> arc.update_jeton_place());
	   assertEquals("negative Token !!!", e.getMessage());
	   assertDoesNotThrow(()->arc.setPoids(3));
	   assertDoesNotThrow(()-> arc.update_jeton_place() );
	   assertEquals(1,p.getJetons());
			   
	   
		
	}

}
