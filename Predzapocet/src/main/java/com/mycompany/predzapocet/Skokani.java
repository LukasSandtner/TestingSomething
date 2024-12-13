/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.predzapocet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Lukas
 */
public class Skokani {

    private Skokan[] skokani;
    private int pocetSkokanu;

    public Skokani(int kapacita) {
        skokani = new Skokan[kapacita];
        pocetSkokanu = 0;
    }

    public void pridejSkokana(Skokan skokan) {
        if (pocetSkokanu < skokani.length) {
            skokani[pocetSkokanu++] = skokan;
        } else {
            System.out.println("Pole je plné, nelze přidat dalšího skokana.");
        }
    }

    public void vypisSkokany() {
        for (int i = 0; i < pocetSkokanu; i++) {
            System.out.println(skokani[i]);
        }
    }

    public double prumernySkok() {
        int celkemSkoku = 0;
        int pocetSkoku = 0;
        for (int i = 0; i < pocetSkokanu; i++) {
            celkemSkoku += skokani[i].getPrvniSkok();
            celkemSkoku += skokani[i].getDruhySkok(); 
            celkemSkoku += skokani[i].getTretiSkok();
            pocetSkoku += 3;
        }
        return pocetSkoku == 0 ? 0 : (double) celkemSkoku / pocetSkoku;
    }

    public Skokan nejlepsiSkokan() {
        Skokan nejlepsi = null;
        int nejlepsiSkok = 0;
        for (int i = 0; i < pocetSkokanu; i++) {
            int delkaNejdelsiho = skokani[i].delkaNejdelsihoSkoku();
            if (delkaNejdelsiho > nejlepsiSkok) {
                nejlepsi = skokani[i];
                nejlepsiSkok = delkaNejdelsiho;
            }
        }
        return nejlepsi;
    }

    public void nactiZeSouboru(String nazevSouboru) {
        try (BufferedReader br = new BufferedReader(new FileReader(nazevSouboru))) {
            String radek;
            while ((radek = br.readLine()) != null) {
                radek = radek.replaceAll(" ", ""); // Odstranění mezer
                String[] data = radek.split(",");
                if (data.length == 4) {
                    String jmeno = data[0];
                    int prvniSkok = Integer.parseInt(data[1]);
                    int druhySkok = Integer.parseInt(data[2]);
                    int tretiSkok = Integer.parseInt(data[3]);
                    Skokan skokan = new Skokan(jmeno, prvniSkok, druhySkok, tretiSkok);
                    pridejSkokana(skokan);
                }
            }
        } catch (IOException e) {
            System.out.println("Chyba při čtení souboru: " + e.getMessage());
        }
    }
}
