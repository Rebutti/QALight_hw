package aqa_hw_22;

import java.sql.*;

public class GetTableInfo {

    public static void main(String[] args) {
        String url = "";
        String user = "";
        String password = "";
        String tableName = "Ovsov_usersDataTable";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection is success!\n");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `" + tableName + "`");

            ResultSetMetaData rsMeta = rs.getMetaData();
            int columnCount = rsMeta.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.print(String.format("%-20s", rsMeta.getColumnName(i)));
            }
            System.out.println();

            for (int i = 1; i <= columnCount; i++) {
                System.out.print("--------------------");
            }
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String value = rs.getString(i);
                    System.out.print(String.format("%-20s", value));
                }
                System.out.println();
            }
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
