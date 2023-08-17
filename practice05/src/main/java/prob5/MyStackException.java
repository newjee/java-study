package prob5;

public class MyStackException extends Exception {
	
	public MyStackException(String string) {
		
		super("stack is empty");
		
	}

	public MyStackException() {
		// TODO Auto-generated constructor stub
	}
}
