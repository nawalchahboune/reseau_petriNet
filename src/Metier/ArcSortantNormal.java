package Metier;

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
	public int getPoids() {
		return this.poids;
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
	public void add_arc_to_transition() {
		this.getTransition().add_to_arc_entrant(this);
		
	}
	@Override
	public void remove_arc_from_transition() {
		this.getTransition().remove_from_arc_entrant(this);
		
	}
	
	public String toString() {
		//arc simple poids 1 (place avec 4 jetons vers transition)
		
		return "arc simple poids "+ this.getPoids() +
				" ( place avec "+this.getPlace().getJetons()+" jetons vers transition";
	}

}
