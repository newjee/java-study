package chapter04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date d = new Date();
		
		System.out.println(d);
		//format
		
		printDate01(d);
		printDate02(d);
	}

	private static void printDate02(Date d) {
		// year (+1900)
		int year = d.getYear();
		
		// m (0~11 +1)
		int month = d.getMonth();
		
		int date = d.getDate();
		
		int hours = d.getHours();
		
		int minutes = d.getMinutes();
		
		int seconds = d.getSeconds();
		
		System.out.println(
				(year + 1900) + "/"+
				(month + 1) + "/" +
				date +" " +
				hours + ":" +
				minutes+ ":"+
				seconds );
		
	}

	private static void printDate01(Date d) {
		//2023-08-11 15:00:00
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String date = sdf.format(d);
		System.out.println(date);
}
}
