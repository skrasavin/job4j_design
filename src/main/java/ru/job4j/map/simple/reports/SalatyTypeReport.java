package ru.job4j.map.simple.reports;

import java.util.function.Predicate;

public class SalatyTypeReport implements Report {

    private Store store;

    public SalatyTypeReport(Store store) {
        this.store = store;
    }
    @Override
    public String generate(Predicate<Employee> filter) {
        double surcharge = 1.5;
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() * surcharge).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
