package chapter03_1;

public class GoodsApp {
	public static void main(String[] args) {
//		local변수 선언        생성자
		Goods camera = new Goods();
//		정보 은닉 O
		camera.setName("Sony");
		camera.setPrice(100000);
		camera.setCountStock(10);
		camera.setCountSold(20);
		
//		데이터 보호 예시
//		camera.setPrice(-1);
		
//		countOfGoods 생성자 count Test
		Goods goods1 = new Goods();
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		System.out.println(Goods.countOfGoods);
		
		camera.showInfo();
		

		int discountPrice  = camera.calDiscountPrice(0.5);
		System.out.println(discountPrice);
		
		
		
//		System.out.println("상품이름 : " + camera.getName() + 
//				", 가격 : " + camera.getPrice() +
//				", 재고 개수 : " + camera.getCountStock() +
//				", 팔린 개수 : " + camera.getCountSold());
//		
		
//		정보은닉 x
//		camera.name = "Sony";
//		camera.price = 8000000;
//		camera.countStock = 10;
//		camera.countSold = 20;
//		
//		System.out.println("상품이름 : " + camera.name + 
//							", 가격 : " + camera.price +
//							", 재고 개수 : " + camera.countStock +
//							", 팔린 개수 : " + camera.countSold);
//		
//		block 실행 범위
//		if (10 - 1 == 9) {
//			int i = 10;
//		}
//		System.out.print(i);
		
//		for 메모리 효율적으로 사용
//		for (int i = 0; i < 100000000000L; i++) {
//			new Goods();
//		}
	
	
	}
}
