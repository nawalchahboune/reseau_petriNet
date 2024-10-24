package metier;

import java.lang.reflect.Array;
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
		if(arc instanceof ArcSortant) {
			arc.getTransition().add_to_arc_entrant((ArcSortant)arc);
			arc.getPlace().add_to_arc_sortant((ArcSortant)arc);
		}
		if(arc instanceof ArcEntrant) {
			arc.getTransition().add_to_arc_sortant((ArcEntrant)arc);
			arc.getPlace().add_to_arc_entrant((ArcEntrant)arc);
		}
	}

	@Override
	public void supprimer_Arc(Arc arc) {
		if(this.arcs.contains(arc)) {
			if(arc instanceof ArcSortant) {
				arc.getTransition().remove_from_arc_entrant((ArcSortant)arc);
			}
			if(arc instanceof ArcEntrant) {
				arc.getTransition().remove_from_arc_Sortant((ArcEntrant)arc);
			}
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
		//type ArcSortant réfère à un arc sortant de la place associé; 
		//donc un arc entrant de la transition et vis vers ca
		
		ArrayList<ArcSortant> arcsEntrant= transition.getArcsEntrants();//entrant de la place
		transition.setTirable(true);
		for (ArcSortant arcEntrant : arcsEntrant) {
			//en  vérifie si l'arc est fireable; si il ne l'est pas transition est non plus tirable
			if(!arcEntrant.arcIsFireable()) {
				transition.setTirable(false);
				break;
			}
		}
		//si la transition est tirable; on appelle les methodes de mise à jour des jetons
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
		ArrayList<Transition> transitionTirables= new ArrayList();
		for (Transition transition : this.transitions) {
			transition.setTirable();
			if(transition.isTirable()) {
				transitionTirables.add(transition);
			}
		}
		while (transitionTirables.size()>0) {
			
			
		}
		
	}

}
