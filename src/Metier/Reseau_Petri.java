package Metier;

import java.util.ArrayList;
import java.util.Iterator;

public class Reseau_Petri implements IReseauPetri{
	private ArrayList<Arc> arcs;
	private ArrayList<Place> places;
	private ArrayList<Transition> transitions;
	

	public Reseau_Petri(ArrayList<Arc> arcs, ArrayList<Place> places, ArrayList<Transition> transitions) {
		this.arcs = arcs;
		this.places = places;
		this.transitions = transitions;
	}
	

	@Override
	public void ajouter_Arc(Arc arc) {
		this.arcs.add(arc);
		
	}

	@Override
	public void supprimer_Arc(Arc arc) {
		if(this.arcs.contains(arc)) {
			this.arcs.remove(this.arcs.indexOf(arc));
		}
	}

	@Override
	public void ajouter_Place(Place place) {
		this.places.add(place);
		
	}

	@Override
	public void supprimer_Place(Place place) {
		if(this.places.contains(place)) {
			this.places.remove(this.places.indexOf(place));
		}
		
	}

	@Override
	public void ajouter_Tarnsition(Transition transition) {
		this.transitions.add(transition);
		
	}

	@Override
	public void supprimer_Tarnsition(Transition transition) {
		if(this.transitions.contains(transition)) {
			this.transitions.remove(this.transitions.indexOf(transition));
		}
		
	}

	@Override
	public void fire(Transition transition) {
		ArrayList<ArcSortant> arcsEntrant= transition.getArcsEntrants();//entrant de la place
		
		for (ArcSortant arcEntrant : arcsEntrant) {
			if(arcEntrant.arcIsFireable()) {
				transition.setTirable(true);
			}
			else {
				transition.setTirable(false);
				break;
			}
		}
		if(transition.isTirable()) {
			ArrayList<ArcEntrant> arcsSortant= transition.getArcsSortants();
			for(ArcEntrant arcSort : arcsSortant) {
				arcSort.update_jetons_place();
			}
			for (ArcSortant arcEnt : arcsEntrant) {
				arcEnt.update_jeton_place();
			}
		}
		
	}

	@Override
	public void fireAll() {
		// TODO Auto-generated method stub
		
	}

}
