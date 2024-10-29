package Metier;

public class Main {

	public static void main(String[] args) {
		Reseau_Petri network = new Reseau_Petri();
		Transition t0 = new Transition();
		Place p0 = new Place(10);
		Place p1 = new Place(2);
		Arc arc0 = new ArcEntrant(p0, t0);
		Arc arc1 = new ArcSortantNormal(p1,t0);
		network.ajouter_Arc(arc0);
		network.ajouter_Arc(arc1);
		((ArcEntrant) arc0).setPoids(10);
		((ArcSortantNormal) arc1).setPoids(1);
		network.fire(t0);
		
		System.out.println("La place p1 contient "+ p1.getJetons()+" jetons");
		System.out.println("La place p0 contient "+ p0.getJetons()+" jetons");
	}

}
