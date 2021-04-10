package ru.job4j.iocase.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String log;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.log = botAnswers;
    }

    public String choice() throws IOException {
        String result = null;
        int n = 0;
        for (Scanner sc = new Scanner(Path.of(this.path)); sc.hasNext();) {
            ++n;
            String line = sc.nextLine();
            if (new Random().nextInt(n) == 0) {
                result = line;
            }
        }
        return result + "\n";
    }

    public void writeDataInFile(String path, String data) {
        try (BufferedWriter br = new BufferedWriter(
                new FileWriter(path, StandardCharsets.UTF_8, true))) {
            br.write(data + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException {
        Scanner in = new Scanner(System.in);
        String message;
        System.out.println("Добро пожаловать в чат!");
        writeDataInFile(log, "Добро пожаловать в чат!");
        String response;
        do {
            System.out.println("Какой у вас вопрос?");
            writeDataInFile(log, "Какой у вас вопрос?");

            message = in.nextLine();

            if (message.equals(OUT)) {
                System.out.println("Бот закончил работу.");
                writeDataInFile(log, "====== Бот закончил работу ====== \n");
                continue;
            }

            if (message.equals(STOP)) {
                System.out.println("Работа чата приостановлена");
                writeDataInFile(log, "!!! Работа чата приостановлена !!!");
                do {
                    message = in.nextLine();
                    writeDataInFile(log, message);
                }while (!message.equals(CONTINUE));
                writeDataInFile(log, "\r");
                continue;
            }

            response = choice();
            System.out.println(response);
            writeDataInFile(log, message);
            writeDataInFile(log, response);

        }while (!message.equals(OUT));
    }

    public static void main(String[] args) throws IOException {
        String  pathOfBotAnswers = "/home/serg/IdeaProjects/job4j_design/iofiles/responses.txt";
        String pathToWriteChat = "/home/serg/IdeaProjects/job4j_design/iofiles/chat_log.txt";
        ConsoleChat cc = new ConsoleChat(pathOfBotAnswers, pathToWriteChat);
        cc.run();
    }
}