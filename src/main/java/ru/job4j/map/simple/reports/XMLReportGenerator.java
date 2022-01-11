package ru.job4j.map.simple.reports;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.function.Predicate;

public class XMLReportGenerator {

    private final Store store;

    public XMLReportGenerator(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(MemStore.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(store, writer);
            xml = writer.getBuffer().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xml;
    }
}
