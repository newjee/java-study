package chapter03_1;

public class StudentTest02 {
// Casting
	public static void main(String[] args) {
		Student s1 = new Student();
		
		
		//upcasting - implicity
		Person p1 = s1;
		//downcasting - Explicity
		Student s2 = (Student)p1; 
		
	}

}
