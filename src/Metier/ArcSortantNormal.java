package Metier;

public class ArcSortantNormal extends ArcSortant {
	public int poids;
	public ArcSortantNormal(Place place, Transition transition) {
		// TODO Auto-generated constructor stub
		super(place, transition);
	}
	@Override
	public void update_jeton_place() {
		this.place.jetons -= this.poids;
		
	}
	@Override
	public boolean arcIsFireable() {
		// TODO Auto-generated method stub
		if (this.poids <= this.place.jetons) {
			return true;
		}
		return false;
	}
	@Override
	public void add_arc_to_transition() {
		this.transition.add_to_arc_entrant(this);
		
	}
	@Override
	public void remove_arc_from_transition() {
		this.transition.remove_from_arc_entrant(this);
		
	}

}
