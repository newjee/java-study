package prob03;

public class CurrencyConverter {
	 private static double rate;


	   public static double toDollar(double won) {
		   return won / rate;
	      // 한국 원화를 달러로 변환
	   }
	   public static double  toKRW(double dollar) {
		return dollar * (rate);
	      // 달러를 한국 원화로 변환
	   }
	   public static void setRate(double r) {
		   rate = r;
	       // 환율 설정(KRW/$1)
	   }

}
