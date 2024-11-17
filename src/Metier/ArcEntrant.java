package Metier;

import Exceptions.ExistingArc;
import Exceptions.NegativeToken;
import Exceptions.NegativeWeight;
import Exceptions.NullPlaceException;
import Exceptions.NullTransitionException;

public class ArcEntrant extends Arc {
	private int poids;
	
	public ArcEntrant(int poids ,Place place, Transition transition) throws NullPlaceException, NegativeWeight, NullTransitionException, ExistingArc {
		
		super(place, transition);
		this.poids=poids;
		if(place==null) {
			throw new NullPlaceException();
		}
		if(transition==null) {
			throw new NullTransitionException();
		}
		if(poids<0) {
			throw new NegativeWeight();
		}
		transition.add_to_arc_sortant(this);
		place.add_to_arc_entrant(this);
		
	}
	
	public void setPoids(int poids) throws NegativeWeight{
		if(poids<0) {
		throw new NegativeWeight();
	}
	else {

		this.poids = poids ;
		
	}
	}
	
	public int getPoids() {
		return this.poids;
	}
    
	public void update_jetons_place() throws NegativeToken {
		int a = this.getPlace().getJetons();
		if((a + this.poids>=0)) {
			this.getPlace().setJetons(a + this.poids);
		}else {
			throw new NegativeToken();
		}
		
	}

	
	@Override
	public String toString() {
		return "arc simple poids "+ this.getPoids() +
				"( transition vers place avec  "+this.getPlace().getJetons()+" jetons";
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true; 
	    if (obj == null || getClass() != obj.getClass()) return false;

	    ArcEntrant other = (ArcEntrant) obj;

	    return this.poids == other.poids &&
	           (this.getPlace() != null && this.getPlace().equals(other.getPlace())) &&
	           (this.getTransition() != null && this.getTransition().equals(other.getTransition()));

	}
}
