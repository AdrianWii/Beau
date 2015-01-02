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
    public Kontrahent DodajKontrahenta(String iimie, String nnazwisko, String ttelefon, String eemail, String mmiejscowosc,
            String uulica, String nnazwa_firmy, int nnip)
    {
        Kontrahent nowy = new Kontrahent();
        if(iimie.length()>0)
            nowy.set_imie(iimie);
        else
            nowy.set_imie(null);
        if(nnazwisko.length()>0)
            nowy.set_nazwisko(nnazwisko);
        else
            nowy.set_nazwisko(null);
        if(ttelefon.length()>0)
             nowy.set_telefon(ttelefon);
        else 
            nowy.set_telefon(null);
        if(eemail.length()>0)
            nowy.set_email(eemail);
        else 
            nowy.set_email(null);
        if(mmiejscowosc.length()>0)
            nowy.set_miejscowosc(mmiejscowosc);
        else
            nowy.set_miejscowosc(null);
        if(uulica.length()>0)
            nowy.set_ulica(uulica);
        else
            nowy.set_ulica(null);
        if(nnazwa_firmy.length()>0)
            nowy.set_nazwa_firmy(nnazwa_firmy);
        else
            nowy.set_nazwa_firmy(null);
        if(nnip!=0)
            nowy.set_nip(nnip);
        else 
            nowy.set_nip(0);
        
        return nowy;
    }
 }

