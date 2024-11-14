/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.soutez;

import java.util.Scanner;

/**
 *
 * @author Lukas
 */
public class Soutez {

    public static void main(String[] args) {
//        Skokan skokan1 = new Skokan("Tomas", 100, 200, 300);
//        Skokan skokan2 = new Skokan("Lexa", 600, 500, 400);
//        Skokan skokan3 = new Skokan("Ozak", 750, 250, 350);
        Skokani soutez = new Skokani(10);
//
//        soutez.pridejSkokana(skokan1);
//        soutez.pridejSkokana(skokan2);
//        soutez.pridejSkokana(skokan3);
//
//        soutez.vypisSkokany();
//
//        System.out.printf("Prumerny skok: %.2f cm\n", soutez.prumernySkok());
//
//        System.out.println(soutez.nejlepsiSkokan() + "\n");
//
//        soutez.OdeberSkokana("Lexa");
//        soutez.vypisSkokany();
        Scanner scan = new Scanner(System.in);
        boolean pravda = true;

        while (pravda) {
            System.out.println("\nZadejte: "
                    + "\n 1. pro vypis"
                    + "\n 2. pridani skokana"
                    + "\n 3. pro odebrani skokana"
                    + "\n 4. pro nejlepsiho skokana"
                    + "\n 5. pro prumerny skok"
                    + "\n 6. pro konec");
            int vstup = scan.nextInt();
            switch (vstup) {
                case 1:
                    soutez.vypisSkokany();
                    break;
                case 2:
                    pridaniSkokana(scan, soutez);
                    break;
                case 3:
                    odebraniSkokana(scan, soutez);
                    break;
                case 4:
                    System.out.println(soutez.nejlepsiSkokan() + "\n");
                    break;
                case 5:
                    double prumer = soutez.prumernySkok();
                    System.out.println("Prumerny skok: " + prumer);
                    break;
                case 6:
                    System.out.println("Konec");
                    pravda = false;
                    break;
                default:
                    System.out.println("Spatna hodnota, zkus to znovu!");
            }
        }
    }

    private static void pridaniSkokana(Scanner scan, Skokani soutez) {
        System.out.println("Zadej jmeno: ");
        String jmeno = scan.next();
        System.out.println("Zadej prvni skok: ");
        int prvni = scan.nextInt();
        System.out.println("Zadej druhy skok: ");
        int druhy = scan.nextInt();
        System.out.println("Zadej treti skok: ");
        int treti = scan.nextInt();
        soutez.pridejSkokana(new Skokan(jmeno, prvni, druhy, treti));
    }

    private static void odebraniSkokana(Scanner scan, Skokani soutez) {
        System.out.println("Zadej jmeno pro odebrani: ");
        String odebraneJmeno = scan.next();
        soutez.OdeberSkokana(odebraneJmeno);
    }
}

