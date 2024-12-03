/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kino_stepanek;

import java.util.Scanner;

/**
 *
 * @author vojta
 */
public class Kino_Stepanek {

    public static void main(String[] args) {
        Kino kino = new Kino(5, 7);
        
        while (true) {            
            Scanner vstup = new Scanner(System.in);
            
            System.out.println("#########REZERVACNI SYSTEM KINA#########");
            System.out.println("Vyber si z jedne varianty:");
            System.out.println("1. Vypis kina");
            System.out.println("2. Rezervace sedadla");
            System.out.println("3. Zruseni rezervace sedadla");
            System.out.println("0. Ukonceni programu");
            String cisla = vstup.nextLine();
                    
            switch (cisla) {
                case "1":
                    kino.vypisSedadla();
                    break;
                    
                case "2":
                    System.out.print("Zadej radek: ");
                    int radek = vstup.nextInt();
                    System.out.print("Zadej misto: ");
                    int misto = vstup.nextInt();
                    vstup.nextLine();
                    kino.rezervujSedadlo(radek, misto);
                    break;
                    
                case "3":
                    System.out.print("Zadej radek: ");
                    int radek1 = vstup.nextInt();
                    System.out.print("Zadej misto: ");
                    int misto1 = vstup.nextInt();
                    vstup.nextLine();
                    kino.zrusrezervaciSedadla(radek1, misto1);
                    break;
                    
                case "0":
                    System.exit(0);
                    break;
            }
            
        }
    }
}
