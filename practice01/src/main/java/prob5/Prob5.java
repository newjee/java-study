package prob5;

public class Prob5 {

	public static void main(String[] args) {
		 for (int i = 1; i <= 99; i++) {
	            int num = i;
	            boolean hasClap = false;

	            while (num > 0) {
	                int digit = num % 10;
	                if (digit == 3 || digit == 6 || digit == 9) {
	                    hasClap = true;
	                    break;
	                }
	                num /= 10;
	            }

	            if (hasClap) {
	                System.out.println(i + " 짝 ");
	            }
		 }

	}
}
