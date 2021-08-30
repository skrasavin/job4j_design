package ru.job4j.iocase.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.Arrays;

public class Doctor {
    private final String name;
    private final int age;
    private final boolean experience;
    private final String[] studies;
    private final Skills skills;


    public Doctor(String name, int age, boolean experience, Skills skills, String... studies) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.studies = studies;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Doctor{"
                + "name='" + name
                + '\''
                + ", age=" + age
                + ", experience=" + experience
                + ", studies=" + Arrays.toString(studies)
                + ", skills=" + skills
                + '}';
    }

    public static void main(String[] args) {
        final Doctor doctor = new Doctor("Tim", 22, false, new Skills("surgeon"),
                                            "Uni", "Praxis");

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(doctor) + "\n");

        /* Модифицируем json-строку */
        final String doctorJson =
                "{"
                        + "\"name\":\"Tim\","
                        + "\"age\":22,"
                        + "\"experience\":false,"
                        + "\"skills\":"
                        + "{"
                        + "\"skill\":\"surgeon\""
                        + "},"
                        + "\"studies\":"
                        + "[\"Uni\",\"Praxis\"]"
                        + "}";

        final Doctor doctorMod = gson.fromJson(doctorJson, Doctor.class);
        System.out.println(doctorMod);
    }
}
