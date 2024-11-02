package Metier;

import Exceptions.ExistingArcException;
import Exceptions.NegativeToken;
import Exceptions.NullPlaceException;
import Exceptions.NullTransitionException;

public class ArcSortantNormal extends ArcSortant {
	private int poids;
	
	
	public ArcSortantNormal(int poids,Place place, Transition transition) throws NullPlaceException, NullTransitionException {
		// TODO Auto-generated constructor stub
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
	@Override
	public void update_jeton_place() throws NegativeToken{
		int jetons = this.getPlace().getJetons();
		if(jetons-this.poids>=0) {
			this.getPlace().setJetons(jetons - this.poids);
		}else {
			throw new NegativeToken();
		}
			
		
	}
	@Override
	public boolean arcIsFireable() {
		// TODO Auto-generated method stub
		if (this.poids <= this.getPlace().getJetons()) {
			return true;
		}
		return false;
	}
	@Override
	public void add_arc_to_transition()  {
		try {
			this.getTransition().add_to_arc_entrant(this);
		} catch (ExistingArcException e) {
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
	    if (this == obj) return true; 
	    if (obj == null || getClass() != obj.getClass()) return false;

	    ArcSortantNormal other = (ArcSortantNormal) obj;

	    return this.poids == other.poids &&
	           (this.getPlace() != null && this.getPlace().equals(other.getPlace())) &&
	           (this.getTransition() != null && this.getTransition().equals(other.getTransition()));
	}

}
