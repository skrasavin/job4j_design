package ru.job4j.iocase.serialization.json;

public class Skills {
    private final String skill;

    public Skills(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Skills{"
                + "skill='" + skill
                + '\''
                + '}';
    }
}