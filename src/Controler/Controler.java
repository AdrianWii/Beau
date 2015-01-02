package Controler;

import Model.Kontrahent;
import View.Login;
import View.Subpage1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.View;

/**
 *
 * @author Joanna
 */
public class Controler {
    private Login theLogin;
    private Subpage1 theSubpage1;
    private Kontrahent theKontrahent;
    
    public Controler(Login theLogin, Subpage1 theSubpage1, Kontrahent theKontrahent){
        
        this.theLogin = theLogin;
        this.theSubpage1=theSubpage1;
        this.theLogin.setVisible(true);
        this.theSubpage1.setVisible(false);
        this.theKontrahent = theKontrahent;
        this.theLogin.addkeyListener(new keyListener());
    }
    
    class keyListener implements ActionListener {

       public void actionPerformed(ActionEvent arg0)
       {          
             theSubpage1.setVisible(true);
             
       }
    }
}
