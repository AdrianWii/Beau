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
public class Zamowienia {
    public int id_zamowienia;
    public int produkty[];
    public int ilosc[];
    
    public Zamowienia(int idz, int pr[], int il[])
    {
        this.id_zamowienia = idz;
        this.produkty = pr;
        this.ilosc = il;    
    }
    
    public Zamowienia getZamowienie(int id)
    {
        Statement stmt;
        ResultSet rs;
        int id_zam;
        int[] pr = new int[100];
        int[] ile = new int[100];
        Zamowienia result = null;
        try {
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT z.id_zamowienia, p.nazwa, ilosc FROM zamowienia z, produkty p WHERE z.id_produktu=p.id_produktu AND z.id_zamownienia="+id);
            id_zam = rs.getInt(1);
            int i=0;
            while(rs.next()) {
                pr[i] = rs.getInt(2);
                ile[i] = rs.getInt(3);
                i++;          
            }
            result = new Zamowienia(id_zam, pr, ile);
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        }
        return result;
    }
    
    public void ZmienIloscProduktu(int id_zam, int id_prod, int ile)
    {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("UPDATE zamowienia SET ilosc=? WHERE id_zamowienia=? AND id_produktu=?");
            stmt.setInt(1, ile);
            stmt.setInt(2, id_zam);
            stmt.setInt(3, id_prod);
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.MESSAGE);
        } 
    }
    
}

