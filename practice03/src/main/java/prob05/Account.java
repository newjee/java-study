package prob05;

public class Account {
	private String accountNo;
	private int money =0 ;
	
	public Account(String accountNo) {
		this.accountNo = accountNo;
		System.out.println(accountNo + " 계좌가 개설되었습니다.");
//		System.out.println(accountNo + " 계좌의 잔고는" +money+"만원 입니다.");
	}
	public void save(int money) {
		System.out.println(accountNo + " 계좌에 "+money+"만원이 입금되었습니다.");

		this.money = money;
	}
	
	public void deposit(int depositMoney) {
		System.out.println(accountNo + " 계좌에 "+depositMoney+"만원이 출금되었습니다.");

		this.money = money- depositMoney;
		
		
	}
	public String getAccountNo() {
		// TODO Auto-generated method stub
		return accountNo;
	}
	public int getBalance() {
		// TODO Auto-generated method stub
		return money;
	}
	

}
