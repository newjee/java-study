package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPEchoClient {
    private static final String SERVER_IP = "127.0.0.1";

    public static void main(String[] args) {
        DatagramSocket socket = null;
        Scanner scan = null;

        try {
            //1. 스캐너 생성
            scan = new Scanner(System.in);

            //2. 소켓 생성
            socket = new DatagramSocket();

            while (true) {
                // 출력
                System.out.print(">");
                String line = scan.nextLine();

                if ("exit".equals(line)) {
                    break;
                }

                //3. 데이터 보내기 송신
                byte[] sndData = line.getBytes("utf-8"); // byte로
                DatagramPacket sendPacket =
                        new DatagramPacket(sndData, sndData.length,
                                            new InetSocketAddress(SERVER_IP, UDPEchoServer.PORT)
                        );
                socket.send(sendPacket);

                //==========================
                //4. 데이터 받기 수신
                DatagramPacket receivePacket = new DatagramPacket(new byte[UDPEchoServer.BUFFERSIZE], UDPEchoServer.BUFFERSIZE);

                log("packet 수신대기");
                socket.receive(receivePacket); // blocking

                // 버퍼 offset
                byte[] rcvData = receivePacket.getData();
                int offset = receivePacket.getLength();

                // 인코딩
                String msg = new String(rcvData, 0, offset, "utf-8");

                log("received : " + msg);


            }
        } catch (SocketException e) {
            log("error" + e);
        } catch (IOException e) {
            log("error" + e);

        } finally {
            if (scan != null) {
                scan.close();
            }
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }

    protected static void log(String message) {
        System.out.println("[Client LOG] : " + message);
    }

}
