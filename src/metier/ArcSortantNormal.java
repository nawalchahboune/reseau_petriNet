package Metier;

import java.util.Iterator;

public class ArcSortantNormal extends ArcSortant {
	public int poids;
	public ArcSortantNormal(Place place, Transition transition) {
		// TODO Auto-generated constructor stub
		super(place, transition);
	}
	@Override
	public void update_jeton_place() {
		
		Iterator<ArcEntrant> it = this.transition.getArcsSortants().iterator();
		while(it.hasNext()) {
			int a = it.next().getPoids();
			int b = it.next().getPlace().getJetons();
			it.next().getPlace().setJetons(a+b); 
		}
		int c = this.place.getJetons() - this.poids;
		
		
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
