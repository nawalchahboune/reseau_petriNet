package Metier;

import Exceptions.ExistingArc;
import Exceptions.NullPlaceException;
import Exceptions.NullTransitionException;

public class ArcZero extends ArcSortant {
	private boolean active;
	public ArcZero(Place place, Transition transition) throws NullPlaceException , NullTransitionException{
		// TODO Auto-generated constructor stub
		super(place, transition);
		this.active =false;
		if(place==null) {
			throw new NullPlaceException();
		}
		if(transition==null) {
			throw new NullTransitionException();
		}
	}
	@Override
	public void update_jeton_place() {

		
		
	}
	@Override
	public boolean arcIsFireable() {
		if (this.getPlace().getJetons() == 0) {return true;}
		return false;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public boolean isActive() {
		return false;
	}
	@Override
	public void add_arc_to_transition() {
		try {
			this.getTransition().add_to_arc_entrant(this);
		} catch (ExistingArc e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	@Override
	public void remove_arc_from_transition() {
		// TODO Auto-generated method stub
		
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
