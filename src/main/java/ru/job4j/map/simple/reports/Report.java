package ru.job4j.map.simple.reports;

import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter);
    String generateHTML(Predicate<Employee> filter);
    String generateSalaryType(Predicate<Employee> filter);
    String generateForHr(Predicate<Employee> filter);
}
