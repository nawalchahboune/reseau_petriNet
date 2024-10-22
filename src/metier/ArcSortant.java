package metier;

public abstract class ArcSortant extends Arc {

	public ArcSortant(Place place, Transition transition) {
		super(place, transition);
	}
	
	public abstract void update_jeton_place();
	
	public abstract boolean arcIsFireable();
    
}
