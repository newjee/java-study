package chapter03_1;
import mypackage.Goods2;

public class Goods2App {
	public static void main(String[] args) {
//		local 변수 camera 선언
		Goods2 goods = new Goods2();
		
//		public
		goods.name = "camera";
////		protected : 같은 패키지 내
//		goods.price = 8000000;
////		default : 같은 패키지 내
//		goods.countStock = 10;
		
//		private : 같은 클래스에서만 
//		goods.countSold = 20;
	}
}
