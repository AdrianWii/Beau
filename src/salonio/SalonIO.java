/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package salonio;

import Controler.Controler;
import Model.Kontrahent;
import View.Login;
import View.Subpage1;
import java.io.IOException;

/**
 *
 * @author Joanna
 */
class Display
{
    public void display()
    {
        System.out.println("Pushing test");
    }
}
public class SalonIO {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Display obiekt = new Display();
        obiekt.display();
        
        Login theLogin = new Login();
        Subpage1 theSubpage1 = new Subpage1();
        Kontrahent theKontrahent = new Kontrahent();
        Controler theControler = new Controler(theLogin,theSubpage1,theKontrahent);
    }
    
}
