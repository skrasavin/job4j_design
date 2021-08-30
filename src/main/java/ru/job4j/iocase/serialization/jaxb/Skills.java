package ru.job4j.iocase.serialization.jaxb;

import com.sun.xml.txw2.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "contact")
public class Skills {

    @XmlAttribute
    private String skill;

    public Skills(String skill) {
        this.skill = skill;
    }

    public Skills() { }
    @Override
    public String toString() {
        return "Skills{"
                + "skill='" + skill
                + '\''
                + '}';
    }
}
