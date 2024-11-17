/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objektovamatice;

/**
 *
 * @author Lukas
 */
public class Matice {
    private final int[][] maticeA;
    private final int[][] maticeB;
    
    public Matice(int[][] maticeA, int[][] maticeB) {
        this.maticeA = maticeA;
        this.maticeB = maticeB;
    }
    
    public int[][] soucinMatic(){
        int[][] maticeC = new int[maticeA.length][maticeB[0].length];
        if(maticeA[0].length == maticeB.length){
            for (int i = 0; i < maticeA.length; i++) {
                for (int j = 0; j < maticeB[0].length; j++) {
                    for (int k = 0; k < maticeA[0].length; k++) {
                        maticeC[i][j] += maticeA[i][k] * maticeB[k][j];
                    }
                }
            }
        } else {
            System.out.println("Spatne rozmery matic!");
            return null;
        }
        return maticeC;
    }
    
    public void vypis(int[][] maticeC){
        for (int i = 0; i < maticeC.length; i++) {
            System.out.print("[");
            for (int j = 0; j < maticeC[0].length; j++) {
                System.out.print(" " + maticeC[i][j] + " ");
            }
            System.out.println("]");
        }
    }
}
