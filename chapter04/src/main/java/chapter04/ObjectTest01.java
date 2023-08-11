package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point point = new Point();
		
//		Class kclass = point.getClass(); //reflection
//		System.out.println(kclass);
		System.out.println(point.getClass());
		System.out.println(point.hashCode()); // address xx 
											 // address 기반의 해싱값 oo
		System.out.println(point.toString()); // .getName() + "@" + Integer.toHexString(hashCode())
		System.out.println(point);
		
	}

}
