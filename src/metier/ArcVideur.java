package Metier;

import java.util.Iterator;

public class ArcVideur extends ArcSortant{
	private boolean active;
	public ArcVideur(Place place, Transition transition) {
		// TODO Auto-generated constructor stub
		super(place, transition);
	}
	@Override
	public void update_jeton_place() {
		// TODO Auto-generated method stub
		Iterator<ArcEntrant> it = this.transition.getArcsSortants().iterator();
		while(it.hasNext()) {
			int a = it.next().getPoids();
			int b = it.next().getPlace().getJetons();
			it.next().getPlace().setJetons(a+b); 
		}
		
	}
	@Override
	public boolean arcIsFireable() {
		if (this.place.jetons >=1) {return true;}
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
