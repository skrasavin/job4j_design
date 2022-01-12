package ru.job4j.map.simple.reports;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ReportEngineTest {

    @Test
    public void whenGenerateReportInXML() throws JAXBException {
        MemStore store = new MemStore();
        Calendar hiredDate = new GregorianCalendar(2010, Calendar.JULY, 18);
        Calendar firedDate = new GregorianCalendar(2022, Calendar.JANUARY, 5);
        hiredDate.setTimeZone(TimeZone.getTimeZone(ZoneOffset.of("+3")));
        firedDate.setTimeZone(TimeZone.getTimeZone(ZoneOffset.of("+3")));
        Employee worker = new Employee("Ivan", hiredDate, firedDate, 100);
        store.add(worker);
        XMLReportGenerator xml = new XMLReportGenerator(store);
        String exprectedXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<Employees>\n"
                + "    <employee>\n"
                + "        <fired>2022-01-05T00:00:00+03:00</fired>\n"
                + "        <hired>2010-07-18T00:00:00+03:00</hired>\n"
                + "        <name>Ivan</name>\n"
                + "        <salary>100.0</salary>\n"
                + "    </employee>\n"
                + "</Employees>\n";
        assertThat(xml.generate(em -> true), is(exprectedXML));
    }

    @Test
    public void whenGenerateReportInGson() {
        MemStore store = new MemStore();
        Calendar hiredDate = new GregorianCalendar();
        Calendar firedDate = new GregorianCalendar();
        hiredDate.set(2020, Calendar.MARCH, 21, 2, 2, 2);
        firedDate.set(2019, Calendar.MAY, 22, 3, 3, 3);
        Employee worker = new Employee("Ivan", hiredDate, firedDate, 100);
        store.add(worker);
        String expectedJson = "["
                + "{\"name\":\"Ivan\","
                + "\"hired\":{\"year\":2020,\"month\":2,\"dayOfMonth\":21,"
                + "\"hourOfDay\":2,\"minute\":2,\"second\":2},"
                + "\"fired\":{\"year\":2019,\"month\":4,\"dayOfMonth\":22,"
                + "\"hourOfDay\":3,\"minute\":3,\"second\":3},"
                + "\"salary\":100.0}"
                + "]";
        JsonReportGenerator jrg = new JsonReportGenerator(store);
        String json = jrg.generate(em -> true);
        assertThat(json, is(expectedJson));
    }

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHtmlResponseForItDepartment() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new HTMLReport(store);
        StringBuilder expect = new StringBuilder()
                .append("<h3> Name; Hired; Fired; Salary; </h3>")
                .append("<p>" + worker.getName()).append(";</p>")
                .append("<p>" + worker.getHired()).append(";</p>")
                .append("<p>" + worker.getFired()).append(";</p>")
                .append("<p>" + worker.getSalary()).append(";</p>")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenChangeSalaryTypeForCounting() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        double surcharge = 1.5;
        Report engine = new SalatyTypeReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() * surcharge).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenRemoveHiredTiredAndFilterFieldsByDeskForHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee anotherWorker = new Employee("Svan", now, now, 200);
        store.add(worker);
        store.add(anotherWorker);
        Report engine = new ForHrReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(anotherWorker.getName()).append(";")
                .append(anotherWorker.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}