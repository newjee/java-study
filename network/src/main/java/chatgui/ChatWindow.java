package chatgui;

import chat.ChatClientThread;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class ChatWindow {

    private Frame frame;
    private Panel pannel;
    private Button buttonSend;
    private Button buttonExit;
    private TextField textField;
    private TextArea textArea;
    private String nickname;
    private PrintWriter pw;
    private Socket socket;


    //    public ChatWindow(String name) {
////        this.nickname = nickname;
//        frame = new Frame(name);
//        pannel = new Panel();
//        buttonSend = new Button("Send");
//        buttonSend = new
//        textField = new TextField();
//        textArea = new TextArea(30, 80);
//    }
    public ChatWindow(String name, String nickname, Socket socket) {
        this.nickname = nickname;
        this.socket = socket;

        frame = new Frame(name);
        pannel = new Panel();
        buttonSend = new Button("Send");
        buttonExit = new Button("Exit");
        textField = new TextField();
        textArea = new TextArea(30, 80);

        try {
            pw = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void show() {
        // Button
        buttonSend.setBackground(Color.GRAY);
        buttonSend.setForeground(Color.RED);
//		buttonSend.addActionListener( new ActionListener() {
//			@Override
//			public void actionPerformed( ActionEvent actionEvent ) {
//				sendMessage();
//			}
//		});
        // 화살표 함수 :
        buttonSend.addActionListener((ActionEvent actionEvent) -> {
            //추론
            sendMessage();
        });

        buttonExit.setBackground(Color.GRAY);
        buttonExit.setForeground(Color.RED);

        // 화살표 함수 :
        buttonExit.addActionListener((ActionEvent actionEvent) -> {
            // 추론
//			System.out.println(actionEvent);
            finish();
        });

        // Textfield
        textField.setColumns(80);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char keyCode = e.getKeyChar();
                if (keyCode == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });
        // Pannel
        pannel.setBackground(Color.LIGHT_GRAY);
        pannel.add(textField);
        pannel.add(buttonSend);
        pannel.add(buttonExit);
        frame.add(BorderLayout.SOUTH, pannel);

        // TextArea
        textArea.setEditable(false);
        frame.add(BorderLayout.CENTER, textArea);

        // Frame
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                finish();
            }
        });
        frame.setVisible(true);
        frame.pack();

        //IOStream 받아오기 br만 넘기기
        //CHatCliend thread 생성 하고 실행
        new ChatClientThread(socket).start();

    }

    private void finish() {
        //quit 프로토콜 구현

        //exit java (jvm)
        System.exit(0);
    }


    protected void sendMessage() {
        String message = textField.getText();
//        System.out.println("메세지를 보내는 프로토콜 구현 :" + message);
        pw.println("MSG:" + message);
        textField.setText("");
        textField.requestFocus();
//        updateTextArea(nickname + ": " + message);
    }

    public void updateTextArea(String message) {
        textArea.append(message);
        textArea.append("\n");
    }

    // 쓰레드 구현
    private class ChatClientThread extends Thread {
        private Socket socket;
        private BufferedReader br;

        public ChatClientThread(Socket socket) {
            this.socket = socket;

            try {
                br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String line;
                while ((line = br.readLine()) != null) {
                    updateTextArea(line); // 서버에서 받은 메시지를 UI에 업데이트
                }
            } catch (SocketException e) {
                ChatClientApp.log("채팅방에서 나왔습니다.!");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null && !socket.isClosed()) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        ChatClientApp.log("error" + e);
                    }
                }
            }
        }
    }
}





// quit 말고 나가기...-> 방나가기 프로토콜