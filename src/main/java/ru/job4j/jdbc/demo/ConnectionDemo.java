package ru.job4j.jdbc.demo;
import ru.job4j.iocase.io.Config;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String path = "iofiles/app.properties";
        Config c = new Config(path);
        c.load();
        String url = c.value("sql.url");
        String login = c.value("sql.login");
        String password = c.value("sql.password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
