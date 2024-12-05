/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app_sandtner;

import java.util.Scanner;

/**
 *
 * @author st75720
 */
public class App_Sandtner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Kino kino = new Kino(5, 10);
        Scanner vstup = new Scanner(System.in);
        System.out.println("\n---------REZERVACNI SYSTEM KINA---------");
        while (true) {
            System.out.println("\nVyber si z jedne varianty:");
            System.out.println("0. Ukonceni programu");
            System.out.println("1. Vypis kina");
            System.out.println("2. Rezervace sedadla");
            System.out.println("3. Zruseni rezervace sedadla");
            System.out.println("4: Pocet volnych sedadel");
            System.out.println("5: Pocet rezervovanych sedadel");
            System.out.println("6: Celkovy pocet sedadel");
            String cisla = vstup.nextLine();

            switch (cisla) {
                case "0" -> System.exit(0);

                case "1" -> kino.vypisSedadla();

                case "2" -> rezervace(vstup, kino);

                case "3" -> zruseniRezervace(vstup, kino);

                case "4" -> pocetVolnych(kino);

                case "5" -> pocetRezervovanych(kino);

                case "6" -> celkovyPocet(kino);

                default -> System.out.println("Spatna volba, zadejte znovu.");
            }

        }
    }

    private static void celkovyPocet(Kino kino) {
        int celkem = kino.pocetCelkove();
        System.out.printf("Celkovy pocet: %d", celkem);
    }

    private static void pocetRezervovanych(Kino kino) {
        int rezervovane = kino.pocetRezervovanych();
        System.out.printf("Rezervovanych sedadel: %d", rezervovane);
    }

    private static void pocetVolnych(Kino kino) {
        int volne = kino.pocetVolnych();
        System.out.printf("\nVolnych sedadel: %d", volne);
    }

    private static void zruseniRezervace(Scanner vstup, Kino kino) {
        System.out.print("Zadej radek: ");
        int radek = vstup.nextInt();
        System.out.print("Zadej misto: ");
        int misto = vstup.nextInt();
        vstup.nextLine();
        kino.zrusrezervaciSedadla(radek, misto);
    }

    private static void rezervace(Scanner vstup, Kino kino) {
        System.out.print("Zadej radek: ");
        int radek = vstup.nextInt();
        System.out.print("Zadej misto: ");
        int misto = vstup.nextInt();
        vstup.nextLine();
        kino.rezervujSedadlo(radek, misto);
    }

}
