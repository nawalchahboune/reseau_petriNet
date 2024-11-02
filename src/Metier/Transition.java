package Metier;

import java.util.ArrayList;

public class Transition {
	private boolean tirable;
	private ArrayList<ArcSortant> arcsEntrants;
	private ArrayList<ArcEntrant> arcsSortants;
	
	public Transition() {
		this.tirable = false;
		this.arcsEntrants = new ArrayList<ArcSortant>();
		this.arcsSortants = new ArrayList<ArcEntrant>();
	}
	
	public Transition(boolean tirable, ArrayList<ArcSortant> arcsSortants, ArrayList<ArcEntrant> arcsEntrants) {
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
	public void add_to_arc_entrant(ArcSortant arc) {
		this.arcsEntrants.add(arc);
		
	}
	public void remove_from_arc_Sortant(ArcEntrant arcSortant) {
		this.arcsSortants.add(arcSortant);
		
	}
	public void remove_from_arc_entrant(ArcSortant arcEntrant) {
		this.arcsEntrants.add(arcEntrant);
	}
	@Override
	public String toString() {
	    int Enormal = 0;
	    int Evideur = 0;
	    int Ezero = 0;
	    String s = "transition, ";

	    if (arcsEntrants.isEmpty() && arcsSortants.isEmpty()) {
	        s += "Isolée";
	    } else {
	        if (!arcsSortants.isEmpty()) {
	            s += this.getArcsSortants().size() + " arc(s) sortant(s) ";
	        } else {
	            s += "0 arc(s) sortant(s) ";
	        }

	        if (!arcsEntrants.isEmpty()) {
	            s += "// arc(s) entrant(s) ==> ";
	            for (ArcSortant arcEntrant : this.getArcsEntrants()) {
	                if (arcEntrant instanceof ArcSortantNormal) {
	                    Enormal++;
	                } else if (arcEntrant instanceof ArcVideur) {
	                    Evideur++;
	                } else if (arcEntrant instanceof ArcZero) {
	                    Ezero++;
	                }
	            }
	            s += Enormal + " arc(s) entrant(s) normal / "
	                 + Evideur + " arc(s) entrant(s) videur / "
	                 + Ezero + " arc(s) entrant(s) zero .";
	        }
	    }

	    return s;
	}


}
