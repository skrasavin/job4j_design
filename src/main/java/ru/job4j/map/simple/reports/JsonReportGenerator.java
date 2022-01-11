package ru.job4j.map.simple.reports;

import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.function.Predicate;

public class JsonReportGenerator {

    private final Store store;

    public JsonReportGenerator(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        List<Employee> employeeList = store.findBy(filter);
        var lib = new GsonBuilder().create();
        return lib.toJson(employeeList);
    }
}
