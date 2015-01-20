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
// paczka
public class Grafik {
    private Wizyty wizyta;
    private Klient klient;
    
    public Grafik(Wizyty wizyta, Klient klient)
    {
        this.wizyta=wizyta;
        this.klient=klient;
    }
    
    public Wizyty get_wizyta()
    {
        return this.wizyta;
    }
    
    public Klient get_klient()
    {
        return this.klient;
    }
}
