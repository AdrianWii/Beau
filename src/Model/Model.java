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
         PreparedStatement prepStmt1;
         PreparedStatement prepStmt2;
         int id=0;
                 prepStmt1 = base.connection.prepareStatement("INSERT INTO DANE VALUES(NULL, ?, ?, ?, ?, ?, ?);");
                 prepStmt1.setString(1, osoba.get_imie());
                 prepStmt1.setString(2, osoba.get_nazwisko());
                 prepStmt1.setString(3, osoba.get_telefon());
                 prepStmt1.setString(4, osoba.get_email());
                 prepStmt1.setString(5, osoba.get_miejscowosc());
                 prepStmt1.setString(6, osoba.get_ulica());
                 prepStmt1.execute();
                
        try (ResultSet generatedKeys=base.st.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                id=generatedKeys.getInt(1);
            }
            else {
                throw new SQLException("No ID obtained.");
            }
        }
                 prepStmt2 = base.connection.prepareStatement("INSERT INTO KONTRAHENT VALUES(NULL, ?, ?, ?);");
                 System.out.println(id);
                 System.out.println(osoba.get_nip());
                 System.out.println(osoba.get_nazwa_firmy());
                 prepStmt2.setInt(1, id);
                 prepStmt2.setString(2, osoba.get_nazwa_firmy());
                 prepStmt2.setInt(3, osoba.get_nip());
                 prepStmt2.execute();
     
         return true;
     }  
    }

