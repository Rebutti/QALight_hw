package aqa_hw_22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RemoveTable {

    public static void main(String[] args) {
        String url = "";
        String user = "";
        String password = "";

        String sql = "DROP TABLE IF EXISTS Ovsov_usersDataTable";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
