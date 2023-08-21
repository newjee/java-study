package chat;

import java.net.Socket;

// 포트 9999 // 
//readline blocking 메세지 기다릠 
public class ChatServerThread extends Thread{
	private String nickname;
	private Socket socket;
	
	public ChatServerThread(Socket socket) {
		this.socket = socket;
	}
	
}
