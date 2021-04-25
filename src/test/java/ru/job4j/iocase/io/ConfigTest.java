package ru.job4j.iocase.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "iofiles/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("sskrasavin")
        );
    }

    @Test
    public void whenThrowIllegalArgumentException() {
        String path = "iofiles/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("password"),
                is("qweasd")
        );
    }


    @Test(expected = IllegalArgumentException.class)
    public void whenReadLineWithComment() throws IllegalArgumentException{
        String path = "iofiles/appForTest.properties";
        Config config = new Config(path);
        config.load();
    }
}