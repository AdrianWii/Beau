/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Model.Mail;
import javax.mail.MessagingException;

/**
 *
 * @author Joanna
 */
public class Kontrahent extends Uzytkownik{
    private String nazwa_firmy;
    private int nip;
    
    
    public String get_nazwa_firmy()
    {
        return this.nazwa_firmy;
    }
    public void set_nazwa_firmy(String nnazwa_firmy)
    {
        this.nazwa_firmy=nnazwa_firmy;
    }
    public int get_nip()
    {
        return this.nip;
    }
    public void set_nip(int nnip)
    {
        this.nip=nnip;
    }
    public void DodajKontrahenta(String iimie, String nnazwisko, String ttelefon, String eemail, String mmiejscowosc,
            String uulica, String nnazwa_firmy, int nnip)
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
        if(nnazwa_firmy.length()>0)
            this.set_nazwa_firmy(nnazwa_firmy);
        else
            this.set_nazwa_firmy(null);
        if(nnip!=0)
            this.set_nip(nnip);
        else 
            this.set_nip(0);

    }
    
    public void UsunKontrahenta()
    {
      //...
    }
    
    public void EdytujKontrahenta(String iimie, String nnazwisko, String ttelefon, String eemail, String mmiejscowosc,
            String uulica, String nnazwa_firmy, int nnip)
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
        if(nnazwa_firmy.length()>0)
            this.set_nazwa_firmy(nnazwa_firmy);
        if(nnip!=0)
            this.set_nip(nnip);
    }
    
    public void SkontantujZKontrahentem(String email, String subject, String text)
    {
        try {
            new Mail(email, subject, text).send();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
    


