package chapter04;

public class SingletonTest {

	public static void main(String[] args) {
//		new Singleton();
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		
		System.out.println(singleton1 == singleton2);
	}

}
