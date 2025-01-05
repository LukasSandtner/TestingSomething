/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kafesandtner;

import java.io.*;

/**
 *
 * @author Lukas
 */
public class NabidkaKafe {

    private final Kafe[] poleKafe;
    private int pocet;

    public NabidkaKafe(int pocet) throws MyException {
        if(pocet <= 0){
            throw new MyException("Pocet musi byt prirozene cislo");
        }
        
        this.poleKafe = new Kafe[pocet];
        this.pocet = 0;
    }

    public void pridejKafe(Kafe kafe) {

        if (pocet < poleKafe.length) {
            poleKafe[pocet] = kafe;
            pocet++;
        } else {
            System.out.println("Pole je plne");
            System.exit(0);
        }
    }

    public void vypisKafe() {
        for (int i = 0; i < pocet; i++) {
            System.out.println(poleKafe[i].toString());

        }
    }

    public Kafe nejlevnejsiNaGram() {
        Kafe nej = poleKafe[0];
        for (int i = 0; i < pocet; i++) {
            if ((nej.getCena() / nej.getHmotnost()) > (poleKafe[i].getCena() / poleKafe[i].getHmotnost())) {
                nej = poleKafe[i];
            }
        }
        return nej;
    }

    public double prumernaCena() {
        double sum = 0.0;
        for (int i = 0; i < pocet; i++) {
            sum += poleKafe[i].getCena();
        }
        return pocet != 0 ? ((double) sum / pocet) : null;
    }

    public void nactiKafe(String nazevSouboru) {
        for (int i = 0; i < pocet; i++) {
            poleKafe[i] = null;
        }
        pocet = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nazevSouboru))) {
            String radek;
            int counter = 1;
            while ((radek = br.readLine()) != null) {
                radek = radek.replace(" ", "");
                radek = radek.replace(",", ".");
                radek = radek.trim();
                String[] data = radek.split(";");
                if (data.length == 3) {
                    String jmeno = data[0];
                    int hmotnost = Integer.parseInt(data[1]);
                    double cena = Double.parseDouble(data[2]);
                    pridejKafe(new Kafe(jmeno, hmotnost, cena));
                } else {
                    System.out.println("Spatne udaje na radku: " + counter);
                }
                counter++;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Chyba pri nacteni souboru: " + e);
        }
    }

    public void zapisKafe(String nazevSouboru) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(nazevSouboru))) {
            br.write("Nadprumerne ceny:");
            br.newLine();
            for (int i = 0; i < pocet; i++) {
                if (poleKafe[i].getCena() > prumernaCena()) {
                    br.write(poleKafe[i].toString(true));
                    br.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Chyba se souborem: " + e);
        }
    }

}
