package metier;

public interface IReseauPetri {
	public void ajouter_Arc(Arc arc);
	public void supprimer_Arc(Arc arc);
	public void ajouter_Place(Place place);
	public void supprimer_Place(Place place);
	public void ajouter_Tarnsition(Transition transition);
	public void supprimer_Tarnsition(Transition transition);
	public void fire(Transition transition);
	public void fireAll();

}
