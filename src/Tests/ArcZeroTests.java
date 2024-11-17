package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exceptions.ExistingArc;
import Exceptions.NullPlaceException;
import Exceptions.NullTransitionException;
import Metier.ArcSortantNormal;
import Metier.ArcVideur;
import Metier.ArcZero;
import Metier.Place;
import Metier.Transition;

class ArcZeroTests {

	@Test
	void test() {
		Transition t = new Transition();
		Place p = new Place();
		Exception e = assertThrows(NullPlaceException.class, () -> {
			new ArcZero(null, t);}); 
		assertEquals("place est null !!! ", e.getMessage());
		Exception e2 =assertThrows(NullTransitionException.class, () -> {
			new ArcZero(p, null);}); 
			assertEquals("transition null !!", e2.getMessage());
		assertEquals(0,p.getJetons());
		ArcZero arcZ1= assertDoesNotThrow( ()-> new ArcZero(p, t));
		assertEquals(true, arcZ1.arcIsFireable());
		Place p2 = assertDoesNotThrow(()-> new Place(2));
		Transition t2 = new Transition();
		ArcZero arcZ2= assertDoesNotThrow( ()-> new ArcZero(p2, t2));
		assertEquals(false, arcZ2.arcIsFireable());
		assertEquals(true, arcZ1.isActive());
		assertEquals(false, arcZ2.isActive());
		assertEquals(1, t.getArcsEntrants().size());
		assertEquals(1, t2.getArcsEntrants().size());
		assertEquals(false, arcZ1.equals(arcZ2));
		assertEquals(true, arcZ1.equals(arcZ1));
		assertEquals(false, arcZ1.equals(null));
		assertEquals(false, arcZ1.equals(null));
		Exception e3 =assertThrows(ExistingArc.class, () -> {
			t.add_to_arc_entrant(arcZ1);}); 
			assertEquals("arc already exists", e3.getMessage());
		
		assertEquals(1, t.getArcsEntrants().size());
		assertDoesNotThrow(()-> t.remove_from_arc_entrant(arcZ1));
		assertEquals(0, t.getArcsEntrants().size());
		
		
		
	}
	

}
