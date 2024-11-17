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
		/*
		 * 
		 * if(place==null) {
			throw new NullPlaceException();
		}
		if(transition==null) {
			throw new NullTransitionException();
		}
		 */
		transition.add_to_arc_entrant(this);
		place.add_to_arc_sortant(this);
	}
	@Override
	public void update_jeton_place() throws NegativeToken {
		if(active) {

			this.getPlace().setJetons(0);
		}
	}
	@Override
	public boolean arcIsFireable() {
		if (this.getPlace().getJetons() >=1) {
			this.active=true;
			return true;}
		else {
			this.active=false;
			return false;
		}
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
