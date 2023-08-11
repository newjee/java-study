package chapter04;

public class ObjectTest03 {

	public static void main(String[] args) {
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		
		System.out.println(s1==s2); // 동일성 -> F
		System.out.println(s1.equals(s2)); // 동질->T
		
		System.out.println("s1 hash : "+s1.hashCode());
		System.out.println("s2 hash : "+s2.hashCode());
		
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
	
		System.out.println("======== String s3 = Hello =========");
		String s3 = "Hello";
		String s4 = "Hello";

		System.out.println(s3==s4); // 동일성 -> F
		System.out.println(s3.equals(s4)); // 동질->T
		
		System.out.println("s3 hash : "+s3.hashCode());
		System.out.println("s4 hash : "+s4.hashCode());
		
		System.out.println(+System.identityHashCode(s3));
		System.out.println(System.identityHashCode(s4));
		
	}

}
