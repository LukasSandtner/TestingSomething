/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokladna;

/**
 *
 * @author Lukas
 */
public class Polozka {

    private String nazev;
    private int kusy;
    private float cena;
    private String jednotka;

    public Polozka(String nazev, int kusy, float cena, String jednotka) {
        this.nazev = nazev;
        this.kusy = kusy;
        this.cena = cena;
        this.jednotka = jednotka;
    }

    public String getNazev() {
        return nazev;
    }

    public float getKusy() {
        return kusy;
    }

    public float getCena() {
        return cena;
    }

    public String getJednotka() {
        return jednotka;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setKusy(int kusy) {
        this.kusy = kusy;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public void setJednotka(String jednotka) {
        this.jednotka = jednotka;
    }

    public float celkovaCena() {
        return (float) kusy * cena;
    }

    @Override
    public String toString() {
        return String.format("Nazev: %s, Mnozstvi: %d, cena: %1.2f %s, Celkova cena: %1.2f",
                nazev, kusy, cena, jednotka, celkovaCena());
    }

}
