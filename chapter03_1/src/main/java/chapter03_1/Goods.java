package chapter03_1;

public class Goods {
		public static int countOfGoods=0;
		
		private String name;
		private int price;
		private int countStock;
		private int countSold;
		
//		생성자
		public Goods() {
//			내부에서는 클래스 이름 생략 가
//			Goods.countOfGoods++;
			countOfGoods++;
		}
		
//		Getter Setter
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
//			정보 보호 
			if(price <0 ) {
				price = 0;
			}
			this.price = price;
		}
		public int getCountStock() {
			return countStock;
		}
		public void setCountStock(int countStock) {
			this.countStock = countStock;
		}
		public int getCountSold() {
			return countSold;
		}
		public void setCountSold(int countSold) {
			this.countSold = countSold;
		}

		public void showInfo() {
			// TODO Auto-generated method stub
			System.out.println("상품이름 : " + name + 
					", 가격 : " + price +
					", 재고 개수 : " + countStock +
					", 팔린 개수 : " + countSold);
			
		}

		public int calDiscountPrice(double discountRate) {
//			DownCasting
			return (int)(price * discountRate);			
			
		}
	
}
