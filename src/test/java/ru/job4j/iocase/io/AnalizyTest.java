package ru.job4j.iocase.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenTestFirstAndLastLines() throws IOException {
        File target = folder.newFile("target.txt");
        String first = null, last = null, line;
        new Analizy().unavailable("iofiles/server/server.log", target.getAbsolutePath());
        try (BufferedReader in = new BufferedReader(new FileReader(target.getAbsolutePath()))) {
            first = in.readLine();
            while ((line = in.readLine()) != null) {
                last = line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String testOfFirstLine = "10:58:01";
        String testOfLastLine = "11:02:02";
        assertThat(first, is(testOfFirstLine));
        assertThat(last, is(testOfLastLine));
    }
}