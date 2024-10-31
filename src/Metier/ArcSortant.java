package Metier;

import Exceptions.NegativeToken;
import Exceptions.NullPlaceException;
import Exceptions.NullTransitionException;

public abstract class ArcSortant extends Arc{

	public ArcSortant(Place place, Transition transition) throws NullPlaceException , NullTransitionException{
		super(place, transition);
		if(place==null) {
			throw new NullPlaceException();
		}
		if(transition==null) {
			throw new NullTransitionException();
		}
	}
	
	public abstract void update_jeton_place() throws NegativeToken;
	
	public abstract boolean arcIsFireable();
    
}
