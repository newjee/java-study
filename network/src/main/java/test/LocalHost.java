
package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost(); // 프로그램이 돌고있는 장비 
			
			String hostname = inetAddress.getHostName();
			String hostIpAddress = inetAddress.getHostAddress();
			
			System.out.println(hostname);
			System.out.println(hostIpAddress);
			
			byte[] IpAddresses = inetAddress.getAddress();
			for(byte IpAddress : IpAddresses) {
//				System.out.println(IpAddress&0x000000ff); // unsigned 처리(java엔 없음)
				System.out.println(IpAddress);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
