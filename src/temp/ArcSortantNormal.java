package Metier;


public class ArcSortantNormal extends ArcSortant {
	private int poids;
	
	
	public ArcSortantNormal(Place place, Transition transition) {
		// TODO Auto-generated constructor stub
		super(place, transition);
	}
	
	public void setPoids(int poids) {
		this.poids = poids;
	}
	@Override
	public void update_jeton_place() {
		int jetons = this.getPlace().getJetons();
		this.getPlace().setJetons(jetons - this.poids);
	}
	@Override
	public boolean arcIsFireable() {
		// TODO Auto-generated method stub
		if (this.poids <= this.getPlace().getJetons()) {
			return true;
		}
		return false;
	}
	@Override
	public void add_arc_to_transition() {
		this.getTransition().add_to_arc_entrant(this);
		
	}
	@Override
	public void remove_arc_from_transition() {
		this.getTransition().remove_from_arc_entrant(this);
		
	}

}
