package Metier;

import java.util.ArrayList;

import Exceptions.ExistingArcException;

public class Transition {
	private static int nb;
	private String name;
	private boolean tirable;
	private ArrayList<ArcSortant> arcsEntrants;
	private ArrayList<ArcEntrant> arcsSortants;
	
	public Transition() {
		this.name = "Transition_" +Integer.toString(nb);
		this.tirable = false;
		this.arcsEntrants = new ArrayList<ArcSortant>();
		this.arcsSortants = new ArrayList<ArcEntrant>();
		nb++;
	}
	
	public Transition(boolean tirable, ArrayList<ArcSortant> arcsSortants, ArrayList<ArcEntrant> arcsEntrants) {
		//A commenter porte à confusion
		this.name = "Transition_" +Integer.toString(nb);
		this.tirable = tirable;
		this.arcsSortants = arcsEntrants;
		this.arcsEntrants = arcsSortants;
		nb++;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return  this.name+ " \n";
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
	public void add_to_arc_sortant(ArcEntrant arcSortant) throws ExistingArcException{
		if(this.arcsSortants.contains(arcSortant)) {
			throw new ExistingArcException();
		}
		else {
			this.arcsSortants.add(arcSortant);
		}
		
	}
	public void add_to_arc_entrant(ArcSortant arc) throws ExistingArcException {
		if(this.arcsSortants.contains(arc)) {
			throw new ExistingArcException();
		}
		else {
			this.arcsEntrants.add(arc);
		}
		
	}
	public void remove_from_arc_Sortant(ArcEntrant arcSortant) {
		this.arcsSortants.add(arcSortant);
		
	}
	public void remove_from_arc_entrant(ArcSortant arcEntrant) {
		this.arcsEntrants.add(arcEntrant);
		
	}
	

}
