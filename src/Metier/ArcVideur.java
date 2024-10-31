package Metier;

import Exceptions.NegativeToken;
import Exceptions.NullPlaceException;
import Exceptions.NullTransitionException;

public class ArcVideur extends ArcSortant{
	private boolean active;
	public ArcVideur(Place place, Transition transition)  throws NullPlaceException , NullTransitionException{
		// TODO Auto-generated constructor stub
		super(place, transition);
		if(place==null) {
			throw new NullPlaceException();
		}
		if(transition==null) {
			throw new NullTransitionException();
		}
	}
	@Override
	public void update_jeton_place() throws NegativeToken {
		if(true) {

			this.getPlace().setJetons(0);
		}
		else {
			throw new NegativeToken();
		}
		
	}
	@Override
	public boolean arcIsFireable() {
		if (this.getPlace().getJetons() >=1) {return true;}
		return false;
	}
	@Override
	public void add_arc_to_transition() {
		this.getTransition().add_to_arc_entrant(this);
		
	}
	@Override
	public void remove_arc_from_transition() {
		this.getTransition().remove_from_arc_entrant(this);
		
	}

}
