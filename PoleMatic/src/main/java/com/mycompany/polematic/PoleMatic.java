/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.polematic;

/**
 *
 * @author Lukas
 */
public class PoleMatic {
    public static int[] soucetRadku(Matice matice) {
        Radky[] radky = matice.getRadky();
        int[] vysledky = new int[radky.length];
        for (int i = 0; i < radky.length; i++) {
            int sum = 0;
            for (int hodnota : radky[i].getRadek()) {
                sum += hodnota;
            }
            vysledky[i] = sum;
        }
        return vysledky;
    }
    
    public static int celkovySoucetRadku(Matice matice) {
        Radky[] radky = matice.getRadky();
        int vysledky = 0;
        for (int i = 0; i < radky.length; i++) {
            for (int hodnota : radky[i].getRadek()) {
                vysledky += hodnota;
            }
        }
        return vysledky;
    }

    public static int[] soucetSloupcu(Matice matice) {
        Radky[] radky = matice.getRadky();
        int delkaSloupce = radky[0].getRadek().length;
        int[] vysledky = new int[delkaSloupce];

        for (Radky radek : radky) {
            int[] hodnoty = radek.getRadek();
            for (int j = 0; j < hodnoty.length; j++) {
                vysledky[j] += hodnoty[j];
            }
        }
        return vysledky;
    }
}

