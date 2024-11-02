package Metier;

import Exceptions.ExistingArcException;
import Exceptions.NegativeToken;
import Exceptions.NullPlaceException;
import Exceptions.NullTransitionException;

public class ArcEntrant extends Arc {
	private int poids;
	public ArcEntrant() {
		super();
		this.poids = 0;
		
	}
	public ArcEntrant(int poids ,Place place, Transition transition) throws NullPlaceException, NullTransitionException {
		
		super(place, transition);
		this.poids=poids;
		if(place==null) {
			throw new NullPlaceException();
		}
		if(transition==null) {
			throw new NullTransitionException();
		}
		
	}
	
	public void setPoids(int poids) {
		this.poids = poids;
		
	}
	
	public int getPoids() {
		return this.poids;
	}
    
	public void update_jetons_place() throws NegativeToken {
		int a = this.getPlace().getJetons();
		if(a + this.poids>=0) {
			this.getPlace().setJetons(a + this.poids);
		}else {
			throw new NegativeToken();
		}
		
	}

	@Override
	public void add_arc_to_transition() {
		try {
			this.getTransition().add_to_arc_sortant(this);
		}catch(ExistingArcException e) {
			e.getMessage();
		}
		
	}

	@Override
	public void remove_arc_from_transition() {
		// TODO Auto-generated method stub
		this.getTransition().remove_from_arc_Sortant(this);
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
