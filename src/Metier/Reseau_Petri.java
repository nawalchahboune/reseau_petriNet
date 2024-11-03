package Metier;
import java.util.ArrayList;
import java.util.Iterator;

import Exceptions.ExceedExistingToken;
import Exceptions.ExistingArc;
import Exceptions.ExistingPlace;
import Exceptions.ExistingTransition;
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



	public void setArcs(ArrayList<Arc> arcs) {
		this.arcs = arcs;
	}



	public void setPlaces(ArrayList<Place> places) {
		this.places = places;
	}




	public void setTransitions(ArrayList<Transition> transitions) {
		this.transitions = transitions;
	}


	public Reseau_Petri(ArrayList<Arc> arcs, ArrayList<Place> places, ArrayList<Transition> transitions) {
		this.arcs = arcs;
		this.places = places;
		this.transitions = transitions;
		 for (Arc arc : arcs) {
		        Place place = arc.getPlace();
		        Transition transition = arc.getTransition();
		        
		        if(!places.contains(place)) {
		        	places.add(place);
		        }
		        if(!transitions.contains(transition)) {
		        	transitions.add(transition);
		        }
		        for (Transition t : transitions) {
		        	 ArrayList<ArcSortant> arcsEDeTransition = t.getArcsEntrants();
		        	 ArrayList<ArcEntrant> arcsSDeTransition = t.getArcsSortants();
		        	 for (ArcSortant arcE : arcsEDeTransition) {
		        		 if(!arcs.contains(arcE)) {
		        			 arcs.add(arcE);
		        		 }
		        		 Place p= arcE.getPlace();
		        		 if(!places.contains(p)) {
		        			 places.add(place);
		        		 }
					}
		        	 for (ArcEntrant arcS : arcsSDeTransition) {
		        		 if(!arcs.contains(arcS)) {
		        			 arcs.add(arcS);
		        		 }
		        		 Place p= arcS.getPlace();
		        		 if(!places.contains(p)) {
		        			 places.add(place);
		        		 }
					}
				}
		       
		        
		 }
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
		
		if(arc!=null) {
			if(!this.places.contains(arc.getPlace())) {
				throw new UnknownPlaceException();
			}
			else if (!this.transitions.contains(arc.getTransition())) {
				throw new UnknownTransitionException();
			}
			else if(this.arcs.contains(arc)) {
				throw new ExistingArc();
			}
			/*
			else if(arc!=null) {
				this.arcs.add(arc);
				if(arc instanceof ArcSortant) {
					Transition t = arc.getTransition();
					Place p = arc.getPlace();
					t.add_to_arc_entrant((ArcSortant)arc);
					p.add_to_arc_sortant((ArcSortant)arc);
					if(!transitions.contains(t)) {
						transitions.add(t);
					}
					if(!places.contains(p)) {
						places.add(p);
					}
				}
				if(arc instanceof ArcEntrant) {
					Transition t = arc.getTransition();
					Place p = arc.getPlace();
					if(!transitions.contains(t)) {
						transitions.add(t);
					}
					if(!places.contains(p)) {
						places.add(p);
					}
					arc.getTransition().add_to_arc_sortant((ArcEntrant)arc);
					arc.getPlace().add_to_arc_entrant((ArcEntrant)arc);
				}
			}else {
				throw new NullTArcException();
			}
			*/
			this.arcs.add(arc);
		}
		else { throw new NullTArcException();
		
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
	public void ajouter_Place(Place place) throws NullPlaceException , ExistingPlace {
		if(place!=null) {
			if(!places.contains(place)) {
				this.places.add(place);
			}else {
				throw new ExistingPlace();
			}
			//si j'ajoute une placce à mon réseau !!  qts => est ce 
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
	public void ajouter_Tarnsition(Transition transition) throws NullTransitionException , ExistingTransition {
		if(transition!=null) {
			if(!transitions.contains(transition)) {
				this.transitions.add(transition);
			}else {
				throw new ExistingTransition();
			}
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
    public void fire(Transition transition) throws NullTransitionException, NegativeToken  {
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
						arcSort.update_jetons_place();
					
				}
				for (ArcSortant arcEnt : arcsEntrant) {
						arcEnt.update_jeton_place();
					
				}
			}
		}else {
			throw new NullTransitionException();
		}
		
	}

	@Override
	public void fireAll(){
	
		while(transitions!= null) {
			for (Transition transition : this.transitions) {
			
			try {
				this.fire(transition);
			} catch (NullTransitionException e) {
				
				e.getMessage();
			} catch (NegativeToken e) {
				
				e.getMessage();
			}
		}
			
		}
		
		
	}

	//transition.setTirable();
	//if(transition.isTirable()) {
		//transitionTirables.add(transition);
	//}
//}
//while (transitionTirables.size()>0) {
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

	@Override
	public void ajouterJetons(Place place, int jetons) throws NegativeToken , NullPlaceException {
		//
		//on doit s'assurer que le reseau le contient bien  : place !!
		// ainsi que pour transi
		if(place!=null) {
			place.setJetons(jetons);

		}
		else {
			throw new NullPlaceException();
		}
	}
	@Override
	public void enleverJetons(Place place , int jetons )  throws ExceedExistingToken , NullPlaceException, NegativeToken{ 
		
		if(place!=null) {
			if(place.getJetons()-jetons<0) {
				throw new ExceedExistingToken();
			}
			else {
				place.setJetons(place.getJetons()-jetons);
			}
			
		}
		else {
			throw new NullPlaceException();
		}
	}

	@Override
	public void chnagerPoids(Arc arc, int poids ) throws NullTArcException  {
		
		if(arc!= null) {
			if(arc instanceof ArcEntrant  ) {
				((ArcEntrant) arc).setPoids(poids);
				
			}
			if( arc instanceof ArcSortantNormal ) {
			((ArcSortantNormal) arc).setPoids(poids);
			}
		}else {
			throw new NullTArcException();
		}
	}

}
