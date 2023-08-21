package chat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

// 귓속말 : pw1이 둘리인지.... Lsit.<cheat>... 방장이냐....
//JOIN MSG QUIT
//base 64  space를 de-coding

//br -> readline
//pw -> 
public class ChatServer {
	public static final int PORT = 9999;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			//1. 서버 소켓 객체 생성
			serverSocket = new ServerSocket(PORT);
			
			//2. 바인딩
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
			log("연결 기다림" + hostAddress + ":" + PORT);
			Socket socket = serverSocket.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//2.  바인딩
	}
	
	

	
	private static void log(String message) {
		System.out.println("[LOG] : "+message );
	}
}


