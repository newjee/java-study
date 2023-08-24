package chatgui;
//IRC 서버 운영!!!!!!!!!!!!!!!!

import chat.ChatClientThread;
import chat.ChatServer;

import java.io.*;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {
    private static final String SERVER_IP = "127.0.0.1";

    public static void main(String[] args) {
        String name = null;
        Scanner scanner = null;
        Socket socket = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        //1. create socket
        //2. connect server
        //3. join protocol  진행
        //4.

        try {
            scanner = new Scanner(System.in);
            socket = new Socket();
            socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));

            //4. r&w
            br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
            pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true); // 오토 flush -> 통신할때는 true/ 파일은 false...


                System.out.println("대화명을 입력하세요.");
                System.out.print(">>> ");
                name = scanner.nextLine();

                if (name.isEmpty() || name.length() < 2) {
                    System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
                }


                System.out.print("닉네임>> ");
                String nickname = scanner.nextLine();
                pw.println("JOIN: " + nickname);

                String ack = br.readLine();
                if ("JOIN:OK".equals(ack)) {
                    ChatWindow newChat = new ChatWindow(name, nickname,socket);
                    newChat.show();
                    newChat.updateTextArea("★★★★★★" + nickname + "님이 입장하였습니다." + "★★★★★★" + " 즐거운 채팅 되세요 ^^ ");
                }

//            new ChatClientThread(socket).start();

            while (true) {
                String input = scanner.nextLine();

                if ("quit".equals(input) == true) {
                    pw.println("QUIT");
                    break;
                } else {
                    //msg 처리
                    pw.println("MSG:" + input);

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
                if (scanner != null) {
                    scanner.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    protected static void log(String message) {
        System.out.println("[Client LOG] : " + message);
    }

}

