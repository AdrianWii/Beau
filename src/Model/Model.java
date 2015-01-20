/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Handler.ExceptionHandler;
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
    
    public boolean UsunKon(int id) throws SQLException{
       PreparedStatement prepStmt1;
       prepStmt1 = base.connection.prepareStatement("DELETE FROM DANE WHERE id_dane=?");
       prepStmt1.setInt(1, id);         
       prepStmt1.execute();
       PreparedStatement prepStmt2; // relacje w sqlite????
       prepStmt2 = base.connection.prepareStatement("DELETE FROM KONTRAHENT WHERE id_dane=?");
       prepStmt2.setInt(1, id);         
       prepStmt2.execute();
       return true;
    }
    
    public boolean EdytujKon(Kontrahent osoba) throws SQLException{
        PreparedStatement prepStmt1;
        PreparedStatement prepStmt2;
        prepStmt1 = base.connection.prepareStatement("UPDATE DANE SET IMIE=?, NAZWISKO=?, TELEFON=?, EMAIL=?, MIEJSCOWOSC=?, ULICA=? WHERE ID_DANE=?");
                 prepStmt1.setString(1, osoba.get_imie());
                 prepStmt1.setString(2, osoba.get_nazwisko());
                 prepStmt1.setString(3, osoba.get_telefon());
                 prepStmt1.setString(4, osoba.get_email());
                 prepStmt1.setString(5, osoba.get_miejscowosc());
                 prepStmt1.setString(6, osoba.get_ulica());
                 prepStmt1.setInt(7, osoba.id_dane);
                 prepStmt1.execute();
        prepStmt2 = base.connection.prepareStatement("UPDATE KONTRAHENT SET NAZWA_FIRMY=?, NIP=? WHERE ID_DANE=?");
                prepStmt2.setString(1, osoba.get_nazwa_firmy());
                prepStmt2.setInt(2, osoba.get_nip());
                prepStmt2.setInt(3, osoba.id_dane);
                prepStmt2.execute();
          return true;
    }
        
        public Pracownik ZalogujPracownika(String login, String haslo)
        {
            ResultSet result1=null;
            ResultSet result2=null;
            Pracownik pracownik=null;
            int id;
            int id_typ;
            try
            {
                if(login!=null || haslo!= null)
                {
                    result1=base.st.executeQuery("SELECT * FROM PRACOWNICY WHERE LOGIN="+login+"AND HASLO="+haslo);
                    id=result1.getInt("ID_DANE");
                    id_typ=result1.getInt("ID_TYPU_UZYTKOWNIKA");
                    result2=base.st.executeQuery("SELECT * FROM PRACOWNICY WHERE ID_DANE="+id);
                    pracownik=Pracownik.Zaloguj(result2.getString("IMIE"), result2.getString("NAZWISKO"), result2.getString("TELEFON"),
                            result2.getString("EMAIL"), result2.getString("MIEJSCOWOSC"), result2.getString("ULICA"), result1.getString("LOGIN"),
                            result1.getString("HASLO"), id, id_typ);
                }
            }catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
          return pracownik;
        }
        
        public boolean DodajPrac(Pracownik osoba) throws SQLException{ 
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
                 prepStmt2 = base.connection.prepareStatement("INSERT INTO PRACOWNIK VALUES(NULL, ?, ?, ?, ?);");
                 prepStmt2.setInt(1, osoba.id_typu);
                 prepStmt2.setInt(2, id);
                 prepStmt2.setString(3, osoba.get_login());
                 prepStmt2.setString(4, osoba.get_haslo());
                 prepStmt2.execute();
     
         return true;
     }  
        
       public boolean UsunPrac(int id) throws SQLException{
       PreparedStatement prepStmt1;
       prepStmt1 = base.connection.prepareStatement("DELETE FROM DANE WHERE id_dane=?");
       prepStmt1.setInt(1, id);         
       prepStmt1.execute();
       PreparedStatement prepStmt2; 
       prepStmt2 = base.connection.prepareStatement("DELETE FROM PRACOWNIK WHERE id_dane=?");
       prepStmt2.setInt(1, id);         
       prepStmt2.execute();
       return true;
    }
        
        public boolean EdytujPrac(Pracownik osoba) throws SQLException{
        PreparedStatement prepStmt1;
        PreparedStatement prepStmt2;
        prepStmt1 = base.connection.prepareStatement("UPDATE DANE SET IMIE=?, NAZWISKO=?, TELEFON=?, EMAIL=?, MIEJSCOWOSC=?, ULICA=? WHERE ID_DANE=?");
                 prepStmt1.setString(1, osoba.get_imie());
                 prepStmt1.setString(2, osoba.get_nazwisko());
                 prepStmt1.setString(3, osoba.get_telefon());
                 prepStmt1.setString(4, osoba.get_email());
                 prepStmt1.setString(5, osoba.get_miejscowosc());
                 prepStmt1.setString(6, osoba.get_ulica());
                 prepStmt1.setInt(7, osoba.id_dane);
                 prepStmt1.execute();
        prepStmt2 = base.connection.prepareStatement("UPDATE PRACOWNIK SET LOGIN=?, HASLO=? WHERE ID_DANE=?");
                prepStmt2.setString(1, osoba.get_login());
                prepStmt2.setString(2, osoba.get_haslo());
                prepStmt2.setInt(3, osoba.id_dane);
                prepStmt2.execute();
          return true;
    }
        
        public boolean DodajKl(Klient osoba) throws SQLException{ 
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
                 prepStmt2 = base.connection.prepareStatement("INSERT INTO KLIENCI VALUES(NULL, ?);");
                 prepStmt2.setInt(1, id);
                 prepStmt2.execute();
     
         return true;
     }  
        
       public boolean UsunKli(int id) throws SQLException{
       PreparedStatement prepStmt1;
       prepStmt1 = base.connection.prepareStatement("DELETE FROM DANE WHERE id_dane=?");
       prepStmt1.setInt(1, id);         
       prepStmt1.execute();
       PreparedStatement prepStmt2; 
       prepStmt2 = base.connection.prepareStatement("DELETE FROM KLIENCI WHERE id_dane=?");
       prepStmt2.setInt(1, id);         
       prepStmt2.execute();
       return true;
    }
       
       public boolean EdytujKli(Klient osoba) throws SQLException{
        PreparedStatement prepStmt1;
        prepStmt1 = base.connection.prepareStatement("UPDATE DANE SET IMIE=?, NAZWISKO=?, TELEFON=?, EMAIL=?, MIEJSCOWOSC=?, ULICA=? WHERE ID_DANE=?");
                 prepStmt1.setString(1, osoba.get_imie());
                 prepStmt1.setString(2, osoba.get_nazwisko());
                 prepStmt1.setString(3, osoba.get_telefon());
                 prepStmt1.setString(4, osoba.get_email());
                 prepStmt1.setString(5, osoba.get_miejscowosc());
                 prepStmt1.setString(6, osoba.get_ulica());
                 prepStmt1.setInt(7, osoba.id_dane);
                 prepStmt1.execute();
          return true;
    }
       
       
        
        /*public List<Grafik> WyswietlGrafik(int id_pracownika)
        {
            ResultSet result1=null;
            ResultSet result2=null;
            List <Grafik> grafik = new LinkedList<Grafik>();
            int id []=null;
            int i;
            try
            {

            }catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
            return grafik;
            
        }*/
}
 

