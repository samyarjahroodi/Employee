package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public JdbcConnection(Connection connection) throws SQLException {
        this.connection = connection;
    }

    private Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres"
            , "postgres", "1381Iran");

    public JdbcConnection() throws SQLException {
    }
}
