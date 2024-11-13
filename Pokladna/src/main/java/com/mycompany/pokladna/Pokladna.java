/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pokladna;

import java.util.Scanner;

public class Pokladna {

    //TODO 5 moznosti pro uzivatele, interaktivni menu v cyklu
    public static void main(String[] args) {
//        Polozka produkt1 = new Polozka("Rohlik", 10, (float) 3.50, "Kc");
//        Polozka produkt2 = new Polozka("Houska", 3, (float) 5.50, "Kc");
//        Polozka produkt3 = new Polozka("Chleba", 1, (float) 29.90, "Kc");
////        System.out.println(produkt1.celkovaCena());
////        System.out.println(produkt1.toString());
//        nakup.pridejPolozku(produkt1);
//        nakup.pridejPolozku(produkt2);
//        nakup.pridejPolozku(produkt3);
//        nakup.vypisNakupu();
//        nakup.cenaVseho();
//        nakup.odeberPolozku("dwadw");
//        nakup.vypisNakupu();
        Scanner vstup = new Scanner(System.in);
        Nakup nakup = new Nakup(10);
        System.out.println("***************************\n"
                + "*Vytejte v pokladnim systemu*\n"
                + "***************************");
        boolean opakovani = true;
        while (opakovani) {
            System.out.println("\nZadejte: "
                    + "\n1 pro vypis nakupu"
                    + "\n2 pro pridani polozky"
                    + "\n3 pro odebrani polozky"
                    + "\n4 pro celkovy soucet"
                    + "\n5 pro konec");
            int volba = vstup.nextInt();
            switch (volba) {
                case 1:
                    nakup.vypisNakupu();
                    break;
                case 2:
                    pridaniPolozky(vstup, nakup);
                    break;
                case 3:
                    odebraniPolozky(vstup, nakup);
                    break;
                case 4:
                    nakup.cenaVseho();
                    break;
                case 5:
                    System.out.println("KONEC");
                    opakovani = false;
                default:
                    System.out.println("Spatna hodnota, zkus znovu.");
            }
        }
    }

    private static void odebraniPolozky(Scanner vstup, Nakup nakup) {
        System.out.println("Zadejte nazev polozky: ");
        String nazev = vstup.next();
        nakup.odeberPolozku(nazev);
    }

    private static void pridaniPolozky(Scanner vstup, Nakup nakup) {
        System.out.println("Zadejte nazev: ");
        String nazevPridani = vstup.next();
        System.out.println("Zadejte kusy: ");
        int kusy = vstup.nextInt();
        System.out.println("Zadejte cenu/ks: ");
        float cena = vstup.nextFloat();
        nakup.pridejPolozku(new Polozka(nazevPridani, kusy, cena, "Kc"));
        System.out.printf("Polozka %s pridana", nazevPridani);
    }
}
