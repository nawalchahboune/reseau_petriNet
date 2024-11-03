package Exceptions;

public class ExistingTransition extends Exception {
	public ExistingTransition() {

		super("transition deja existe!");
	}
}
