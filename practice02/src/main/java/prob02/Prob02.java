package prob02;

import java.util.Scanner;
import java.util.Arrays;


public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[ 5 ];
		double sum = 0;
		System.out.println("5개의 숫자를 입력하세요. ");

		/* 키보드에서 배열 크기만큼 입력 받아 배열에 저장하는 코드 */
		for(int i =0; i<5; i++) {
			int n = scanner.nextInt();
			intArray[i] = n;
			
		}
		/* 배열에 저장된 정수 값 더하기 */
        sum = Arrays.stream(intArray).sum()/5;
		
		/* 출력 */
		System.out.println("평균은 "+sum+"입니다.");

		
		/* 자원정리 */
		scanner.close();
	}
}
