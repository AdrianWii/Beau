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
public class Uzytkownik {
    private String imie;
    private String nazwisko;
    private String telefon;
    private String email;
    private String miejscowosc;
    private String ulica;
    public int id_dane;
    
    public String get_imie()
    {
    return this.imie;
    }
    public void set_imie(String iimie)
    {
        this.imie=iimie;
    }
    public String get_nazwisko()
    {
        return this.nazwisko;
    }
    public void set_nazwisko(String nnazwisko)
    {
        this.nazwisko=nnazwisko;
    }
    public String get_telefon()
    {
        return this.telefon;
    }
    public void set_telefon(String ttelefon)
    {
        this.telefon=ttelefon;
    }
    public String get_email()
    {
        return this.telefon;
    }
    public void set_email(String eemail)
    {
        this.email=eemail;
    }
    public String get_miejscowosc()
    {
        return this.miejscowosc;
    }
    public void set_miejscowosc(String mmiejscowosc)
    {
        this.miejscowosc=mmiejscowosc;
    }
    public String get_ulica()
    {
        return this.ulica;
    }
    public void set_ulica(String uulica)
    {
        this.ulica=uulica;
    }
    
}
