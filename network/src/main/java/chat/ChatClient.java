package chat;
//base 64  space를 de-coding

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {

		Scanner scan = null;
		Socket socket  =null;
		BufferedReader br =null;
		PrintWriter pw = null;

		try{
			//2. 소켓
			socket = new Socket();
			//3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			ChatServer.log("connected");

			//4. reader/writer 생성
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true); // 오토 flush -> 통신할때는 true/ 파일은 false...

			scan = new Scanner(System.in);

			//5. 프로토콜
			System.out.println("닉네임>> ");
			String nickname = scan.nextLine();
			pw.println("JOIN: " + nickname);
			pw.flush();

			//6. chatclientThread
			ChatClientThread chatClientThread = new ChatClientThread(br);
			chatClientThread.start();

			//7. 키보드 입력 처리
			while (true) {
				System.out.println(">>");
				String input = scan.nextLine();

				if ("QUIT".equals(input) == true) {
					break;
				} else {
					//msg 처리
					pw.println("MSG:" + input);
					pw.flush();
				}
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			//자원정리
			try {
				if (br != null) {
					br.close();
				}
				if (pw != null) {
					pw.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		//5. ack 받기!!!! -> 닉네임 등록 잘됨
//
	}
}
