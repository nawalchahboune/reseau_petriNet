package Metier;

public class ArcZero extends ArcSortant {
	private boolean active;
	public ArcZero(Place place, Transition transition) {
		// TODO Auto-generated constructor stub
		super(place, transition);
		
	}
	@Override
	public void update_jeton_place() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean arcIsFireable() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setActive(boolean active) {
		
	}
	
	public boolean isActive() {
		return false;
	}
	@Override
	public void add_arc_to_transition() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove_arc_from_transition() {
		// TODO Auto-generated method stub
		
	}

}
