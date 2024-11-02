package Exceptions;

public class ExistingPlace extends Exception {
	public ExistingPlace() {
		super("place deja existe!");
	}

}
