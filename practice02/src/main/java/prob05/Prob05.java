package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		System.out.println("수를 결정하였습니다. 맞추어보세요 ");

		System.out.println("1-100");

		while( true ) {
			
			/* 게임 작성 */
			
			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;
			int i =1;
			int max = 100;
			int min = 1;
//			System.out.println(correctNumber);

			while( true ) {
				System.out.print(i+">>");
				i++;
				int num2 = scanner.nextInt();
				
				
				if (num2 == correctNumber) {
					break;
				}
				else { 
					if (num2 > correctNumber) {
						System.out.println("더 낮게 ");
						

						System.out.println(min+"-"+num2);
						max=num2;
						
					}
					if (num2 < correctNumber){
						System.out.println("더 높게");
						System.out.println(num2+"-"+max);
						min = num2;
					}
				}
			}
			
			System.out.println("맞았습니다.");

			
			//새 게임 여부 확인하기
			System.out.print( "다시 하겠습니까(y/n)>>" );
			String answer = scanner.next();
			if( "y".equals( answer ) == false ) {
				break;
			}
		}
		
		scanner.close();
	}

}