package Metier;

import Exceptions.ExistingArc;
import Exceptions.NullPlaceException;
import Exceptions.NullTransitionException;

public class ArcZero extends ArcSortant {
	private boolean active;
	public ArcZero(Place place, Transition transition) throws NullPlaceException , NullTransitionException, ExistingArc{
		// TODO Auto-generated constructor stub
		super(place, transition);
		this.active =false;
		
		transition.add_to_arc_entrant(this);
		place.add_to_arc_sortant(this);
	}
	@Override
	public void update_jeton_place() {

		
		
	}
	@Override
	public boolean arcIsFireable() {
		if (this.getPlace().getJetons() == 0) {
			this.setActive(true);
			return true;}
		this.setActive(false);
		return false;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public boolean isActive() {
		return active;
	}

	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true; // Vérification de référence
	    if (obj == null || getClass() != obj.getClass()) return false; // Vérification du type

	    ArcZero other = (ArcZero) obj;

	    // Comparaison des attributs poids, place et transition
	    return 
	           (this.getPlace() != null && this.getPlace().equals(other.getPlace())) &&
	           (this.getTransition() != null && this.getTransition().equals(other.getTransition()));
	}

}
