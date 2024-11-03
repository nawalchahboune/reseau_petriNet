package Metier;

import Exceptions.*;
import Exceptions.ExistingArc;
import Exceptions.NegativeToken;
import Exceptions.NullPlaceException;
import Exceptions.NullTArcException;
import Exceptions.NullTransitionException;
import Exceptions.UnknownPlaceException;
import Exceptions.UnknownTransitionException;
public interface IReseauPetri {
	public void ajouter_Arc(Arc arc) throws NullTArcException, ExistingArc, UnknownPlaceException, UnknownTransitionException;
	public void supprimer_Arc(Arc arc);
	public void ajouter_Place(Place place) throws NullPlaceException , ExistingPlace;
	public void supprimer_Place(Place place);
	public void ajouter_Tarnsition(Transition transition) throws NullTransitionException;
	public void supprimer_Tarnsition(Transition transition);
	public void ajouterJetons(Place place , int jetons) throws NegativeToken , NullPlaceException ;
	public void enleverJetons(Place place , int jetons) throws NegativeToken,ExceedExistingToken, NullPlaceException ;
	public void chnagerPoids(Arc arc , int poids) throws NullTArcException;
	public void fire(Transition transition) throws NullTransitionException, NegativeToken;
	public void fireAll();

}
