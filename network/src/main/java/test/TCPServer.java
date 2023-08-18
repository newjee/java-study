package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

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
			serverSocket.bind(new InetSocketAddress("0.0.0.0",8000 ),10);
				
			// 3. accept 
			socket = serverSocket.accept(); // blocking
			
			System.out.println("연결되었습니다.");
			// -> blocking 풀어주려면 client에서 connect
			
			
			// 상대편 : remote( 원격통신)
			// 4. 
			InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
			int remotePort = remoteInetSocketAddress.getPort();
			System.out.println("[server] connected by client[" + remoteHostAddress + ":"+ remotePort + "]" );
		
			//4. IOStream 받아오기
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			
			while(true) {
				//5. 데이터 읽기
				byte[] buffer = new byte[256];
				
				int readByteCount = is.read(buffer);// blocking
				
				if(readByteCount == -1) {
					//클라가 정상적으로 종료 (close 호출)
					System.out.println("[server] closed by c" );
					break;
				}
				
				String data = new String(buffer, 0, readByteCount, "utf-8");
				System.out.println("[server] receivced : "+ data);
				
				//6. 데이터 쓰기
				os.write(data.getBytes("utf-8"));
			}
	    } catch (SocketException e) {
            System.out.println("[server] suddenly closed by client : " + e);
        } catch (IOException e) {
            System.out.println("[server] error : " + e);
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
 }








