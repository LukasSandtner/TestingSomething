/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kafesandtner;

/**
 *
 * @author Lukas
 */
public class Kakao implements ISleva {

    private final String jmeno;
    private final int hmotnost;
    private final double cena;

    public Kakao(String jmeno, int hmotnost, double cena) {
        this.jmeno = jmeno;
        this.hmotnost = hmotnost;
        this.cena = cena;
    }

    public String getJmeno() {
        return jmeno;
    }

    public int getHmotnost() {
        return hmotnost;
    }

    public double getCena() {
        return cena;
    }

    @Override
    public double sleva() {
        return cena - (cena * 0.2);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("Nazev: %s; Hmotnost: %d g; Cena: %.2f Kc", jmeno, hmotnost, cena);
    }
}
