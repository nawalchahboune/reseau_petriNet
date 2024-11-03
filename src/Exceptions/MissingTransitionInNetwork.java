package Exceptions;

public class MissingTransitionInNetwork extends Exception{
	public MissingTransitionInNetwork() {
		super("le réseau ne contient pas la transirtion !!");
	}

}
