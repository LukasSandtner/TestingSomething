/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.kafesandtner;

/**
 *
 * @author Lukas
 */
public class KafeSandtner {

    public static void main(String[] args) {
        
        final int CONST = 10;
        
        try {
            NabidkaKafe nabidka = new NabidkaKafe(CONST);

            Kafe kafe1 = new Kafe("Jihlava", 200, 300);
            Kafe kafe2 = new Kafe("Nestle", 500, 800);
            Kafe kafe3 = new Kafe("Clever", 350, 200);

            nabidka.pridejKafe(kafe1);
            nabidka.pridejKafe(kafe2);
            nabidka.pridejKafe(kafe3);

            Kakao kakao1 = new Kakao("Granko", 200, 300);

            double sleva1 = kakao1.sleva();
            double sleva2 = kafe1.sleva();
            StringBuilder sb = new StringBuilder();
            sb.append("Sleva: ");
            sb.append(sleva1);
            sb.append("; ");
            sb.append(sleva2);
            System.out.println(sb);

            nabidka.vypisKafe();

//        Kafe nej = nabidka.nejlevnejsiNaGram();
//        System.out.println("Nejlevnejsi na gram je: " + nej.toString());
//
//        double prumer = nabidka.prumernaCena();
//        System.out.printf("Prumer ceny je: %.2f Kc\n", prumer);
            nabidka.nactiKafe("C:\\Users\\Lukas\\Documents\\NetBeansProjects\\TestingSomething\\KafeSandtner\\src\\main\\java\\com\\mycompany\\kafesandtner\\nacist.txt");
            nabidka.zapisKafe("C:\\Users\\Lukas\\Documents\\NetBeansProjects\\TestingSomething\\KafeSandtner\\src\\main\\java\\com\\mycompany\\kafesandtner\\zapis.txt");

            nabidka.vypisKafe();

            Kafe nej = nabidka.nejlevnejsiNaGram();
            System.out.println("Nejlevnejsi na gram je: " + nej.toString());

            double prumer = nabidka.prumernaCena();
            System.out.printf("Prumer ceny je: %.2f Kc\n", prumer);

        } catch (MyException e) {
            System.out.println("Chyba s polem: " + e);
        }

    }
}
