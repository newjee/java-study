package prob3;

public abstract class Bird {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void fly();

	public abstract void sing();

	public abstract String toString();

}
//toString 구현?

//+추상메소드
