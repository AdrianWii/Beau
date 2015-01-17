/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Handler.ExceptionHandler;
import static Model.Uslugi.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author angelina
 */
public class Produkty {
    public int id_produktu;
    public int id_typ;
    public int id_kontr;
    public String nazwa;
    public int ilosc;
    public double cena;
    public int min_ilosc;
    
    public Produkty(int idp, int idt, int idk, String n, int il, double c, int minil)
    {
        this.id_produktu = idp;
        this.id_typ = idt;
        this.id_kontr = idk;
        this.nazwa = n;
        this.ilosc = il;
        this.cena = c;
        this.min_ilosc = minil;
    }
    
    public void DodajProdukt()
    {
        PreparedStatement stmt;
        try
        {
            stmt = conn.prepareStatement("INSERT INTO produkty(id_typ, id_kontr, nazwa, ilosc, cena, min_ilosc) VALUES(?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, id_typ);
            stmt.setInt(2, id_kontr);
            stmt.setString(3, nazwa);
            stmt.setInt(4, ilosc);
            stmt.setDouble(5, cena);
            stmt.setInt(6, min_ilosc);
        }catch(SQLException e){
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
    }

    public String getName(int id)
    {
        Statement stmt;
        ResultSet rs;
        String result = null;
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT nazwa FROM produkty WHERE  id_produktu=" + id + " LIMIT 1");
            if(rs.next()) { //jezeli wynik pusty, to metoda zwraca null
                result = rs.getString(1);
            }
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
        return result;
    }
    
    public Produkty getProdukt(int id)
    {
        Statement stmt;
        ResultSet rs;
        Produkty result = null;
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT id_produktu, id_typ, id_kontr, nazwa, ilosc, cena, min_ilosc FROM produkty WHERE  id_produktu=" + id + " LIMIT 1");
            if(rs.next()) { //jezeli wynik pusty, to metoda zwraca null
                result = new Produkty(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getInt(7) );
            }
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
        return result;
    }
}
