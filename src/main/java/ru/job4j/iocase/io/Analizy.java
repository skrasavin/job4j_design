package ru.job4j.iocase.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class Analizy {
    public void unavailable(String source, String target) {
        StringBuilder str = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = in.readLine()) != null) {
                if (line.contains("400") || line.contains("500")) {
                    str.append(line.split(" ")[1]).append(";");
                    while ((line = in.readLine()) != null) {
                        if (line.contains("200")) {
                            str.append(line.split(" ")[1]).append("\r");
                            break;
                        }
                    }
                }
            }
            addToLog(target, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void addToLog(String target, StringBuilder log) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            out.println(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Analizy().unavailable("iofiles/server/server.log", "iofiles/server/unavailable.csv");

    }
}