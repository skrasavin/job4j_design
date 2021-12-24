package ru.job4j.ood.tdd.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BotTest {

    @Ignore
    @Test
    public void firstResponse() {
        Bot bot = new Bot();
        String template = "I am a ${name}, Who are ${subject}?";
        String testResponse = "I am a Richard, Who are you?";
        Map<String, String> example = new HashMap<>();
        example.put("name", "Richard");
        example.put("subject", "you");
        assertThat(testResponse, is(bot.produce(template, example)));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void secondResponse() {
        Bot bot = new Bot();
        String template = "I am a ${name}, Who are ${subject}?"
                + "I am your assistent from ${company}";
        Map<String, String> example = new HashMap<>();
        example.put("Richard", "you");
        bot.produce(template, example);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void thirdResponse() {
        Bot bot = new Bot();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> example = new HashMap<>();
        example.put("name", "Richard");
        example.put("subject", "you");
        example.put("age", "18");
        bot.produce(template, example);
    }
}