package ru.job4j.iocase.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        for (int a = 1; a < 10; a++) {
            for (int b = 1; b < 10; b++) {
                int x = a * b;
                String str = a + "*" + b + "=" + x + " | ";
                if (b == 9) {
                    str = a + "*" + b + "=" + x + '\n';
                }
                try (FileOutputStream out = new FileOutputStream(
                        "/home/serg/IdeaProjects/job4j_design/iofiles/result.txt", true)) {
                    out.write(str.getBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
