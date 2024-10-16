
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Lukas
 */
public class Ciferny_soucet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner vstup = new Scanner(System.in);
        System.out.println("Napiste cislo: ");
        String str = vstup.nextLine();

        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                sum += digit;
            }
        }
        System.out.println("ciferny soucet je: " + sum);
    }

}
