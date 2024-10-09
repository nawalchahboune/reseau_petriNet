package Metier;

import java.util.ArrayList;

public class Transition {
	private boolean tirable;
	private ArrayList<ArcSortant> arcsSortants;
	private ArrayList<ArcEntrant> arcsEntrants;
	public Transition(boolean tirable, ArrayList<ArcSortant> arcsSortants, ArrayList<ArcEntrant> arcsEntrants) {
		super();
		this.tirable = tirable;
		this.arcsSortants = arcsSortants;
		this.arcsEntrants = arcsEntrants;
	}
	public void setTirable(boolean tirable) {
		this.tirable=tirable;
	}
	
	public boolean isTirable() {
		return tirable;
	}
	public ArrayList<ArcSortant> getArcsSortants() {
		return arcsSortants;
	}
	public ArrayList<ArcEntrant> getArcsEntrants() {
		return arcsEntrants;
	}
	public void add_to_arc_entrant(ArcEntrant arcEntrant) {
		
	}
	public void add_to_arc_sortant(ArcSortant arcSortant) {
		
	}
	public void remove_from_arc_entrant(ArcEntrant arcEntrant) {
		
	}
	public void remove_from_arc_Sortant(ArcSortant arcSortant) {
		
	}
	

}
