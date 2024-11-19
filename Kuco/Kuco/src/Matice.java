
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

    private int[][] matice;

    private Random random = new Random();

    public Matice(int rozmerMatice, int hraniceIntervalu) {
        matice = new int[rozmerMatice][rozmerMatice];

        for (int i = 0; i < rozmerMatice; i++) {
            for (int j = 0; j < rozmerMatice; j++) {
                matice[i][j] = random.nextInt(-hraniceIntervalu, hraniceIntervalu);
            }
        }

    }

    public void vypis() {

        for (int i = 0; i < matice.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matice[0].length; j++) {
                System.out.print(matice[i][j] + " ");
            }
            System.out.println(" |");
        }
    }

    public int maximumNadHD() {
        int maxNadHD = Integer.MIN_VALUE;
        int radekP = 1;

        for (int i = 0; i < matice.length; i++) {
            for (int j = i + radekP; j < matice[0].length; j++) {
                if (matice[i][j] > maxNadHD) {
                    maxNadHD = matice[i][j];
                }

            }
            radekP++;
        }

        if (maxNadHD == 0) {
            return maxNadHD = Integer.MAX_VALUE;
        } else {
            return maxNadHD;
        }
    }

}
