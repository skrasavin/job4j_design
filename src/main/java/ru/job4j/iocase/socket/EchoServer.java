package ru.job4j.iocase.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                System.out.println(socket.getInetAddress());
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str.contains("msg") && str.split("msg=")[1].split(" ")[0]
                                .equals("Bye")) {
                            out.write("HTTP/1.1 200 OK\r\n\"".getBytes());
                            out.write("Сервер закончил работу\r\n".getBytes());
                            server.close();
                        }
                        System.out.println(str);
                    }
                    out.write("HTTP/1.1 200 OK\r\n\"".getBytes());
                }
            }
        }
    }
}