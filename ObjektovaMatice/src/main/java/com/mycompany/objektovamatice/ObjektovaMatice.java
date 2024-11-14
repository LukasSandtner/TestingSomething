/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.objektovamatice;

/**
 *
 * @author Lukas
 */
public class ObjektovaMatice {

    public static void main(String[] args) {
        int[][] maticeA = {{2,3},{4,5},{6,7}};
        int[][] maticeB = {{1,2,3},{4,5,6}};
        Matice matice = new Matice(maticeA, maticeB);
        System.out.println("Matice A:");
        matice.vypis(maticeA);
        System.out.println("Matice B:");
        matice.vypis(maticeB);
        System.out.println("Matice C:");
        int[][] maticeC = matice.soucinMatic();
        matice.vypis(maticeC);
    }
}
