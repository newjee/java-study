package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 귓속말 : pw1이 둘리인지.... Lsit.<cheat>... 방장이냐....
//JOIN MSG QUIT
//base 64  space를 de-coding
//닉ㄴ네임 바꾸기
public class ChatServer {
	public static final int PORT = 9999;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			//1. 서버 소켓 객체 생성
			serverSocket = new ServerSocket();

			//1-1. fin-wait -> time_wait: 소스 할당
			serverSocket.setReuseAddress(true);

			//2. 바인딩
			String hostAddress = InetAddress.getLocalHost().getHostAddress();

//			String hostAddress = "192.168.0.148";

			serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
			log("연결 기다림" +hostAddress+ ":"+PORT);
			//3. 공유 객체 리스트 생성
			List<PrintWriter> listWriters = Collections.synchronizedList(new ArrayList<>());

			while (true) {
				//4. 클라이언트 접속
				Socket socket = serverSocket.accept();
				log("접속" + socket);

				ChatServerThread chatServerThread = new ChatServerThread(socket, listWriters);
				chatServerThread.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	
	

	
	protected static void log(String message) {
		System.out.println("[Server LOG] : "+message );
	}
}


