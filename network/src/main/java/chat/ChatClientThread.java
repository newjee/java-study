package chat;
//nextline blocking
//쓰는 쓰레두 

import echo.EchoClient;

import java.io.BufferedReader;
import java.io.InputStream;

public class ChatClientThread extends Thread{
    BufferedReader br;

    public ChatClientThread(BufferedReader br) {
        this.br = br;
    }
	@Override
	public void run() {
        try {
            String line = null;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
