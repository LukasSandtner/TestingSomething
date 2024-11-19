
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author st75769
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       /* Matice matice1 = new Matice(3, 10);
        matice1.vypis();
        System.out.println("Maximum nad HD je: " + matice1.maximumNadHD());
        */
        Scanner vstup = new Scanner(System.in);
        
        
        System.out.println("Zadejte rozmer ctvercove matice z intervalu <1,10>");
        int rozmer = vstup.nextInt();
        if (rozmer > 11 || rozmer < 0) {
            System.out.println("Chyba, zadej znovu");
        }else{
            Matice matice = new Matice(rozmer, 10);
            matice.vypis();
            System.out.println("Maximalni hodnota prvku nad HD je: " + matice.maximumNadHD());
        }
        
        
    }
    
}
