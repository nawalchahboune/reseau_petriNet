package Metier;

import Exceptions.ExistingArc;
import Exceptions.NegativeToken;
import Exceptions.NegativeWeight;
import Exceptions.NullPlaceException;
import Exceptions.NullTransitionException;

public class ArcSortantNormal extends ArcSortant {
	private int poids;
	
	
	public ArcSortantNormal(int poids,Place place, Transition transition) throws NullPlaceException, NegativeWeight, NullTransitionException, ExistingArc {
		// TODO Auto-generated constructor stub
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
		//il faut ajouter l'arc au liste des arcs entrants de la transition associé !
		transition.add_to_arc_entrant(this);
		place.add_to_arc_sortant(this);
	}

	
	public void setPoids(int poids) throws NegativeWeight {
		if(poids<0) {
			throw new NegativeWeight();
		}
		else {

			this.poids = poids;
		}
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
	public void add_arc_to_transition()  {
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

	public String toString() {
		//arc simple poids 1 (place avec 4 jetons vers transition)
		
		return "arc simple poids "+ this.getPoids() +
				" ( place avec "+this.getPlace().getJetons()+" jetons vers transition" ;
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
