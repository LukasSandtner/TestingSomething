/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.polematic;

/**
 *
 * @author Lukas
 */
public class App {

    public static void main(String[] args) {
        // Vytvoření jednotlivých řádků matice
        Radky radek1 = new Radky(new int[]{1, 2, 3});
        Radky radek2 = new Radky(new int[]{4, 5, 6});
        Radky radek3 = new Radky(new int[]{7, 8, 10});

        // Vytvoření matice z řádků
        Radky[] poleRadku = new Radky[]{radek1, radek2, radek3};
        Matice matice = new Matice(poleRadku);

        // Vypsání matice
        System.out.println("Matice:");
        matice.printMatice();

        // Výpočet součtu řádků
        int[] soucetRadku = PoleMatic.soucetRadku(matice);
        System.out.println("\nSoucet jednotlivych radku:");
        for (int i = 0; i < soucetRadku.length; i++) {
            System.out.println("Radek " + (i + 1) + ": " + soucetRadku[i]);
        }

        // Výpočet součtu řádků
        int celkovySoucetRadku = PoleMatic.celkovySoucetRadku(matice);
        System.out.println("\nCelkovy soucet radku: \n" + celkovySoucetRadku) ;


        // Výpočet součtu sloupců
        int[] soucetSloupcu = PoleMatic.soucetSloupcu(matice);
        System.out.println("\nSoucet jednotlivych sloupcu:");
        for (int i = 0; i < soucetSloupcu.length; i++) {
            System.out.println("Sloupec " + (i + 1) + ": " + soucetSloupcu[i]);
        }
    }
}
