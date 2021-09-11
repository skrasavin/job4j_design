package ru.job4j.jdbc.statement;
import ru.job4j.iocase.io.Config;

import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Config c = new Config(properties.getProperty("path"));
        c.load();
        String url = c.value("sql.url");
        String login = c.value("sql.login");
        String password = c.value("sql.password");
        this.connection = DriverManager.getConnection(url, login, password);

    }

    public static void main(String[] args) throws Exception {
        String path = "iofiles/app.properties";
        Properties properties = new Properties();
        properties.put("path", path);
        TableEditor tableEditor = new TableEditor(properties);
//        tableEditor.createTable("emptyTable");
//        tableEditor.dropTable("Job4J");
//        tableEditor.addColumn("Job4J", "pass", "VARCHAR");
//        tableEditor.addColumn("Job4J", "pass1", "VARCHAR");
//        tableEditor.dropColumn("Job4J", "pass1");
//        tableEditor.renameColumn("Job4J", "pass", "passTest");

    }

    public void executeCommandInTable(String command) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(command);
        }
    }


    // - createTable() – создает пустую таблицу без столбцов с указанным именем;
    public void createTable(String tableName) throws Exception {
//        String sqlCommand = "create table if not exists %s(%s);";
        String sqlCommand = String.format(
                "create table if not exists " + tableName + "(%s);",
                "id serial primary key"
        );
        executeCommandInTable(sqlCommand);
        System.out.println("Table created");
    }


    //- dropTable() – удаляет таблицу по указанному имени;
    public void dropTable(String tableName) throws Exception {
        String sqlCommand = String.format("DROP TABLE %s", tableName);
        executeCommandInTable(sqlCommand);
        System.out.printf("Table | %s | deleted", tableName);
    }


    // - addColumn() – добавляет столбец в таблицу;
    public void addColumn(String tableName, String columnName, String type) throws Exception {
        String sqlCommand = String.format("ALTER TABLE %s ADD COLUMN %s %s", tableName, columnName, type);
        executeCommandInTable(sqlCommand);
        System.out.println("New column added");
    }

    // - dropColumn() – удаляет столбец из таблицы;
    public void dropColumn(String tableName, String columnName) throws Exception {
        String sqlCommand = String.format("ALTER TABLE %s DROP COLUMN %s", tableName, columnName);
        executeCommandInTable(sqlCommand);
        System.out.println("Column was deleted");
    }


    //- renameColumn() – переименовывает столбец.
    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        String sqlCommand = String.format("ALTER TABLE %s RENAME COLUMN %s TO %s", tableName, columnName, newColumnName);
        executeCommandInTable(sqlCommand);
        System.out.println("Column was renamed");
    }


    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}