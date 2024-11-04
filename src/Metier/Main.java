package Metier;

import java.util.ArrayList;

import Exceptions.ExistingArc;
import Exceptions.NegativeToken;
import Exceptions.NegativeWeight;
import Exceptions.NullPlaceException;
import Exceptions.NullTransitionException;

public class Main {

	public static void maiin(String[] args) {
		try {
			Transition tt= new Transition() ;
			System.out.println(tt.toString());
		Reseau_Petri network = new Reseau_Petri();
		Transition t0 = new Transition();
		Place p0 = new Place(10);
		Place p1 = new Place(2);
		network.ajouter_Place(p0);
		network.ajouter_Place(p1);
		//Place p2 = new Place(0);
		//Place p3 = new Place(1);
		
		//ArcZero arc2= new ArcZero(p2,t0);
		//ArcVideur arc3= new ArcVideur(p3,t0);
		//ArcVideur arc4= new ArcVideur(p3,t0);
		
		// si j'essaie d'ajouter un 
		//Arc a= new ArcSortantNormal(0, p3, t0);
		
//		il faut l'activer maintenat : 
			
		//ArrayList<Arc> arcs= new ArrayList<Arc>();
		//arcs.add(arc1);
		//arcs.add(arc0);
		//ArrayList<Place> places = new ArrayList<Place>();
		
		//places.add(p0);
		//ArrayList<Transition> transitions = new ArrayList<Transition>();
		//transitions.add(t0);
		
		//Reseau_Petri network = new Reseau_Petri(arcs,places,transitions);

		//network.ajouter_Arc(arc2);
		//network.ajouter_Tarnsition(t0);
		//network.ajouter_Arc(arc0);
		//network.ajouter_Arc(arc1);
		//network.ajouter_Arc(arc3);

//		((ArcEntrant) arc0).setPoids(10);
//		((ArcSortantNormal) arc1).setPoids(1);
		//System.out.println("La place p1 contient "+ p1.getJetons()+" jetons");
		//System.out.println("La place p0 contient "+ p0.getJetons()+" jetons");

		//System.out.println("La place p2 contient "+ p2.getJetons()+" jetons");
		//System.out.println("La place p3 contient "+ p3.getJetons()+" jetons");
		//network.fire(t0);
		//System.out.println("after fire: ");
		
		//System.out.println("La place p1 contient "+ p1.getJetons()+" jetons");
		//System.out.println("La place p0 contient "+ p0.getJetons()+" jetons");
		//System.out.println("La place p2 contient "+ p2.getJetons()+" jetons");
		//System.out.println("La place p3 contient "+ p3.getJetons()+" jetons");
			//Reseau_Petri network = new Reseau_Petri();
		//	Place p1 = new Place(0);
			Place p2 = new Place(1);
			Transition t1= new Transition();
			ArcSortant arcp1t1= new ArcSortantNormal(1, p1, t1);
			ArcEntrant arct1p2 = new ArcEntrant(1, p2, t1);
			Transition t2= new Transition();
			ArcSortant arcp2t2 = new ArcSortantNormal(1, p2, t2);
			
			
			
			network.ajouter_Place(p1);
			network.ajouter_Place(p2);
			network.ajouter_Tarnsition(t1);
			network.ajouter_Arc(arcp1t1);
			//network.ajouter_Arc(arcp1t1);
			network.ajouter_Arc(arct1p2);
			//network.ajouter_Arc(arct1p2);
			network.ajouter_Tarnsition(t2);
			network.ajouter_Arc(arcp2t2);
			
			
			
			//System.out.println(network.getPlaces());
			//System.out.println(network.getTransitions());
			//System.out.println(network.getArcs());
			
			
			//Transition t0 = new Transition();
			//Transition t1 = new Transition();
			
			//Place p1 = new Place(2);
			
			//Arc arc0 = new ArcEntrant(2,p0, t0);
			//Arc arc1 = new ArcSortantNormal(1,p1,t0);
			System.out.println("ggg");
			Transition t = new Transition();
		    ArcSortantNormal arc = new ArcSortantNormal(1, new Place(0), t);
		    System.out.println(t.toString());
			
	}
			
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
		
	
public static void main(String[] args) {
	
	System.out.println("ggg");
	Transition t = new Transition();
    try {
		ArcSortantNormal arc = new ArcSortantNormal(1, new Place(0), t);
	} catch (NullPlaceException | NegativeWeight | NullTransitionException | ExistingArc | NegativeToken e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println(t.toString());
}
}
