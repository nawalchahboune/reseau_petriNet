package Metier;

import java.util.ArrayList;

import Exceptions.ExistingArc;

public class Transition {
	private boolean tirable;
	private ArrayList<ArcSortant> arcsEntrants;
	private ArrayList<ArcEntrant> arcsSortants;
	
	public Transition() {

		
		this.tirable = false;
		this.arcsEntrants = new ArrayList<ArcSortant>();
		this.arcsSortants = new ArrayList<ArcEntrant>();
		
	}
	
	/* blic Transition( ArrayList<ArcSortant> arcsSortants, ArrayList<ArcEntrant> arcsEntrants) {
		//A commenter porte à confusion

		this.name = "Transition_" +Integer.toString(nb);
		this.tirable = tirable;
		this.arcsSortants = arcsEntrants;
		this.arcsEntrants = arcsSortants;
		nb++;
	}
	*/
	
	
	
	public void setTirable(boolean tirable) {
		//
		
		this.tirable=tirable;
	}

	public boolean isTirable() {
		tirable =true;
		for (ArcSortant arcEntrant : arcsEntrants) {
			//en  vérifie si l'arc est fireable; si il ne l'est pas transition est non plus tirable
			if(!arcEntrant.arcIsFireable()) {
				tirable =false;
				break;
			}
		}
		return tirable;
	}
	public  ArrayList<ArcEntrant> getArcsSortants() {
		return   arcsSortants;
		
	}
	public  ArrayList<ArcSortant> getArcsEntrants() {
		
		return arcsEntrants  ;
	}
	public void add_to_arc_sortant(ArcEntrant arcSortant) throws ExistingArc{
		if(this.arcsSortants.contains(arcSortant)) {
			throw new ExistingArc();
		}
		else {
			this.arcsSortants.add(arcSortant);
		}
		
	}
	public void add_to_arc_entrant(ArcSortant arc) throws ExistingArc {
		if(this.arcsEntrants.contains(arc)) {
			throw new ExistingArc();
		}
		else {
			this.arcsEntrants.add(arc);
		}
		
	}
	public void remove_from_arc_Sortant(ArcEntrant arcSortant) {
		this.arcsSortants.remove(arcSortant);
		
	}
	public void remove_from_arc_entrant(ArcSortant arcEntrant) {
		this.arcsEntrants.remove(arcEntrant);
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
	/*
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true; // Vérification de référence
	    if (obj == null || getClass() != obj.getClass()) return false; // Vérification du type

	    Transition other = (Transition) obj;

	    // Comparaison des attributs poids, place et transition
	    return  
	           (this.getArcsSortants() != null && this.getArcsSortants().size()==other.getArcsSortants().size()) &&
	           (this.getArcsEntrants() != null && this.getArcsEntrants().size()==other.getArcsEntrants().size());

		
	}
*/

}
