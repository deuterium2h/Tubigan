/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tubigan;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DANEM682
 */
public class Database {

    Connection conn = null;

    public static Connection connectTo(String driver, String database, String account) {

        if (driver.toLowerCase() == "mysql") {

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/"+ database, account, account);
                System.out.println("Connected to " + database);
                return conn;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (driver.toLowerCase() == "oracle") {

            try {
                Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
                Connection conn = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:" + database, account, account.toUpperCase());
                System.out.println("Connected to " + database);
                return conn;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (driver.toLowerCase() == "oracle") {

            try {
                Class.forName("org.sqlite.JDBC");
                Connection conn = DriverManager.getConnection(
                        "jdbc:sqlite:database/" + database +".db");
                System.out.println("Connected to " + database);
                return conn;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
