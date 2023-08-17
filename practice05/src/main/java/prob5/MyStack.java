package prob5;

public class MyStack {
//array based on (linked...)
	private String[] buffer;
	private int top = 0;

	public MyStack(int i) {
		buffer = new String[i];

	}

// 
	public void push(String string) {
		if (top + 1 > buffer.length) {
			String[] newBuffer = new String[buffer.length * 2];
			for (int i = 0; i < buffer.length; i++) {
				newBuffer[i] = buffer[i];
			}
			buffer = newBuffer;
		}
		buffer[top] = string;
		top++;

	}

	public String pop() throws MyStackException {
		if (top == 0)
			throw new MyStackException();
		top--;
		return buffer[top];

	}

	public boolean isEmpty() {
		if (top == 0) {
			return true;
		}
		return false;
	}

}