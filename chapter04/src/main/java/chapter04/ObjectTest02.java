package chapter04;

public class ObjectTest02 {

	public static void main(String[] args) {
		Point p1 = new Point(10,20);
		Point p2 = new Point(10,20);
		Point p3 = p2;
		
		// == : 두 객체의 동일
		System.out.println(p1 == p2); //F
		System.out.println(p2 == p3); //T
		
		// equals : 두 객체의 동질성(내용 비교)
		System.out.println(p1.equals(p2));//F?
								// 부모 클래스의 Object의 기본 구현은 동일성(==)비
		System.out.println(p2.equals(p3));//T
		
		
		
	}

}
