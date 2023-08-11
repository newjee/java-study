package chapter04;
//불변성 내부를 절대 바꾸지 않음 (immutability)
public class StringTest02 {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "def";
		String s3 = s2;
		
		System.out.println(s1 +" " +  s2 +" " + s3);
		System.out.println(s1.hashCode() +" " 
						+ s2.hashCode() + " " +
						s3.hashCode());
		
		s2 = s1.toUpperCase();
		System.out.println(s1 +" " +  s2 +" " + s3);
		
		System.out.println(s1.hashCode() +" " 
				+ s2.hashCode() + " " +
				s3.hashCode());

//		s1 = s2;
		
		
		String s4 = s2.concat("??");
		System.out.println(s1 +" " +  s2 +" " + s3 + " " + s4);
		
//		그려볼것!!!!
		System.out.println(
				"!".concat(s2).concat("@")
				);
		
		System.out.println(equalsHello("Hello"));
		System.out.println(equalsHello(null));
		
	}
	private static boolean equalsHello(String s) {
		return "Hello".equals(s);
	}
}
