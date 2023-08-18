package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient {
	private static final String SERVER_IP = "127.0.0.1";
//192.168.0.148
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scan = null;
		
		try {
			
			//1. 소켓 생성
			socket = new Socket();
			
			//2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, EchoServer.PORT));
			log("connected");
			
			//3. io stream 받아오기
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true); // 오토 flush -> 통신할때는 true/ 파일은 false...
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			scan = new Scanner(System.in);
			
			while(true) {
	
			//4. 쓰기
			System.out.print(">");
			
			String line =scan.nextLine();

			if("exit".equals(line)) {
				break;
			}
			
			pw.println(line);
			
			//5. 읽기
			String data = br.readLine();
			
			if (data ==null) {
				//서버 정상 closed
				log("closed by server");
				break;
			}
			System.out.println("<" + data);
		}
			
		} catch (SocketException e) {
			System.out.println("[cli] suddenly closed by server: " +e);
		}catch (IOException e) {
			System.out.println("[cli] error: " +e);
		} finally {
			try {
				if(socket!=null && socket.isClosed()) {
					
					socket.close();
				}
				  if(scan !=null) {
	                     scan.close();
	                     
	                 }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}	

	private static void log(String message) {
		System.out.println("[EchoClient] : "+message );
	}

}
