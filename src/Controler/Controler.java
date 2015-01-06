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
        /*try {
             theModel.DodajKon(osoba);
         } catch (SQLException ex) {
             Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
         }*/
    }
    
    public void Usun_Kontrahent(int id_dane) 
    {
       try {
             theModel.UsunKon(id_dane);
         } catch (SQLException ex) {
             Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
         }  
    }
    
    public void Edytuj_Kontrahent()
    {
         /*try {
             theModel.EdytujKon(osoba);
         } catch (SQLException ex) {
             Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
         }*/ 
        
    }
    class keyListener implements ActionListener {

       public void actionPerformed(ActionEvent arg0)
       {     
            theLogin.setVisible(false);
            theSubpage1.setVisible(true);
             
       }
    }
}
