package ru.job4j.iocase.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    int a = 0;
                    while (!(str = in.readLine()).isEmpty()) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        if (str.contains("msg") && str.split("msg=")[1].split(" ")[0]
                                .equals("Exit")) {
                                out.write("Bye.".getBytes());
                                server.close();
                                break;
                        }
                        if (str.contains("msg") && str.split("msg=")[1].split(" ")[0]
                                .equals("Hello")) {
                            out.write("Hello, dear friend.".getBytes());
                            break;
                        }else {
                            out.write("What?".getBytes());
                            break;
                        }
                    }
                }
            }
        }
    }
}