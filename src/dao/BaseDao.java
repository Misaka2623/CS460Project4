package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * this is a basic data access object for connecting to jdbc.
 */
public abstract class BaseDao {
    /**
     * the sql driver used in this project.
     */
    private static final String DATABASE_DRIVER = "oracle.jdbc.OracleDriver";

    /**
     * the url of the database.
     */
    private static final String DATABASE_URL = "jdbc:oracle:thin:@aloe.cs.arizona.edu:1521:oracle";

    /**
     * the username of the database.
     */
    private static final String DATABASE_USERNAME = "shenghou";

    /**
     * the password of the database.
     */
    private static final String DATABASE_PASSWORD = "a9397";

    // initialize the database at the first time that this class is loaded.
    static {
        try {
            Class.forName(DATABASE_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * execute a sql statement and get the results.
     *
     * @param preparedSql an SQL statement that may contain one or more '?' IN parameter placeholders
     * @param args        the arguments to replace the '?' in prepared statement.
     * @return a {@code ResultSet} object that contains the data produced by the query; {@code null} if some errors
     * happened when executing the sql.
     */
    public ResultSet executeSql(String preparedSql, Object... args) {
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(preparedSql)) {
                for (int i = 1; i <= args.length; i++) {
                    statement.setObject(i, args[i]);
                }
                return statement.executeQuery();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * generate an new id by find the largest id in the sql and add 1 to it.
     *
     * @return the generated id.
     */
    protected long generateId() {
        String tableName = getTableName();
        try (ResultSet resultSet = executeSql("SELECT max(\"?\") FROM \"?\"", tableName + "_id", tableName)) {
            if (resultSet.next()) {
                return resultSet.getLong(1) + 1;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return 1;
    }

    /**
     * get the name of the table that this object access to.
     *
     * @return the name of the table.
     */
    protected abstract String getTableName();

    /**
     * get the connection of the database.
     *
     * @return a connection to the database.
     * @throws SQLException if a database access error occurs.
     */
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
    }
}
