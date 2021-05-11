package ru.job4j.iocase.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            String line;
            List<String> lines = new ArrayList<>();
            while ((line = in.readLine()) != null) {
                if (line.contains("400") || line.contains("500")) {
                    lines.add(line.split(" ")[1]);
                    while ((line = in.readLine()) != null) {
                        if (line.contains("200") || line.contains("300")) {
                            lines.add(line.split(" ")[1]);
                            break;
                        }
                    }
                }
            }
            addToLog(target, lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void addToLog(String target, List log) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            for (Object a : log) {
                out.println(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Analizy().unavailable("iofiles/server/server.log", "iofiles/server/unavailable.csv");

    }
}