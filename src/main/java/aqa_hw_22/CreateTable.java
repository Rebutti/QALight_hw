package aqa_hw_22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void main(String[] args) {
        String url = "";
        String user = "";
        String password = "";

        String sql = "CREATE TABLE IF NOT EXISTS Ovsov_usersDataTable (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "login VARCHAR(255) NOT NULL, " +
                "password VARCHAR(255) NOT NULL" +
                ")";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (
                SQLException ex) {
            ex.printStackTrace();
        }
    }




}
