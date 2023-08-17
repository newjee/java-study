package prob04;



public class Person {
	private static int numberOfPerson; // 전체 인구수
	private int age =12;
	private String name;
	
//	public Person() {
//		age = 12;
//		name = "";
//	}
	
	public Person(String name) {
		this.name = name;		
		numberOfPerson++;
	}
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
		numberOfPerson++;
	}
	
	
	public void selfIntroduce() {
		System.out.println("내 이름은 " + name+ "이며, 나이는 " + age+"입니다." );
	}
	public static int getPopulation() {
		return numberOfPerson;
	}
	
	/* 코드 작성 */
}
