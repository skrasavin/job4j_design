package ru.job4j.iocase.serialization.JsonObject;

import org.json.JSONObject;
import java.util.Arrays;

public class Doctor {
    private final String name;
    private final int age;
    private final boolean experience;
    private final String[] studies;
    private final Skills skills;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isExperience() {
        return experience;
    }

    public String[] getStudies() {
        return studies;
    }

    public Skills getSkills() {
        return skills;
    }

    public Doctor(String name, int age, boolean experience, Skills skills, String... studies) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.studies = studies;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", experience=" + experience +
                ", studies=" + Arrays.toString(studies) +
                ", skills=" + skills +
                '}';
    }

    public static void main(String[] args) {
        final Doctor doctor = new Doctor("Tim", 22, false, new Skills("surgeon"),
                "Uni", "Praxis");

        /* JSONObject напрямую методом put */
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", doctor.getName());
        jsonObject.put("age", doctor.getAge());
        jsonObject.put("experience", doctor.isExperience());
        jsonObject.put("studies", doctor.getStudies());
        jsonObject.put("skills", doctor.getSkills());
        System.out.println(jsonObject.toString());

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(doctor).toString());
    }
}
