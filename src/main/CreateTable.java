package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("SqlResolve")
public class CreateTable {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.OracleDriver");
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@aloe.cs.arizona.edu:1521:oracle", "shenghou", "a9397")) {
            createAddress(connection);
            createPerson(connection);
            createMember(connection);
            createGroup(connection);
            createEmployee(connection);
            createCategory(connection);
            createProduct(connection);
            createSupplier(connection);
            createWarehouse(connection);
            createSale(connection);
            createSubSale(connection);
        }
    }

    private static void createAddress(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE \"address\"" +
                    "(" +
                    "\"address_id\" number(10) NOT NULL PRIMARY KEY," +
                    "\"line1\" varchar(120) NOT NULL," +
                    "\"line2\" varchar(120)," +
                    "\"line3\" varchar(120)," +
                    "\"city\" varchar(100) NOT NULL," +
                    "\"state\" char(2) NOT NULL," +
                    "\"postal_code\" varchar(16) NOT NULL" +
                    ")");
        }
    }

    private static void createPerson(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE \"person\"" +
                    "(" +
                    "\"person_id\" number(10) NOT NULL PRIMARY KEY," +
                    "\"first_name\" varchar(35) NOT NULL," +
                    "\"last_name\" varchar(35) NOT NULL," +
                    "\"gender\" int DEFAULT 0 NOT NULL CHECK ( \"gender\" IN (0, 1, 2, 9) )," +
                    "\"birthday\" date," +
                    "\"address_id\" number(10) NOT NULL," +
                    "\"phone\" varchar(15)," +
                    "FOREIGN KEY (\"address_id\") REFERENCES \"address\" (\"address_id\")" +
                    ")");
        }
    }

    private static void createMember(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE \"member\"" +
                    "(" +
                    "\"member_id\" number(10) NOT NULL PRIMARY KEY," +
                    "\"username\" varchar(25) NOT NULL UNIQUE," +
                    "\"password\" varchar(32) NOT NULL," +
                    "\"person_id\" number(10) NOT NULL," +
                    "\"reward\" int DEFAULT 0 NOT NULL," +
                    "\"super_ember\" number(1) DEFAULT 0 NOT NULL CHECK ( \"super_ember\" IN (0, 1) )," +
                    "FOREIGN KEY (\"person_id\") REFERENCES \"person\" (\"person_id\")" +
                    ")");
        }
    }

    private static void createGroup(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE \"group\"" +
                    "(" +
                    "\"group_id\" number(10) NOT NULL PRIMARY KEY," +
                    "\"name\" varchar(255) NOT NULL" +
                    ")");
        }
    }

    private static void createEmployee(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE \"employee\"" +
                    "(" +
                    "\"employee_id\" number(10) NOT NULL PRIMARY KEY," +
                    "\"person_id\" number(10) NOT NULL," +
                    "\"salary\" number(*, 2) NOT NULL," +
                    "\"group_id\" number(10) NOT NULL," +
                    "FOREIGN KEY (\"person_id\") REFERENCES \"person\" (\"person_id\")," +
                    "FOREIGN KEY (\"group_id\") REFERENCES \"group\" (\"group_id\")" +
                    ")");
        }
    }

    private static void createCategory(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE \"category\"" +
                    "(" +
                    "\"category_id\" number(10) NOT NULL PRIMARY KEY," +
                    "\"name\" varchar(255) NOT NULL" +
                    ")");
        }
    }

    private static void createProduct(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE \"product\"" +
                    "(" +
                    "\"product_id\" number(10) NOT NULL PRIMARY KEY," +
                    "\"name\" varchar(255) NOT NULL," +
                    "\"retail_price\" number(*, 2) NOT NULL," +
                    "\"category_id\" number(10) NOT NULL," +
                    "\"membership_discount\" number(*, 2) DEFAULT .0 NOT NULL," +
                    "FOREIGN KEY (\"category_id\") REFERENCES \"category\" (\"category_id\")" +
                    ")");
        }
    }

    private static void createSupplier(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE \"supplier\"" +
                    "(" +
                    "\"supplier_id\" number(10) NOT NULL PRIMARY KEY," +
                    "\"name\" varchar(255) NOT NULL," +
                    "\"address_id\" number(10) NOT NULL," +
                    "\"contact_person\" number(10) NOT NULL," +
                    "FOREIGN KEY (\"address_id\") REFERENCES \"address\" (\"address_id\")," +
                    "FOREIGN KEY (\"contact_person\") REFERENCES \"person\" (\"person_id\")" +
                    ")");
        }
    }

    private static void createWarehouse(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE \"warehouse\"" +
                    "(" +
                    "\"warehouse_id\" number(10) NOT NULL PRIMARY KEY," +
                    "\"supplier_id\" number(10) NOT NULL," +
                    "\"product_id\" number(10) NOT NULL," +
                    "\"incoming_date\" date NOT NULL," +
                    "\"purchase_price\" number(*, 2) NOT NULL," +
                    "\"amount\" int NOT NULL," +
                    "FOREIGN KEY (\"supplier_id\") REFERENCES \"supplier\" (\"supplier_id\")," +
                    "FOREIGN KEY (\"product_id\") REFERENCES \"product\" (\"product_id\")" +
                    ")");
        }
    }

    private static void createSale(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE \"sale\"" +
                    "(" +
                    "\"sale_id\" number(10) NOT NULL PRIMARY KEY," +
                    "\"date\" date NOT NULL," +
                    "\"payment_method\" varchar(255) NOT NULL," +
                    "\"total_price\" number(*, 2) NOT NULL," +
                    "\"member_id\" number(10) NOT NULL," +
                    "FOREIGN KEY (\"member_id\") REFERENCES \"member\" (\"member_id\")" +
                    ")");
        }
    }

    private static void createSubSale(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE \"sub_sale\"" +
                    "(" +
                    "\"sub_sale_id\" number(10) NOT NULL PRIMARY KEY," +
                    "\"product_id\" number(10) NOT NULL," +
                    "\"sale_id\" number(10) NOT NULL," +
                    "\"price\" number(*, 2) NOT NULL," +
                    "\"amount\" int DEFAULT 1 NOT NULL CHECK ( \"amount\" > 0 )," +
                    "FOREIGN KEY (\"product_id\") REFERENCES \"product\" (\"product_id\")," +
                    "FOREIGN KEY (\"sale_id\") REFERENCES \"sale\" (\"sale_id\")" +
                    ")");
        }
    }
}
