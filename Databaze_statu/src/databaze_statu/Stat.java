package databaze_statu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author st75720
 */
public class Stat {
    private final String oznaceniID;
    private final String nazev;
    private final String hlavniMesto;
    private final int pocetObyvatel;
    private final float rozloha;
    private static int cislo = 0;

    public Stat(String nazev, String hlavniMesto, int pocetObyvatel, float rozloha) {
        this.nazev = nazev;
        this.hlavniMesto = hlavniMesto;
        this.pocetObyvatel = pocetObyvatel;
        this.rozloha = rozloha;
        cislo++;
        this.oznaceniID = "Stat_" + cislo;
    }
    
    public String getNazev() {
        return nazev;
    }

    public String getHlavniMesto() {
        return hlavniMesto;
    }
    
    float hustotaObyvatel(){
        return pocetObyvatel / rozloha;
    }

    @Override
    public String toString() {
        return String.format("%s; %s; %s; %d obyvatel; %.2f Km2; Hustota: %.2f;", oznaceniID, nazev, hlavniMesto, pocetObyvatel, rozloha, hustotaObyvatel());
    }
    
    
}
