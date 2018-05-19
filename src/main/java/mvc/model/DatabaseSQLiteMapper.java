package mvc.model;

import mvc.CashAction;
import org.sqlite.JDBC;

import java.sql.*;

public class DatabaseSQLiteMapper implements DatabaseMapper {

    private static final String CON_STR = "jdbc:sqlite:C:/db_hw6_7";

    private Connection connection;

    public DatabaseSQLiteMapper() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(CON_STR);
    }

    @Override
    public void addCashAction(CashAction cashAction) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO CashAction(`name`, `total`) VALUES(?, ?, ?)")) {
            statement.setObject(1, cashAction.getUserName());
            statement.setObject(2, cashAction.getTotal());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CashAction getCashActionById(Long id) {
        CashAction cashAction = null;
        try (Statement statement = this.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT id, name, total FROM CashAction WHERE id =" + id);
            if (resultSet.next()) {
                cashAction = new CashAction(resultSet.getLong("id"),
                        resultSet.getString("good"),
                        resultSet.getFloat("price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cashAction;
    }
}
