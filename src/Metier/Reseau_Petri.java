package Metier;
import java.util.ArrayList;
import java.util.Iterator;

import Exceptions.ExistingArc;
import Exceptions.NegativeToken;
import Exceptions.NullPlaceException;
import Exceptions.NullTArcException;
import Exceptions.NullTransitionException;
import Exceptions.UnknownPlaceException;
import Exceptions.UnknownTransitionException;

public class Reseau_Petri implements IReseauPetri {
	private ArrayList<Arc> arcs;
	private ArrayList<Place> places;
	private ArrayList<Transition> transitions;
	
	public Reseau_Petri() {
		this.arcs = new ArrayList<Arc>();
		this.places = new ArrayList<Place>();
		this.transitions = new ArrayList<Transition>();
	}
	
	
public ArrayList<Arc> getArcs(){
		return this.arcs;
	}
	
	public ArrayList<Place> getPlaces(){
		return this.places;
	}
	
	public ArrayList<Transition> getTransitions(){
		return this.transitions;
	}
	
	

	@Override
	public void ajouter_Arc(Arc arc) throws NullTArcException, ExistingArc, UnknownPlaceException, UnknownTransitionException{
		if(!this.places.contains(arc.getPlace())) {
			throw new UnknownPlaceException();
		}
		else if (!this.transitions.contains(arc.getTransition())) {
			throw new UnknownTransitionException();
		}
		else if(this.arcs.contains(arc)) {
			throw new ExistingArc();
		}
		else if(arc!=null) {
			this.arcs.add(arc);
			if(arc instanceof ArcSortant) {
				arc.getTransition().add_to_arc_entrant((ArcSortant)arc);
				arc.getPlace().add_to_arc_sortant((ArcSortant)arc);
			}
			if(arc instanceof ArcEntrant) {
				arc.getTransition().add_to_arc_sortant((ArcEntrant)arc);
				arc.getPlace().add_to_arc_entrant((ArcEntrant)arc);
			}
		}else {
			throw new NullTArcException();
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
	public void ajouter_Place(Place place) throws NullPlaceException {
		if(place!=null) {
			this.places.add(place);
		}
		else {
			throw new NullPlaceException();
		}
		
		
	}

	@Override
	public void supprimer_Place(Place place) {
		if(this.places.contains(place)) {
			this.places.remove(this.places.indexOf(place));
		}
		
	}

	@Override
	public void ajouter_Tarnsition(Transition transition) throws NullTransitionException {
		if(transition!=null) {
			this.transitions.add(transition);
		}
		else {
			throw new NullTransitionException();
		}
		
		
	}

	@Override
	public void supprimer_Tarnsition(Transition transition) {
		if(this.transitions.contains(transition)) {
			this.transitions.remove(this.transitions.indexOf(transition));
		}
		
	}

	@Override
    public void fire(Transition transition) throws NullTransitionException , NegativeToken {
		//type ArcSortant réfère à un arc sortant de la place associé; 
		//donc un arc entrant de la transition et vis vers ca
		if(transition!=null) {

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
					if(true) {
						arcSort.update_jetons_place();
					}
					else {
						throw new NegativeToken();
					}
				}
				for (ArcSortant arcEnt : arcsEntrant) {
					if(true) {
						arcEnt.update_jeton_place();
					}
					else {
						throw new NegativeToken();
					}
				}
			}
		}else {
			throw new NullTransitionException();
		}
		
	}

	@Override
	public void fireAll(){
		//ArrayList<Transition> transitionTirables= new ArrayList();
		for (Transition transition : this.transitions) {
			try {
				fire(transition);
			} catch (NullTransitionException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			} catch (NegativeToken e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			//transition.setTirable();
			//if(transition.isTirable()) {
				//transitionTirables.add(transition);
			//}
		//}
		//while (transitionTirables.size()>0) {
			
			
		}
		
	}
	@Override
	public String toString() {
		System.out.println("xh?");
		String s="****************************"+"\n";
		for (Transition transition : transitions) {
			System.out.println(transitions.size());
			System.out.println("hh ? "+ transition.toString() );
			s+=transition.toString() +"\n";
			ArrayList<ArcSortant> arcE= transition.getArcsEntrants();
			ArrayList<ArcEntrant> arcS= transition.getArcsSortants();
			ArrayList<Place> places = new ArrayList<Place>() ;
			for (ArcSortant a : arcE) {
				places.add(a.getPlace());
				
			}
			for (ArcEntrant a : arcS) {
				places.add(a.getPlace());
				
			}
			for (Place place : places) {
				s+=place.toString()+"\n";
				
			}
			for (ArcSortant a : arcE) {
				s+=a.toString() +"\n";
				
			}
			for (ArcEntrant a : arcS) {
				s+=a.toString() + "\n";
			}
			
			
		}
		return s;
	}

}
