package ru.job4j.iocase.serialization.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "doctor")
@XmlAccessorType(XmlAccessType.FIELD)
public class Doctor {
    @XmlAttribute
    private String name;

    @XmlAttribute
    private int age;
    @XmlAttribute
    private boolean experience;

    @XmlElement(name = "study")
    private String[] studies;

    private Skills skills;

    public Doctor() { }

    public Doctor(String name, int age, boolean experience, Skills skills, String... studies) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.studies = studies;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Doctor{"
                + "name='" + name
                + '\''
                + ", age=" + age
                + ", experience=" + experience
                + ", studies=" + Arrays.toString(studies)
                + ", skills=" + skills
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Doctor doctor = new Doctor("Tim", 22, false, new Skills("surgeon"),
                "Uni", "Praxis");

        JAXBContext context = JAXBContext.newInstance(Doctor.class);
        // Создаем сериализатор
        Marshaller marshaller = context.createMarshaller();
        // Указываем, что нам нужно форматирование
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String result = "";
        try (StringWriter writer = new StringWriter()) {
            // Сериализуем
            marshaller.marshal(doctor, writer);
            result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        // Для десериализации нам нужно создать десериализатор
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(result)) {
            // десериализуем
            Doctor res = (Doctor) unmarshaller.unmarshal(reader);
            System.out.println(res);
        }
    }
}