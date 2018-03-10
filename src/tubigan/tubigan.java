/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tubigan;

/**
 *
 * @author DANEM682
 */
import java.sql.*;

public class tubigan {

    /**
     * @param args the command line arguments
     */
    public static Connection connectTo(String database, String username, String password) {
        if (database == "Oracle") {
            try{
//                Class.forName("com.mysql.jdbc.Driver").newInstance();
//                Connection conn = DriverManager.getConnection(
//                        "jdbc:mysql://localhost:3306/inventory", username, password);
                System.out.println("Connected to Database! " +database+ ", " +username+ ", " +password);
//                return conn;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if (database == "MySQL") {
            try{
//                Class.forName("com.mysql.jdbc.Driver").newInstance();
//                Connection conn = DriverManager.getConnection(
//                        "jdbc:mysql://localhost:3306/inventory", username, password);
                System.out.println("Connected to Database! " +database+ ", " +username+ ", " +password);
//                return conn;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else {
            System.err.println("There is no " +database+ " database.");
        }
        return null;
    }
//    public static void connectTo(String db, String un, String pw) {
//        if (db == "oracle") {
//            System.out.println("Connected to Database! " +db+ ", " +un+ ", " +pw);
//        }
//        else if (db == "mysql") {
//            System.out.println("Connected to Database! " +db+ ", " +un+ ", " +pw);
//        }
//    }
//    String[] arrays 
    public static void main(String[] args) {
        
        for (int number = 0; number != 5; number++) {
            System.out.println("JEJEMON");
        }
    }
}
