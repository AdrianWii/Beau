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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angelina
 */
public class Uslugi {
    
    private int id;
    private String nazwa;
    private double cena;
    
    
    public Uslugi(int id, String n, double c)
    {
        this.cena=c;
        this.nazwa=n;
        this.id=id;
    }
    
    public String getNazwa()
    {
        return this.nazwa;
    }
    public void setNazwa(String n)
    {
        this.nazwa = n;
    }
    public double getCena()
    {
        return this.cena;
    }
    public void setCena(double c)
    {
        this.cena = c;
    }
    public int getId()
    {
        return this.id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    
    public void DodajUsluge()
    {
        PreparedStatement stmt;
        try
        {
            stmt = conn.prepareStatement("INSERT INTO uslugi(nazwa, cena) VALUES(?, ?)");
            stmt.setString(1, nazwa);
            stmt.setDouble(2, cena);
        }catch(SQLException e){
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }
    
    public Uslugi getUsluga(int indeks)
    {
        Statement stmt;
        ResultSet rs;
        Uslugi result = null;
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT id_uslugi, nazwa, cena FROM uslugi WHERE  id_uslugi=" + id + " LIMIT 1");
            if(rs.next()) { //jezeli wynik pusty, to metoda zwraca null
                result = new Uslugi(rs.getInt(1), rs.getString(2), rs.getDouble(3) );
            }
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
        return result;
    }
    
    public List<Uslugi> getAll()
    {
        Statement stmt;
        ResultSet rs;
        List result = new ArrayList<Uslugi>();
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT id_uslugi, nazwa, cena FROM uslugi");
            while(rs.next()) {
                result.add( new Uslugi(rs.getInt(1), rs.getString(2), rs.getDouble(3) )) ;
            }
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
        return result;
    }
    
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
