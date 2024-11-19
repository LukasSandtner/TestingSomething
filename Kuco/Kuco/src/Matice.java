
import java.util.Arrays;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author st75769
 */
public class Matice {

    private final int[][] matice;

    private final Random random = new Random();

    private final int hraniceIntervalu; 
            
    public Matice(int rozmerMatice, int hraniceIntervalu) {
        this.matice = new int[rozmerMatice][rozmerMatice];
        this.hraniceIntervalu = hraniceIntervalu;
    }
    
    public void napln(){
        for (int i = 0; i < matice.length; i++) {
            for (int j = 0; j < matice[0].length; j++) {
                matice[i][j] = random.nextInt(-hraniceIntervalu, hraniceIntervalu + 1);
            }
        }
    }
        
    public void vypis() {

        for (int i = 0; i < matice.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matice[0].length; j++) {
                System.out.printf("%03d ", matice[i][j]);
            }
            System.out.println("|");
        }
    }

    public int maximumNadHD() {
        int maxNadHD = Integer.MIN_VALUE;

        for (int i = 0; i < matice.length - 1; i++) {
            for (int j = i + 1; j < matice[0].length; j++) {
                if (matice[i][j] > maxNadHD) {
                    maxNadHD = matice[i][j];
                }

            }
        }

        if (maxNadHD == 0) {
            return maxNadHD = Integer.MAX_VALUE;
        } else {
            return maxNadHD;
        }
    }

}
