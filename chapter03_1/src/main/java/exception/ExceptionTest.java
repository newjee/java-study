package exception;
//1->2->예외 발생->4
public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 -a; //예외
//		int b = 11 -a; //정상

		System.out.println("Some Code1");

		try {
			System.out.println("Some Code2");
	
			int result = (1+2+3)/b;

			System.out.println("Some Code3");
			
		} catch(ArithmeticException ex) {
//			System.out.println("예외 발생 : "+ ex);
//			ex.printStackTrace();
			
			/* 예외 처리 */
			//1. 로깅
			System.out.println("error:" + ex);
			//2. 사과
			System.out.println("죄송합니다. 시스템 오류입니다. ");
			//3. 정상종료
//			System.exit(0);
			return;
			
			
		} finally {
			//자원정리
			System.out.println("file close, socket close...");
		}
		
		
		// 가급적 지양.... 마지막에 코드 두는 건 xxxxxxxx
		System.out.println("Some Code4");
	}

}
