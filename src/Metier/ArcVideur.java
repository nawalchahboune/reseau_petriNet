package Metier;

import Exceptions.ExistingArc;
import Exceptions.NegativeToken;
import Exceptions.NullPlaceException;
import Exceptions.NullTransitionException;

public class ArcVideur extends ArcSortant{
	private boolean active;
	public ArcVideur(Place place, Transition transition)  throws NullPlaceException , NullTransitionException, ExistingArc{
		// TODO Auto-generated constructor stub
		super(place, transition);
		if(place==null) {
			throw new NullPlaceException();
		}
		if(transition==null) {
			throw new NullTransitionException();
		}
		transition.add_to_arc_entrant(this);
		place.add_to_arc_sortant(this);
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
		try {
			this.getTransition().add_to_arc_entrant(this);
		} catch (ExistingArc e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
	}
	@Override
	public void remove_arc_from_transition() {
		this.getTransition().remove_from_arc_entrant(this);
		
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true; // Vérification de référence
	    if (obj == null || getClass() != obj.getClass()) return false; // Vérification du type

	    ArcVideur other = (ArcVideur) obj;

	    // Comparaison des attributs poids, place et transition
	    return  
	           (this.getPlace() != null && this.getPlace().equals(other.getPlace())) &&
	           (this.getTransition() != null && this.getTransition().equals(other.getTransition()));
	}


}
