package ru.job4j.iocase.logging;

//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

//    private static final Logger LOG = LogManager.getLogger(UsageLog4j.class.getName());
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

//    public static void main(String[] args) {
//        LOG.trace("trace message");
//        LOG.debug("debug message");
//        LOG.info("info message");
//        LOG.warn("warn message");
//        LOG.error("error message");
//    }
    public static void main(String[] args) {
        String name = "Admin";
        int age = 33;
        short schedule = 5;
        float height = 75;
        double weight = 75.5;
        long salary = 500;
        char department = 'A';
        boolean admin = true;



        LOG.debug("User info name : {}, age : {}," +
                  " shedule : {}, height : {}, weight : {}, salary : {}" +
                  " department : {}, admin : {}  ", name, age, schedule,
                height, weight, salary, department, admin);
    }
}