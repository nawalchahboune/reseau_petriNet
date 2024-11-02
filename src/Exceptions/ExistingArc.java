package Exceptions;

public class ExistingArc extends Exception {
	public ExistingArc() {
		super("arc already exists");
	}

}
