package Exceptions;

public class ExceedExistingToken extends Exception {
	public ExceedExistingToken() {
		super("you try to remove more than what is inside : place");
	}

}
