package chat;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static chat.ChatServer.log;

// 포트 9999 // 
//readline blocking 메세지 기다릠 
public class ChatServerThread extends Thread {
    private String nickname;
    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;
    List<Writer> listWriters;

    // 생성자
    public ChatServerThread(Socket socket, List<Writer> listWriters) throws Exception {
        this.socket = socket;
        this.listWriters = listWriters;

        //스트림
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // run 오버라이딩
    @Override
    public void run() {


        //3. 요청 처리
        try {
            String request = null;

            while ((request = br.readLine()) != null) {
                String[] tokens = request.split(":");
                if ("JOIN".equals(tokens[0])) {
                    doJoin(tokens[1], pw);
                } else if ("MSG".equals(tokens[0])) {
                    doMsg(tokens[1]);
                } else if ("QUIT".equals(tokens[0])) {
                    ChatServer.log("클라이언트로부터 연결이 끊김");
                    doQuit(pw);
                    break;
                } else {
                    log("에러:알 수 없는 요청(" + tokens[0] + ")");
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
                pw.close();
				socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    // 프로토콜 구현
    // JOIN
    private void doJoin(String nickname, Writer writer) throws Exception {
        this.nickname = nickname;

        String data = nickname + "님이 참여했습니다.^^";
        broadcast(data);
        log(nickname + " 접속");

        // writer pool에 저장
        addWriter(writer);


        //ack
        pw.println("JOIN:OK");
        pw.flush();


    }

    //MSG
    private void doMsg(String message) {
        String data = nickname + ": " + message;
        broadcast(data);
        log(nickname + " 메세지 전송");

        //ack
        pw.println("MSG:OK");
        pw.flush();

    }


    private void doQuit(Writer writer) {
        removeWriter(writer);

        String data = nickname + "님이 퇴장했습니다 ㅠㅠ";
        broadcast(data);
    }

    private void removeWriter(Writer writer) {
        //참여자 삭제
        synchronized (listWriters) {

            listWriters.remove(writer);
        }
    }

    private void broadcast(String data) {
        synchronized (listWriters) {
            for (Writer writer : listWriters) {
//				if ()
                PrintWriter printWriter = (PrintWriter) writer;
                printWriter.println(data);
                printWriter.flush();
            }

        }
    }

    private void addWriter(Writer writer) {
        synchronized (listWriters) {
            listWriters.add(writer);
        }
    }
//	private static void log(String message) {
//		System.out.println("[LOG] : "+message );
//	}

}
