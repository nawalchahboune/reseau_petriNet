package Metier;

import Exceptions.ExistingArc;

public abstract class Arc {
	private Place place;
	private Transition transition;

	

	
	public Arc(Place place, Transition transition) {
		
		this.place = place;
		this.transition = transition;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	public Transition getTransition() {
		return transition;
	}
	public void setTransition(Transition transition) {
		this.transition = transition;
	}
	// supression des deux methodes d'jout de l'arc ou de sa supression au niveau de 
	// la transition ou la place associé; parceque ces qeux methodes sont deja implementées dans transition et place
}
