package ru.job4j.iocase.serialization.JsonObject;

public class Skills {
    private final String skill;

    public String getSkill() {
        return skill;
    }

    public Skills(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "skill='" + skill + '\'' +
                '}';
    }
}