package chat;
//nextline blocking
//쓰는 쓰레두 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread extends Thread{
    private  Socket socket;
    private  BufferedReader br;

    public ChatClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
	public void run() {
        try {
            String line;
            br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

            while (true) {
                line = br.readLine();
                if(line == null){
                    break;
                }
                System.out.println(line);
            }

        } catch (SocketException e) {
            ChatClient.log("채팅방에서 나왔습니다.!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                try {
                    socket.close();
                } catch (IOException e) {
                    ChatClient.log("error" +e);

                }
            }
        }
	}
}
