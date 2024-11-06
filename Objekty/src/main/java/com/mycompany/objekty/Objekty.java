/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.objekty;

import java.util.Scanner;

/**
 *
 * @author Lukas
 */
public class Objekty {

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 6};
        Scanner vstup = new Scanner(System.in);
        Statistika st1 = new Statistika(data);
        st1.vypisPole();
        System.out.printf("Prumer: %.2f\n", st1.prumerPole());
        System.out.println("Soucet: " + st1.soucetPole());
        System.out.println("Zadej index a hodnotu pro nahrazeni prvku: ");
        int index = vstup.nextInt();
        int novaHodnota = vstup.nextInt();
        st1.nahradPrvek(index, novaHodnota);
        st1.vypisPole();
        System.out.println("Zadej index1 a index2 ");
        int index1 = vstup.nextInt();
        int index2 = vstup.nextInt();
        st1.vypisPrvek(index1);
        System.out.println("");
        st1.vypisPrvek(index1, index2);
        
        Statistika st2 = new Statistika();
        st2.vypisPole();
        System.out.println("Pole je ted prazdne!");
    }
}
