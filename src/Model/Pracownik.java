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
public class Pracownik extends Uzytkownik {
    private String login;
    private String haslo;
    
    public String get_login()
    {
        return this.haslo;
    }
    public void set_login(String llogin)
    {
        this.login=llogin;
    }
    public String get_haslo()
    {
        return this.haslo;
    }
    public void set_haslo(String hhaslo)
    {
        this.haslo=hhaslo;
    }
    public void DodajPracownika(String iimie, String nnazwisko, String ttelefon, String eemail, String mmiejscowosc,
            String uulica, String llogin, String hhaslo)
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
        if(llogin.length()>0)
            this.set_login(llogin);
        else
            this.set_login(null);
        if(hhaslo.length()>0)
            this.set_haslo(hhaslo);
        else
            this.set_haslo(null);  
    }
    
    public void UsunPracownika()
    {
        //
    }
    
    public static Pracownik Zaloguj(String iimie, String nnazwisko, String ttelefon, String eemail, String mmiejscowosc,
            String uulica, String llogin, String hhaslo, int id_dane)
    {
        Pracownik osoba=new Pracownik();
        osoba.set_imie(iimie);
        osoba.set_nazwisko(nnazwisko);
        osoba.set_telefon(ttelefon);
        osoba.set_email(eemail);
        osoba.set_miejscowosc(mmiejscowosc);
        osoba.set_ulica(uulica);
        osoba.set_login(llogin);
        osoba.set_haslo(hhaslo);
        osoba.id_dane=id_dane;
        return osoba;
    }
    
    public void Wyloguj()
    {
        //
    }
    
    public void WyswietlGrafik()
    {
        //
    }
}
