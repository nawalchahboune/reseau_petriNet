package Metier;

import java.util.ArrayList;

public class Place {
	protected int jetons;
	protected ArrayList<ArcSortant> arcsSortants;
	protected ArrayList<ArcEntrant> arcsEntrants;
	
	
	public Place(int jetons) {
		super();
		this.jetons = jetons;
	}

	public int getJetons() {
		return jetons;
	}

	public void setJetons(int jetons) {
		this.jetons = jetons;
	}
	
	public  ArrayList<ArcEntrant> getArcsEntrants() {
		return  arcsEntrants ;
		
	}
	public  ArrayList<ArcSortant> getArcsSortants() {
		
		return  arcsSortants ;
	}
	public void add_to_arc_sortant(  ArcSortant arcSortant) {
		this.arcsSortants.add(arcSortant);
		
	}
	public void add_to_arc_entrant( ArcEntrant arc) {
		this.arcsEntrants.add(arc);
		
	}
	public void remove_from_arc_Sortant(ArcSortant arcSortant) {
		this.arcsSortants.add(arcSortant);
		
	}
	public void remove_from_arc_entrant( ArcEntrant arcEntrant) {
		this.arcsEntrants.add(arcEntrant);
		
	}
	

}
