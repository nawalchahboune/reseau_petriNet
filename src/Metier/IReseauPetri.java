package Metier;

import Exceptions.*;
public interface IReseauPetri {
	public void ajouter_Arc(Arc arc) throws NullTArcException, ExistingArc, ExistingPlace, ExistingTransition;
	public void supprimer_Arc(Arc arc);
	public void ajouter_Place(Place place) throws NullPlaceException , ExistingPlace;
	public void supprimer_Place(Place place);
	public void ajouter_Tarnsition(Transition transition) throws NullTransitionException , ExistingTransition;
	public void supprimer_Tarnsition(Transition transition);
	public void ajouterJetons(Place place , int jetons) throws NegativeToken , NullPlaceException ;
	public void enleverJetons(Place place , int jetons) throws NegativeToken,ExceedExistingToken, NullPlaceException ;
	public void chnagerPoids(Arc arc , int poids) throws NullTArcException, NegativeWeight;
	public void fire(Transition transition) throws NullTransitionException, NegativeToken;
	public void fireAll();

}
