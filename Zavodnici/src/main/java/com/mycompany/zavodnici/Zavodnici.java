/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.zavodnici;

import java.io.IOException;

/**
 *
 * @author Lukas
 */
public class Zavodnici {

    public static void main(String[] args) {
        Zaznamy zaznamy = new Zaznamy(10);
//        zaznamy.pridejZaznam(new ZavodnikZaznam("Novak", 120, 130));
//        zaznamy.pridejZaznam(new ZavodnikZaznam("Svoboda", 115, 140));
        try {
            zaznamy.pridejZaznam(new ZavodnikZaznam(null, 110, 125));
        } catch (InvalidZaznamException e) {
            System.err.println("Chyba pri nacteni zaznamu: " + e.getMessage());
        }
        try {
            zaznamy.ctiZaznamy("C:\\Users\\Lukas\\Documents\\NetBeansProjects\\TestingSomething\\Zavodnici\\src\\main\\java\\com\\mycompany\\zavodnici\\cteni.csv");
            zaznamy.zapisNadprumer("C:\\Users\\Lukas\\Documents\\NetBeansProjects\\TestingSomething\\Zavodnici\\src\\main\\java\\com\\mycompany\\zavodnici\\zapis.txt");
        } catch (IOException e) {
            System.err.println("Chyba pri nacteni souboru " + e.getMessage());
        }

        zaznamy.vypisZaznamu();
        ZavodnikZaznam nej = zaznamy.najdiNejrychlejsiho();
        System.out.println("Nej zavodnik: " + nej);
        double prumer = zaznamy.prumernyCas();
        System.out.printf("Prumrny skok: %.2f", prumer);
    }
}
