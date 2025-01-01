/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zavodnici;

/**
 *
 * @author Lukas
 */
import java.io.*;

public class Zaznamy {

    private ZavodnikZaznam[] zaznamy;
    private int pocet;

    public Zaznamy(int kapacita) {
        this.zaznamy = new ZavodnikZaznam[kapacita];
        this.pocet = 0;
    }

    public void pridejZaznam(ZavodnikZaznam zavodnik) {
        if (pocet <= zaznamy.length) {
            zaznamy[pocet++] = zavodnik;
        } else {
            System.out.println("Pole je plne!");
        }
    }
    
    public void odeberZaznam(String jmeno){
        for (int i = 0; i < pocet; i++) {
            if(zaznamy[i].getJmeno().equals(jmeno)){
                for (int j = i; j < pocet; j++) {
                    zaznamy[j] = zaznamy[j + 1];
                    pocet--;
                }
            }
            
        }
    }

    public void vypisZaznamu() {
        for (ZavodnikZaznam zavodnik : zaznamy) {
            if (zavodnik != null) {
                System.out.println(zavodnik);
            }
        }
    }

    public double prumernyCas() {
        double sum = 0.0;
        for (int i = 0; i < pocet; i++) {
            sum += zaznamy[i].dejLepsiCas();
        }
        return (double) pocet > 0 ? sum / pocet : Integer.MIN_VALUE;
    }

    public ZavodnikZaznam najdiNejrychlejsiho() {
        ZavodnikZaznam nej = zaznamy[0];
        for (int i = 1; i < pocet; i++) {
            if (zaznamy[i].dejLepsiCas() <= nej.dejLepsiCas()) {
                nej = zaznamy[i];
            }
        }
        return nej;
    }

    public void ctiZaznamy(String soubor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(soubor))) {
            String radek;
            while ((radek = br.readLine()) != null) {
                radek = radek.trim();
                radek = radek.replace(" ", "");
                String[] data = radek.split(";");
                if (data.length == 3) {
                    String jmeno = data[0];
                    int prvniCas = Integer.parseInt(data[1]);
                    int druhyCas = Integer.parseInt(data[2]);
                    try {
                        pridejZaznam(new ZavodnikZaznam(jmeno, prvniCas, druhyCas));
                    } catch (InvalidZaznamException e) {
                        System.err.println("Chyba pri nacteni zaznamu" + e.getMessage());
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Chyba pri cteni souboru: " + e.getMessage());
        }
    }

    public void zapisNadprumer(String soubor) throws IOException {
        double prumer = prumernyCas();
        BufferedWriter br = null;
        try {
            br = new BufferedWriter(new FileWriter(soubor));
            br.write("Nadprumerni: ");
            br.newLine();
            for (int i = 0; i < pocet; i++) {
                if (prumer > zaznamy[i].dejLepsiCas()) {
                    br.write(zaznamy[i].toString());
                    br.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Chyba pri zapisu souboru: " + e.getMessage());
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
}
