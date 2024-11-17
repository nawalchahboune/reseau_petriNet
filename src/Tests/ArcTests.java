package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Metier.ArcEntrant;
import Metier.ArcSortantNormal;
import Metier.ArcVideur;
import Metier.ArcZero;
import Metier.Place;
import Metier.Transition;

class ArcTests {

	@Test
	void test() {
		
		Place p1 = assertDoesNotThrow(()->new Place(1));
		Place p2 = assertDoesNotThrow(()->new Place(2));
		Place p3= assertDoesNotThrow(()->new Place(3));
		Place p4 = assertDoesNotThrow(()->new Place(4));
		Transition t = new Transition();
		Transition t2 = new Transition();
		ArcSortantNormal arcSN= assertDoesNotThrow(()->new ArcSortantNormal(3, p1, t));
		ArcZero arcZero =assertDoesNotThrow(()-> new ArcZero(p2, t));
		ArcVideur arcVideur =assertDoesNotThrow(()-> new ArcVideur(p3, t));
		ArcEntrant arcEntrant =assertDoesNotThrow(()-> new ArcEntrant(4,p4, t));
		assertEquals(1,arcSN.getPlace().getJetons());
		assertEquals(2,arcZero.getPlace().getJetons());
		assertEquals(3,arcVideur.getPlace().getJetons());
		assertEquals(4,arcEntrant.getPlace().getJetons());
		// setPlace
		arcSN.setPlace(p4);
		arcZero.setPlace(p3);
		arcVideur.setPlace(p2);
		arcEntrant.setPlace(p1);
		assertEquals(4,arcSN.getPlace().getJetons());
		assertEquals(3,arcZero.getPlace().getJetons());
		assertEquals(2,arcVideur.getPlace().getJetons());
		assertEquals(1,arcEntrant.getPlace().getJetons());
		
		//setTransition
		arcSN.setTransition(t2);
		arcZero.setTransition(t2);
		arcEntrant.setTransition(t2);
		arcVideur.setTransition(t2);
		
		assertEquals(true, arcSN.getTransition().equals(t2));
		assertEquals(true, arcVideur.getTransition().equals(t2));
		assertEquals(true, arcZero.getTransition().equals(t2));
		assertEquals(true, arcEntrant.getTransition().equals(t2));
		
		
	}

}
