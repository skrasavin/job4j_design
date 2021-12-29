package ru.job4j.map.simple.reports;

import java.util.function.Predicate;

public class ReportEngine implements Report {

    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    @Override
    public String generateHTML(Predicate<Employee> filter) {
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

    @Override
    public String generateSalaryType(Predicate<Employee> filter) {
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

    @Override
    public String generateForHr(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        for (Employee employee : store.findBySalaryDesk(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}