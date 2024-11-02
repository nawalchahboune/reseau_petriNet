package Metier;

import java.util.ArrayList;

import Exceptions.NegativeToken;

public class Place {
	private static int nb;
	private String name;
	private int jetons;
	private ArrayList<ArcSortant> arcsSortants;
	private ArrayList<ArcEntrant> arcsEntrants;
	
	public Place() {
		this.name = "PLACE_" +Integer.toString(nb);
		this.jetons=0;
		nb++;
	}
	public Place(int jetons) throws NegativeToken{
		if(jetons>=0) {
			this.jetons = jetons;
			this.name = "PLACE_" +Integer.toString(nb);
			this.arcsEntrants = new ArrayList<ArcEntrant>();
			this.arcsSortants = new ArrayList<ArcSortant>();
			nb++;
		}else {
			throw new NegativeToken();
		}
	}

	public int getJetons() {
		return jetons;
	}

	public void setJetons(int jetons) throws NegativeToken{
		if(jetons>=0) {

			this.jetons = jetons;
		}
		else {
			throw new NegativeToken();
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name+ " \n";
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
