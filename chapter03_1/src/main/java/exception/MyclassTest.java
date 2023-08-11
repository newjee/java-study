package exception;

import java.io.IOException;

public class MyclassTest {
	public static void main(String[] args) {
		try {
			MyClass myclass = new MyClass();
			myclass.danger();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MyException e) {
//			e.printStackTrace();
//		}
		} catch (Exception e) {
			e.printStackTrace();
			e.printStackTrace();
		}
	}
}