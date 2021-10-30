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
}