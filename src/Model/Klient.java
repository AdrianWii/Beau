/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Joanna
 */
public class Klient extends Uzytkownik {
    public void DodajKlienta(String iimie, String nnazwisko, String ttelefon, String eemail, String mmiejscowosc, String uulica)
    {
        if(iimie.length()>0)  
            this.set_imie(iimie);
        else
            this.set_imie(null);
        if(nnazwisko.length()>0)
            this.set_nazwisko(nnazwisko);
        else
            this.set_nazwisko(null);
        if(ttelefon.length()>0)
             this.set_telefon(ttelefon);
        else 
            this.set_telefon(null);
        if(eemail.length()>0)
            this.set_email(eemail);
        else 
            this.set_email(null);
        if(mmiejscowosc.length()>0)
            this.set_miejscowosc(mmiejscowosc);
        else
            this.set_miejscowosc(null);
        if(uulica.length()>0)
            this.set_ulica(uulica);
        else
            this.set_ulica(null);
    }
    
    public void EdytujKlienta(String iimie, String nnazwisko, String ttelefon, String eemail, String mmiejscowosc,
            String uulica)
    {
        if(iimie.length()>0)
            this.set_imie(iimie);
        if(nnazwisko.length()>0)
            this.set_nazwisko(nnazwisko);
        if(ttelefon.length()>0)
             this.set_telefon(ttelefon);
        if(eemail.length()>0)
            this.set_email(eemail);
        if(mmiejscowosc.length()>0)
            this.set_miejscowosc(mmiejscowosc);
        if(uulica.length()>0)
            this.set_ulica(uulica);
    }
    
    public void UsunKlienta()
    {
        //
    }
    
    public void WyswietlKlienta()
    {
        //
    }
}
