package prob03;

import java.util.Objects;

//amount 해싱 
public class Money {

	private int amount;

	public Money(int i) {
		this.amount = i;
		
	}

	public int getAmount() {
		return amount;
	}

	public Money add(Money num) {
		return new Money(this.amount + num.getAmount());
	}
	public Money minus(Money num) {
		return new Money(this.amount - num.getAmount());
	}
	public Money multiply(Money num) {
		return new Money (this.amount * num.getAmount());
	}
	public Money devide(Money num) {
		return new Money(this.amount / num.getAmount());
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
//		if (this == obj) -> 주소 비교 : 동일
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Money other = (Money) obj;
//		return amount == other.amount;
		if ((obj instanceof Money))  {
			Money other = (Money) obj;
			return amount == other.amount;
			
		}
		return false;
		

	}


	}


