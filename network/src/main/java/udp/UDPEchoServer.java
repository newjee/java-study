package udp;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

public class UDPEchoServer {
    //udp tcp 같이 열 수 있음
    public static final int PORT = 9999;
    public static final int BUFFERSIZE = 256;

    public static void main(String[] args) {
        DatagramSocket socket = null;
        //1. UDP 소켓 생성
        try {
            //1. 소켓 생성
            socket = new DatagramSocket(PORT);

            while (true) {
                //2. 데이터 수신
                DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFERSIZE], BUFFERSIZE);

                log("packet 수신대기");
                socket.receive(receivePacket); // blocking

                // 버퍼 offset
                byte[] rcvData = receivePacket.getData();
                int offset = receivePacket.getLength();

                // 인코딩
                String msg = new String(rcvData, 0, offset, "utf-8");

                System.out.println("received : " + msg);

                //===============
                //3. 데이터 송신
                byte[] sndData = msg.getBytes("utf-8"); // byte로
                DatagramPacket sendPacket =
                        new DatagramPacket(sndData, sndData.length,
                                            receivePacket.getAddress(),
                                            receivePacket.getPort());
                socket.send(sendPacket);
            }
        } catch (SocketException e) {
            log("error" + e);
        } catch (IOException e) {
            log("error" + e);

        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }

    }

    protected static void log(String message) {
        System.out.println("[Server LOG] : " + message);
    }

}
