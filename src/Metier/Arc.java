package Metier;

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
	public abstract  void add_arc_to_transition();
	public abstract void remove_arc_from_transition();

}
