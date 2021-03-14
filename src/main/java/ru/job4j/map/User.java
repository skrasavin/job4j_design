package ru.job4j.map;

import java.util.*;

public class User {
    private String name;
    private int age;
    private Calendar birthday;

    public Calendar getBirthday() {
        return birthday;
    }

    public User(String name, int age, Calendar birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        return this.name.charAt(0);
    }

    public static void main(String[] args) {
        User first = new User("Ilya", 21, new GregorianCalendar(2000, 12, 21));
        User second = new User("Ilya", 21, new GregorianCalendar(2000, 12, 21));
        Map<User, Object> users = new HashMap<>();
        if (first.getBirthday().getTimeInMillis() == second.getBirthday().getTimeInMillis()) {
            users.put(first, new Object());
            users.put(second, new Object());
            System.out.println("ok");
        }
        users.entrySet().forEach(System.out::println);
        users.entrySet().forEach(a -> System.out.println(a.hashCode()));
        users.keySet().forEach(a -> System.out.println(a.hashCode()));

    }
}
