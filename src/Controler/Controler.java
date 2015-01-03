package Controler;

import Model.Kontrahent;
import View.Login;
import View.Subpage1;
import Model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.View;

/**
 *
 * @author Joanna
 */
public class Controler {
    private Login theLogin;
    private Subpage1 theSubpage1;
    private Kontrahent theKontrahent;
    private Model theModel;
    
    public Controler(Login theLogin, Subpage1 theSubpage1, Kontrahent theKontrahent, Model theModel){
        
        this.theLogin = theLogin;
        this.theSubpage1=theSubpage1;
        this.theModel=theModel;
        this.theLogin.setVisible(true);
        this.theSubpage1.setVisible(false);
        this.theKontrahent = theKontrahent;
        this.theLogin.addkeyListener(new keyListener());
    }
    
    public void Dodaj_Kontrahent() // teścik
    {
        Kontrahent osoba  = new Kontrahent();
        osoba.DodajKontrahenta("karolina", "kowalska", "886-444-111", "karolinakowalska@onet.pl", "Krakow", "Mogilska 45", "Hejjjjjj", 323); 
        try {
             theModel.DodajKon(osoba);
         } catch (SQLException ex) {
             Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void Usun_Kontrahent(int id_dane) // teścik
    {
       try {
             theModel.UsunKon(id_dane);
         } catch (SQLException ex) {
             Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
         }  
    }
    
    public void Edytuj_Kontrahent()
    {
        // test
        Kontrahent osoba = new Kontrahent();
        osoba.set_imie("Monika");
        osoba.set_nazwisko("Kowalska");
        osoba.set_telefon("506-781-639");
        osoba.set_email("monika_kowalska@onet.pl");
        osoba.set_miejscowosc("Warszawa");
        osoba.set_ulica("Zakopianska 87/12");
        osoba.set_nazwa_firmy("Siemcia");
        osoba.set_nip(999);
        osoba.id_dane=10;
        // test
        try {
             theModel.EdytujKon(osoba);
         } catch (SQLException ex) {
             Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
         } 
        
    }
    class keyListener implements ActionListener {

       public void actionPerformed(ActionEvent arg0)
       {     
            theLogin.setVisible(false);
            theSubpage1.setVisible(true);
             
       }
    }
}
