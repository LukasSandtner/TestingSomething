/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sandtner;

import java.util.Scanner;

/**
 *
 * @author st75720
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner vstup = new Scanner(System.in);
        
        while (true) {
            System.out.println("Zadej rozmer ctvercove matice: ");
            int rozmer = vstup.nextInt();
            if (rozmer >= 1 && rozmer <= 10) {
                Matice matrix = new Matice(rozmer, 10);
                matrix.naplnMatici();
                matrix.vypis();
                int maximum = matrix.maximumNadHD();
                if(maximum != Integer.MIN_VALUE){
                    System.out.printf("%d\n", maximum);
                }
                break;
            } else {
                System.out.println("Chyba, zadej znovu.");
            }
        }
    }

}
