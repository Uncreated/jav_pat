package mvc;

import mvc.controller.Controller;
import mvc.model.CashedDatabaseMapper;
import mvc.model.DatabaseSQLiteMapper;
import mvc.view.UserUi;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try {
            DatabaseSQLiteMapper databaseSQLiteMapper = new DatabaseSQLiteMapper();
            CashedDatabaseMapper cashedDatabaseMapper = new CashedDatabaseMapper(databaseSQLiteMapper);

            Controller controller = new Controller(cashedDatabaseMapper);
            UserUi userUi = new UserUi(controller);
            userUi.run();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
