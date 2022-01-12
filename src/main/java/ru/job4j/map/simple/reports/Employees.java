package ru.job4j.map.simple.reports;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Employees")
public class Employees {

        private List<Employee> employees;

        public Employees() {

        }

        public Employees(List<Employee> employees) {
            this.employees = employees;
        }

        public List<Employee> getEmployee() {
            return employees;
        }

        public void setEmployee(List<Employee> employees) {
            this.employees = employees;
        }
}
