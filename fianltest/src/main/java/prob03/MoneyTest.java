package prob03;
// 건들지 말
public class MoneyTest {

	public static void main(String[] args) {
		Money five = new Money(5);
		Money two = new Money(2);
		Money three = new Money(3);
		Money ten = new Money(10);

		if (five.equals(two.add(three)) // add->money return
				&& three.equals(five.minus(two))
				&& ten.equals(five.multiply(two))
				&& two.equals(ten.devide(five))) { // true
			System.out.println("Money Class 구현을 완료 하였습니다.");
		}
	}
}
