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
    
	public void update_jetons_place() {}

	@Override
	public void add_arc_to_transition() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove_arc_from_transition() {
		// TODO Auto-generated method stub
		
	}
}
