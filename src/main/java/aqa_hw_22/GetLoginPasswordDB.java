package aqa_hw_22;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


public class GetLoginPasswordDB {
    String dbUrl = "";
    String dbUser = "";
    String dbPassword = "";

    public Map<String, String> getUsers() {
        Map<String, String> users = new HashMap<>();

        String query = "SELECT login, password FROM Ovsov_usersDataTable";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");

                users.put(login, password);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Cannot reach DB", e);
        }

        return users;
    }

}
