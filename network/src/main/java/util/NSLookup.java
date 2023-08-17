package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.print(">> ");

			String line = scan.nextLine();

			if ("quit".equals(line))
				break;

			try {
				InetAddress[] inetAddresses = InetAddress.getAllByName(line);

				for (InetAddress ipAddress : inetAddresses) {

					System.out.println(ipAddress.getHostName() + " : " + ipAddress.getHostAddress());

				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}

		}
		scan.close();
	}

}
