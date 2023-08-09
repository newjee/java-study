package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );
		System.out.print("금액: ");
		int price  = scanner.nextInt();
		
		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		
		for (int i=0; i<MONEYS.length; i++) {
			int num = price/MONEYS[i];
			price = price-(MONEYS[i]*num);
			System.out.println(MONEYS[i]+"원:"+num+"개");
		}
		/* 코드 작성 */
		
		scanner.close();
 	}
}