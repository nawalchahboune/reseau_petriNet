package Metier;


public class ArcVideur extends ArcSortant{
	private boolean active;
	public ArcVideur(Place place, Transition transition) {
		// TODO Auto-generated constructor stub
		super(place, transition);
	}
	@Override
	public void update_jeton_place() {
		// TODO Auto-generated method stub
		this.getPlace().setJetons(0);
		
	}
	@Override
	public boolean arcIsFireable() {
		if (this.getPlace().getJetons() >=1) {return true;}
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
