/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Handler.ExceptionHandler;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author angelina
 */
public class Usluga {
       
    static Connection conn = null;
    public void changePriceId(double percent, int id)
    {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("UPDATE uslugi SET cena=cena*? WHERE id_uslugi=?");
            stmt.setDouble(1, percent);
            stmt.setInt(2, id);
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }        
    }
    
    //Cena dla klientów z powyżej pięcioma wizytami jest o 10% niższa
    public double getCena(int id_klienta, int id_wizyty)
    {
        Statement stmt;
        ResultSet rs;
        int iloscWizyt = 0;
        double cena = 0.0;
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT count(id_klienta) FROM wizyty WHERE id_klienta=" + id_klienta);
            if(rs.next()) { //jezeli wynik pusty, to metoda zwraca null
                iloscWizyt =rs.getInt(1);
            }
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT u.cena FROM wizyty w, usugi u WHERE u.id_usugi=w.id_uslugi AND w.id_klienta="+id_klienta+"AND w.id_wizyty="+id_wizyty);
            if(rs.next()) { //jezeli wynik pusty, to metoda zwraca null
                cena =rs.getDouble(1);
            }
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        } 
        if(iloscWizyt > 5)
        {
            cena = 0.9*cena;
        }
        return cena;
    }
}
