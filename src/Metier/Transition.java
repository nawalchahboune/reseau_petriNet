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
	
	public boolean isTirable() {
		return tirable;
	}
	public  ArrayList<ArcEntrant> getArcsSortants() {
		return   arcsSortants;
		
	}
	public  ArrayList<ArcSortant> getArcsEntrants() {
		
		return arcsEntrants  ;
	}
	public void add_to_arc_sortant(ArcEntrant arcEntrant) {
		
	}
	public void add_to_arc_entrant(ArcSortant arcSortant) {
		
	}
	public void remove_from_arc_Sortant(ArcEntrant arcEntrant) {
		
	}
	public void remove_from_arc_entrant(ArcSortant arcSortant) {
		
	}
	

}
