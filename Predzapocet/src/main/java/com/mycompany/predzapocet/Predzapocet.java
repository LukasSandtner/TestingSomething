/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.predzapocet;

/**
 *
 * @author Lukas
 */
public class Predzapocet {

    public static void main(String[] args) {
        Skokani skokani = new Skokani(100); // Maximální kapacita pole
        skokani.nactiZeSouboru("pokusy.txt");

        System.out.println("Všichni skokani:");
        skokani.vypisSkokany();

        System.out.printf("Průměrná délka skoku: %.2f cm\n", skokani.prumernySkok());

        Skokan nejlepsi = skokani.nejlepsiSkokan();
        if (nejlepsi != null) {
            System.out.println("Nejlepší skokan: " + nejlepsi.getJmeno() + " s nejlepším skokem: " + nejlepsi.delkaNejdelsihoSkoku() + " cm");
        } else {
            System.out.println("Nebyl nalezen žádný skokan.");
        }
    }
}
