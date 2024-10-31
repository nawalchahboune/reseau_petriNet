package Metier;

import Exceptions.NegativeToken;
import Exceptions.NullPlaceException;
import Exceptions.NullTArcException;
import Exceptions.NullTransitionException;

public interface IReseauPetri {
	public void ajouter_Arc(Arc arc) throws NullTArcException;
	public void supprimer_Arc(Arc arc);
	public void ajouter_Place(Place place) throws NullPlaceException;
	public void supprimer_Place(Place place);
	public void ajouter_Tarnsition(Transition transition) throws NullTransitionException;
	public void supprimer_Tarnsition(Transition transition);
	public void fire(Transition transition) throws NullTransitionException, NegativeToken;
	public void fireAll();

}
