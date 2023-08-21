package chat;
//base 64  space를 de-coding

import javax.sound.sampled.Port;
import java.io.*;
import java.net.ConnectException;
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

		try {
			//1. 키보드 연결
			scan = new Scanner(System.in);
			//2. 소켓
			socket = new Socket();
			//3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			log("connected");

			//4. reader/writer 생성
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true); // 오토 flush -> 통신할때는 true/ 파일은 false...


			//5. 프로토콜
			System.out.print("닉네임>> ");
			String nickname = scan.nextLine();
			pw.println("JOIN: " + nickname);
//			pw.flush();

			String ack = br.readLine();
			if ("JOIN:OK".equals(ack)) {
				System.out.println(nickname + "님이 입장하였습니다. 즐거운 채팅 되세요");
			}

			//6. 만든 소켓을 쓰레드에 보내줌
			new ChatClientThread(socket).start();

			//7. 키보드 입력 처리
			while (true) {
				System.out.print(">>");
				String input = scan.nextLine();

				if ("quit".equals(input) == true) {
					pw.println("QUIT");
					break;
				} else {
					//msg 처리
					pw.println("MSG:" + input);
//					pw.flush();
				}
			}
		} catch (ConnectException e) {
			log(SERVER_IP + ChatServer.PORT + "연결할수없음");
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
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
				if (scan != null) {
					scan.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		//5. ack 받기!!!! -> 닉네임 등록 잘됨
//
	}
	protected static void log(String message) {
		System.out.println("[Client LOG] : "+message );
	}

}
