/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.strings;

    //hledani indexu znaku a kolikrat (indefOf)
    //rozdeleni retezcu podle deliciho znaku (split)
    //cetnost vsech znaku (i necitelnych) v retezci (lower nebo upper)
public class Strings {

    public static void main(String[] args) {
        String text = "Hello, Wooorld!";
        char searchChar = 'o';
        
        int index = text.indexOf(searchChar);
        int count = 0;
        
        // Počítání výskytů znaku
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == searchChar) {
                count++;
            }
        }

        System.out.println("Prvni vyskyt znaku '" + searchChar + "' je na indexu: " + index);
        System.out.println("Celkovy pocet vyskytu znaku '" + searchChar + "': " + count);
        
        String text2 = "apple,banana,,cherry,dates";
        String delimiter = ",";
        
        // Rozdělení řetězce
        String[] parts = text2.split(delimiter);
        
        System.out.println("Rozdelene casti retezce:");
        for (String part : parts) {
            System.out.println(part);
        }
        
        String text3 = "Hello, World!";
        
        // Normalizace řetězce na malá písmena
        text3 = text3.toLowerCase();
        
        // Pole pro ukládání četností (ASCII má 256 znaků)
        int[] frequencies = new int[256];
        
        // Iterace přes každý znak a počítání
        for (char c : text3.toCharArray()) {
            frequencies[c]++;
        }
        
        System.out.println("cetnost vsech znaku:");
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > 0) {
                System.out.println((char) i + ": " + frequencies[i]);
            }
        }
    }
}


