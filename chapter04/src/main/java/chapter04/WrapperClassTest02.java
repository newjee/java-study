package chapter04;

public class WrapperClassTest02 {

	public static void main(String[] args) {
		String s = "123456";
		int i = Integer.parseInt(s);
		
		//cf1 cross
		String s1 = String.valueOf(i);

		//cf2 cross
		String s2 = "" +i;
		
		System.out.println(s+ ":" + s1 + ":" + s2);
		
		int a = Character.getNumericValue('A');
		System.out.println(a);
		
		//cf ASCII
		System.out.println((int)'A');
		
		//2진수
		String s4 = Integer.toBinaryString(15);
		System.out.println(s4);
		//16
		String s5 = Integer.toHexString(15);
		System.out.println(s5);
	}

}
