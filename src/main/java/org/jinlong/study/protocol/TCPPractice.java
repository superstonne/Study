package org.jinlong.study.protocol;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPPractice {

    public static void main(String[] args) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(8888);
                    Socket socket = serverSocket.accept();
                    InputStreamReader reader = new InputStreamReader(socket.getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    char[] content = new char[1000];
                    while (reader.read(content) != 0) {
                        System.out.println(String.valueOf(content));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Socket socket = new Socket("localhost", 8888);
        OutputStream out = socket.getOutputStream();
        OutputStreamWriter outWriter = new OutputStreamWriter(out);
        outWriter.write("This is content coming from Nick");
        outWriter.flush();
    }
}
