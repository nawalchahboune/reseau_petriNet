package Metier;

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
		this.getTransition().add_to_arc_entrant(this);
	}
	@Override
	public void remove_arc_from_transition() {
		// TODO Auto-generated method stub
		
	}

}
