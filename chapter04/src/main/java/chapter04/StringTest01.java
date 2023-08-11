package chapter04;

public class StringTest01 {

	public static void main(String[] args) {
		// c:\temp
		
		// 제어하는 문자... \t 익스케이프 아닌 걸 표현 -> 한번 더\
		System.out.println("c:\\temp");
		
		// 
		String s = "";
//		\r : carriage return -> println("hello \r\n")
//								println("") => print("")+print("\r\n")
//		\b : bell
		
		
		System.out.println(" \"Hello\" ");
		
		char c = '\'';
		System.out.println(c);
		
//		file
//		String path = "D:\\poscodx"xxxxxxx
		String path = "/Users/nabi/Study/poscodx2023/"
				+ "00tools/eclipse-workspace/java-study";
		
	}

}
