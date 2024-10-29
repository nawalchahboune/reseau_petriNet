package Metier;

public class ArcEntrant extends Arc {
	public int poids;
	public ArcEntrant(Place place, Transition transition) {
		// TODO Auto-generated constructor stub
		super(place, transition);
		
	}
	
	public void setPoids(int poids) {
		this.poids = poids;
		
	}
	
	public int getPoids() {
		return this.poids;
	}
    
	public void update_jetons_place() {
		this.place.jetons = this.poids;
	}

	@Override
	public void add_arc_to_transition() {
		this.transition.add_to_arc_sortant(this);
	}

	@Override
	public void remove_arc_from_transition() {
		// TODO Auto-generated method stub
		this.transition.remove_from_arc_Sortant(this);
	}
}
