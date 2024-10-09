package Metier;

import java.util.ArrayList;

public class Transition {
	private boolean tirable;
	private ArrayList<ArcSortant> arcsEntrants;
	private ArrayList<ArcEntrant> arcsSortants;
	public Transition(boolean tirable, ArrayList<ArcSortant> arcsSortants, ArrayList<ArcEntrant> arcsEntrants) {
		super();
		//A commenter porte à confusion
		this.tirable = tirable;
		this.arcsSortants = arcsEntrants;
		this.arcsEntrants = arcsSortants;
	}
	public void setTirable(boolean tirable) {
		this.tirable=tirable;
	}
	public void setTirable() {
		this.setTirable(true);
		for (ArcSortant arcEntrant : arcsEntrants) {
			if(!(arcEntrant.arcIsFireable())) {
				this.setTirable(false);
				break;
			}
			
		}
	}
	public boolean isTirable() {
		return tirable;
	}
	public  ArrayList<ArcEntrant> getArcsSortants() {
		return   arcsSortants;
		
	}
	public  ArrayList<ArcSortant> getArcsEntrants() {
		
		return arcsEntrants  ;
	}
	public void add_to_arc_sortant(ArcEntrant arcSortant) {
		this.arcsSortants.add(arcSortant);
		
	}
	public void add_to_arc_entrant(ArcSortant arcEntrant) {
		this.arcsEntrants.add(arcEntrant);
		
	}
	public void remove_from_arc_Sortant(ArcEntrant arcSortant) {
		this.arcsSortants.add(arcSortant);
		
	}
	public void remove_from_arc_entrant(ArcSortant arcEntrant) {
		this.arcsEntrants.add(arcEntrant);
		
	}
	

}
