package metier;

public class ArcSortantNormal extends ArcSortant {
	public int poids;
	public ArcSortantNormal(Place place, Transition transition) {
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
	@Override
	public void add_arc_to_transition() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove_arc_from_transition() {
		// TODO Auto-generated method stub
		
	}

}
