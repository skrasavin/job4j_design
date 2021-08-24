package ru.job4j.iocase.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;

public class ConsoleChat {
    private final List<String> lines = new ArrayList<>();
    private final List<String> log = new ArrayList<>();
    private final String logPath;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String logPath) throws IOException {
        this.logPath = logPath;
        modifyToList(path);
    }

    public void modifyToList(String path) throws IOException {
        if (!path.isEmpty()) {
            for (Scanner sc = new Scanner(Path.of(path)); sc.hasNext();) {
                this.lines.add(sc.nextLine());
            }
        } else {
            throw new IOException("Проверьте расположение файла");
        }
    }

    public void writeDataInFile() {
        try (BufferedWriter br = new BufferedWriter(
                new FileWriter(logPath, StandardCharsets.UTF_8, true))) {
            for (String logData: log) {
                br.write(logData + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        String message;
        String response;
        System.out.println("Добро пожаловать в чат!");
        log.add("Добро пожаловать в чат!");
        do {
            System.out.println("Какой у вас вопрос?");
            log.add("Какой у вас вопрос?");

            message = in.nextLine();

            if (message.equals(OUT)) {
                System.out.println("Бот закончил работу.");
                log.add("====== Бот закончил работу ======" + '\n');
                continue;
            }

            if (message.equals(STOP)) {
                System.out.println("Работа чата приостановлена");
                log.add("!!! Работа чата приостановлена !!!");
                do {
                    message = in.nextLine();
                    log.add(message);
                } while (!message.equals(CONTINUE));
                log.add("\r");
                continue;
            }

            response = this.lines.get(new Random().nextInt(lines.size()));
            System.out.println(response);
            log.add(message);
            log.add(response);

        } while (!message.equals(OUT));
        writeDataInFile();
    }

    public static void main(String[] args) throws IOException {
        String  pathOfBotAnswers = "/home/serg/IdeaProjects/job4j_design/iofiles/responses.txt";
        String pathToWriteChat = "/home/serg/IdeaProjects/job4j_design/iofiles/chat_log.txt";
        ConsoleChat cc = new ConsoleChat(pathOfBotAnswers, pathToWriteChat);
        cc.run();
    }
}