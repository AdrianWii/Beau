/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Joanna
 */
public class BaseConnection {
    
     private final static BaseConnection temp = new BaseConnection();
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:bazatest.db"; // baza testowa
    public Connection connection;
    public Statement st;
        
    private BaseConnection(){
    
    try {
        
            Class.forName(BaseConnection.DRIVER);      
            
        } catch (ClassNotFoundException e) {
            
            System.err.println("Brak sterownika JDBC");
            
        }
 
        try {
            
            connection = DriverManager.getConnection(DB_URL);
            st = connection.createStatement();
            
        } catch (SQLException e) {
            
            System.err.println("Problem z otwarciem polaczenia");
            
        }
     
    }
    
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
        }
    }
    
    public static BaseConnection getBase(){
        return temp;
    }
}
