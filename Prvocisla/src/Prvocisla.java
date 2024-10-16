
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Lukas
 */
public class Prvocisla {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner vstup = new Scanner(System.in);
        int a;
        do {
            System.out.println("Je to prvocislo?(0 pro konec): ");
            a = vstup.nextInt();
            if (a == 0) break;
            boolean jePrvocislo = true;
            if (a <= 2) {
                jePrvocislo = false;
            }

            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) {
                    jePrvocislo = false;
                }
            }
            if (jePrvocislo) {
                System.out.println(a + " je prvocislo");
            } else {
                System.out.println(a + " neni prvocislo");
            }
        } while (a != 0);
        System.out.println("\nKONEC");
    }

}
