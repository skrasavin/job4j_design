package ru.job4j.map.simple.reports;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.function.Predicate;

public class XMLReportGenerator2 {
    private final Store store;

    public XMLReportGenerator2(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) throws JAXBException {
        List<Employee> employeeList = store.findBy(filter);
        JAXBContext context = JAXBContext.newInstance(MemStore.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(store.findBy(filter), writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xml;
    }
}
