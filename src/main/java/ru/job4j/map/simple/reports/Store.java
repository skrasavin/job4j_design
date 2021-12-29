package ru.job4j.map.simple.reports;

import java.util.List;
import java.util.function.Predicate;

public interface Store {
    List<Employee> findBy(Predicate<Employee> filter);
    List<Employee> findBySalaryDesk(Predicate<Employee> filter);
}