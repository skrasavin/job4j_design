package ru.job4j.map.simple.reports;

import java.util.function.Predicate;

public class HTMLReport implements Report {

    private final Store store;

    public HTMLReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<h3> Name; Hired; Fired; Salary; </h3>");
        for (Employee employee : store.findBy(filter)) {
            text.append("<p>" + employee.getName()).append(";</p>")
                    .append("<p>" + employee.getHired()).append(";</p>")
                    .append("<p>" + employee.getFired()).append(";</p>")
                    .append("<p>" + employee.getSalary()).append(";</p>")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
