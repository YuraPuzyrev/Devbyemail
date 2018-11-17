package org.itstep.qa.lesson.db;

import java.sql.*;

public class RunnerDb {
    public static void main(String[] args) throws SQLException{
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/world?serverTimezone=UTC", "root", "root");

        } catch (SQLException ex) {
            System.out.println("Error!");
        }
        if (connection !=null) {
            System.out.println("--Подключение установлено--");
        } else {
            System.out.println("--Подключение НЕ установлено--");
        }


        String selectTableSQL = "SELECT * from country";
        Statement stat = null;
        ResultSet rc = null;
        try {
            stat = (Statement) connection.createStatement();
            rc = stat.executeQuery(selectTableSQL);
            while (rc.next()) {
                System.out.println(rc.getString(2));
            }
        } catch (SQLException ex) {
        } finally {
            rc.close();
            stat.close();
            connection.close();
        }
    }
}
