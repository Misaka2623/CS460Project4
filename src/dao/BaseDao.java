package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDao {
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@aloe.cs.arizona.edu:1521:oracle";
    private static final String USERNAME = "shenghou";
    private static final String PASSWORD = "a9397";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

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

    protected long generateId() {
        String tableName = getTableName();
        try (ResultSet resultSet = executeSql("SELECT max(\"?\") FROM \"?\"", tableName + "_id", tableName)) {
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return 1;
    }

    protected abstract String getTableName();

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
