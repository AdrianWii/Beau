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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import Model.BaseConnection;
/**
 *
 * @author Joanna
 */
public class Model {
    
    BaseConnection base = BaseConnection.getBase(); 
    public boolean DodajKon(Kontrahent osoba) throws SQLException{ // test
         PreparedStatement prepStmt;
                 prepStmt = base.connection.prepareStatement("INSERT INTO KONTRAHENT VALUES(NULL, NULL, ?, ?);");
                 System.out.println(osoba.get_nazwa_firmy());
                 System.out.println(osoba.get_nip());
                 prepStmt.setString(1, osoba.get_nazwa_firmy());
                 prepStmt.setInt(2, osoba.get_nip());
                 prepStmt.execute();
     
         return true;
     }
    }
