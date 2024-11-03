package Exceptions;

public class ErreurConnexion extends Exception {
	//lors d'essai de connecter arc avec deux places pu avec deux transitions
	public ErreurConnexion() {
		super("erreur de connexion ; un arc c'est entre place et transition");
	}

}
