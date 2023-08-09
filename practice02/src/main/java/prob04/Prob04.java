package prob04;
public class Prob04 {
	/* 스왑 -> */
	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            // 문자 순서 뒤집기
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        return charArray;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		for (char ch : array) {
			System.out.print(ch);
	        }
	    System.out.println();
	}
}