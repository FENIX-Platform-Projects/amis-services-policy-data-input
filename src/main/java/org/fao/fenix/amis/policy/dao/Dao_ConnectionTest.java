package org.fao.fenix.amis.policy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by fabrizio on 5/6/14.
 */
public class Dao_ConnectionTest {

    private static String DB_URI = "jdbc:postgresql://localhost:5432/amis-policy";
    private static String DB_LOGINID = "postgres";
    private static String DB_PASSWORD = "Qwaszx";

    public Connection getJNDIConnection() {
        Connection dbConnection = null;

        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(
                    DB_URI, DB_LOGINID, DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
