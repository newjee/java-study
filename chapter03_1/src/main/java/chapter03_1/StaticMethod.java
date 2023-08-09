package chapter03_1;

public class StaticMethod {
	int n;
	static int m;

	void f1() {
		n = 10;
	}
	
	void f2() {
//		같은 클래스의 클래스(static) 변수 접근에서는 클래스 이름 생략 가
		m=20;
		m=20
	}
	
	void f3() {
		f2();
	}
	
	void f4() {
		StaticMethod.s1();
//		같은 클래스의 클래스(static) 변수 접근에서는 클래스 이름 생략 가능
		s1();
		
	}
	static void s1() {
//		error : static method에서는 인스턴스 변수 접근 불가
//		n =10;
		System.out.println();
		
	}
	static void s2() {
//		error : static method에서는 인스턴스 메소 접근 불가

//		f1();
	}
	static void s3() {
//		같은 클래스의 클래스(static) 변수 접근에서는 클래스 이름 생략 가능
		StaticMethod.m = 10;
		m = 20;
		
	}
	static void s4() {
//		같은 클래스의 클래스(static) 변수 접근에서는 클래스 이름 생략 가능

		StaticMethod.s1();
		s1();
	}
}
