package Metier;

public class ArcEntrant extends Arc {
	private int poids;
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
		int a = this.getPlace().getJetons();
		this.getPlace().setJetons(a + this.poids);
	}

	@Override
	public void add_arc_to_transition() {
		this.getTransition().add_to_arc_sortant(this);
	}

	@Override
	public void remove_arc_from_transition() {
		// TODO Auto-generated method stub
		this.getTransition().remove_from_arc_Sortant(this);
	}
}