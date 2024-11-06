/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objekty;

/**
 *
 * @author Lukas
 */
public class Statistika {

    private int[] pole;

    public Statistika(int[] vstup) {
        this.pole = vstup;
    }

    public Statistika() {
        this.pole = new int[3];
    }

    public int soucetPole() {
        int soucet = 0;
        for (int i = 0; i < pole.length; i++) {
            soucet += pole[i];
        }
        return soucet;
    }

    public float prumerPole() {
        if (pole.length == 0) {
            return 0;
        }
        return (float) soucetPole() / pole.length;
    }

    public void nahradPrvek(int index, int novaHodnota) {
        if (index > pole.length - 1 || index < 0) {
            System.out.println("Mimo hranice pole!");
        }
        pole[index] = novaHodnota;
    }

    public void vypisPole() {
        System.out.print("Vypis pole: [ ");
        for (int prvek : pole) {
            System.out.print(prvek + " ");
        }
        System.out.println("]");
    }
    
    public void vypisPrvek(int index) {
        System.out.printf("Prvek na indexu %d: %d\n", index, pole[index]);
    }
    
    public void vypisPrvek(int index1, int index2) {
        System.out.printf("Prvek na indexu %d: %d\n", index1, pole[index1]);
        System.out.printf("Prvek na indexu %d: %d\n", index2, pole[index2]);
    }
}
