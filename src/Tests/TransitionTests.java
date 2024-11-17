package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Metier.ArcEntrant;
import Metier.ArcSortantNormal;
import Metier.ArcVideur;
import Metier.Place;
import Metier.Transition;

class TransitionTests {

	/*@Test
	void test() {
		Transition t = new Transition();
		
		assertEquals("Transition_1", t.getName());
		t.setName("ma transition");
		assertEquals("ma transition", t.getName());

		
	}*/
	@Test
	void testTirable() {
		Transition t = new Transition();
		Place p1= assertDoesNotThrow(()-> new Place(4));
		Place p2= assertDoesNotThrow(()-> new Place(3));
		Place p3 =new Place();
		ArcSortantNormal arc1 = assertDoesNotThrow(()-> new ArcSortantNormal(2, p1, t));
		ArcVideur arcV= assertDoesNotThrow( ()-> new ArcVideur(p3, t));
		ArcEntrant arcE = assertDoesNotThrow(()-> new ArcEntrant( 1, p2, t));
		assertEquals(false,t.isTirable());
		assertDoesNotThrow(()->p3.setJetons(4));
		assertEquals(true,t.isTirable());
		
	}

}
