package Metier;

import java.util.ArrayList;

import Exceptions.NegativeToken;

public class Place {
	private int jetons;
	private ArrayList<ArcSortant> arcsSortants;
	private ArrayList<ArcEntrant> arcsEntrants;
	
	
	public Place(int jetons) throws NegativeToken{
		if(jetons>=0) {
			this.jetons = jetons;
			this.arcsEntrants = new ArrayList<ArcEntrant>();
			this.arcsSortants = new ArrayList<ArcSortant>();
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
	@Override
	public String toString() {
		int Snormal =0;
		int Svideur =0;
		int Szero=0;
		for (ArcSortant arcSortant : this.getArcsSortants()) {
			if( arcSortant instanceof ArcSortantNormal ) {
				Snormal++;
			}
			if( arcSortant instanceof ArcVideur ) {
				Svideur++;
			}
			if( arcSortant instanceof ArcZero ) {
				Szero++;
			}
			
		}
		
		return	"place avec "+ this.getJetons() +" :: arcs=> " 
		+ Snormal+ " arc(s) sortant(s) normal / " 
		+ Svideur +" arc(s) sortant(s) videur " 
		+ Szero + " arc(s) sortant(s) zero ///" 
		+ this.getArcsEntrants().size() +" arc(s) entrant(s)  ";
	}
	

}
