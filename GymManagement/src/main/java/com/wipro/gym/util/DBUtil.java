package com.wipro.gym.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static Connection getDBConnection() {

        Connection con = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "system", "sanjanarr10"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
