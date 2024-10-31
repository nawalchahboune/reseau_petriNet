package Metier;

public class Main {

	public static void main(String[] args) {
		try {Reseau_Petri network = new Reseau_Petri();
		Transition t0 = new Transition();
		Place p0 = new Place(10);
		Place p1 = new Place(2);
		Place p2 = new Place(0);
		Place p3 = new Place(1);
		
		Arc arc0 = new ArcEntrant(2,p0, t0);
		Arc arc1 = new ArcSortantNormal(1,p1,t0);
		ArcZero arc2= new ArcZero(p2,t0);
		ArcVideur arc3= new ArcVideur(p3,t0);
		ArcVideur arc4= new ArcVideur(p3,t0);
		
		// si j'essaie d'ajouter un 
		Arc a= new ArcSortantNormal(0, p3, t0);
		
//		il faut l'activer maintenat : 
		
		network.ajouter_Arc(arc2);
		network.ajouter_Arc(arc0);
		network.ajouter_Arc(arc1);
		network.ajouter_Arc(arc3);

//		((ArcEntrant) arc0).setPoids(10);
//		((ArcSortantNormal) arc1).setPoids(1);
		System.out.println("La place p1 contient "+ p1.getJetons()+" jetons");
		System.out.println("La place p0 contient "+ p0.getJetons()+" jetons");

		System.out.println("La place p2 contient "+ p2.getJetons()+" jetons");
		System.out.println("La place p3 contient "+ p3.getJetons()+" jetons");
		network.fire(t0);
		System.out.println("after fire: ");
		
		System.out.println("La place p1 contient "+ p1.getJetons()+" jetons");
		System.out.println("La place p0 contient "+ p0.getJetons()+" jetons");
		System.out.println("La place p2 contient "+ p2.getJetons()+" jetons");
		System.out.println("La place p3 contient "+ p3.getJetons()+" jetons");
	}
			
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
