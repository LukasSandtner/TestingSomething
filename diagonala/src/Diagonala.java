
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Lukas
 */
public class Diagonala {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int pocetPrvku = 5;
        int[][] pole = new int[pocetPrvku][pocetPrvku];

        vypisPole(pocetPrvku, pole);

        soucetDiagonalyZleva(pocetPrvku, pole);

        soucetDiagonalyZprava(pocetPrvku, pole);

        dalsiSoucetDiagonalyZleva(pocetPrvku, pole);
        
        dalsiSoucetDiagonalyZprava(pocetPrvku, pole);
    }

    private static void vypisPole(int pocetPrvku, int[][] pole) {
        System.out.println("Vypis pole: \n-----------");
        for (int i = 0; i < pocetPrvku; i++) {
            System.out.print("{ ");
            for (int j = 0; j < pole[i].length; j++) {
                pole[i][j] = (int) (Math.random() * 5) + 1;
                System.out.print(pole[i][j] + " ");
            }
            System.out.println("},");
        }

    }

    private static void soucetDiagonalyZleva(int pocetPrvku, int[][] pole) {
        int sum = 0;
        System.out.println("\nSoucet diagonaly zleva: \n---------------------");
        for (int i = 0; i < pocetPrvku; i++) {
            for (int j = i; j < i + 1; j++) {
                sum += pole[i][j];
                //System.out.println(sum);
            }
        }
        System.out.println(sum);
    }

    private static void soucetDiagonalyZprava(int pocetPrvku, int[][] pole) {
        int sum = 0;
        System.out.println("\nSoucet diagonaly zprava: \n--------------------");
        for (int i = pocetPrvku - 1; i >= 0; i--) {
            for (int j = i; j > i - 1; j--) {
                sum += pole[i][j];
                //System.out.println(sum);
            }
        }
        System.out.println(sum);
    }

    private static void dalsiSoucetDiagonalyZleva(int pocetPrvku, int[][] pole) {
        int sum = 0;
        System.out.println("\nDalsi soucet diagonaly zleva: \n---------------");
        for (int i = 0; i < pocetPrvku; i++) {
            for (int j = pole[i].length - 1 - i; j > pole[i].length - 2 - i; j--) {
                sum += pole[i][j];
                //System.out.println(sum);
            }
        }
        System.out.println(sum);
    }

    private static void dalsiSoucetDiagonalyZprava(int pocetPrvku, int[][] pole) {
        int sum = 0;
        System.out.println("\nDalsi soucet diagonaly zprava: \n--------------");
        for (int i = pocetPrvku - 1; i >= 0; i--) {
            for (int j = pole[i].length - i - 1; j < pole[i].length - i; j++) {
                sum += pole[i][j];
                System.out.println(sum);
            }
        }
        System.out.println(sum);
    }
}
