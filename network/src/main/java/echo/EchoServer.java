package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	public static final int PORT = 8881;
	
	public static void main(String[] args) {
		ServerSocket serverSocket =null;
        Socket socket = null;

		
		try {
			// 1. Server Socket 생성
				serverSocket = new ServerSocket();
				
			// 2. 바인딩(Binding)
				// Socket에 InetSocketAddress(IPAddress + port)를 바인딩 한다.
				// IPAdrress : 0.0.0.0  -> 특정 호스트ip에 바인딩 하지 않는다.
				// 127.0.0.1 --> NC(네트워크카드에) ip가 없을 때 루프백
			serverSocket.bind(new InetSocketAddress("0.0.0.0",PORT ),10);
			log("starts... [port:"+ PORT +"]");
			// 3. accept 
			socket = serverSocket.accept(); // blocking
			
			log("연결되었습니다.");
			// -> blocking 풀어주려면 client에서 connect
			
			
			InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
			int remotePort = remoteInetSocketAddress.getPort();
			log("connected by client[" + remoteHostAddress + ":"+ remotePort + "]" );
		
			//4. IOStream 받아오기
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true); // 오토 flush -> 통신할때는 true/ 파일은 false...
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
//			pw.print("안녕 ");
			while(true) {
				String data = br.readLine();
				if(data == null) {
					//클라가 정상적으로 종료 (close 호출)
					log("closed by c" );
					break;
				}
				
				log(" receivced : "+ data);
				
				//6. 데이터 쓰기
				pw.println(data);
			}
	    } catch (SocketException e) {
            log("[suddenly closed by client : " + e);
        } catch (IOException e) {
        	log(" error : " + e);
        } finally {
        	 try {
                 if (socket != null && !socket.isClosed()) {
                     socket.close();
                 }
             } catch (IOException e) {
                 e.printStackTrace();
             }

             try {
                 if (serverSocket != null && !serverSocket.isClosed()) {
                     serverSocket.close();
                 }
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
		
	}
	
	private static void log(String message) {
		System.out.println("[EchoServer] : "+message );
	}

}
