/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sandtner;

/**
 *
 * @author st75720
 */
public class Matice {
    private final int[][] matice;
    private final int hraniceIntervalu;

    public Matice(int rozmerMatice, int hraniceIntervalu) {
        this.matice = new int[rozmerMatice][rozmerMatice];
        this.hraniceIntervalu = hraniceIntervalu;
    }
    
    public void naplnMatici(){
        for (int i = 0; i < matice.length; i++) {
            for (int j = 0; j < matice[0].length; j++) {
                matice[i][j] = (int) (Math.random() * (2 * hraniceIntervalu + 1)) - hraniceIntervalu;
            }
        }
    }
    
    public void vypis() {
        for (int[] radky : matice) {
            System.out.print("|");
            for (int sloupce : radky) {
                System.out.printf("%4d", sloupce);
            }
            System.out.println("|");
        }
    }
    
    public int maximumNadHD(){
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < matice.length - 1; i++) {
            for (int j = 1 + i; j < matice[0].length; j++) {
                if(matice[i][j] > max){
                    max = matice[i][j];
                }
            }
        }
        
        if(max == Integer.MIN_VALUE){
            System.out.println("Maximum nad HD nelze urcit");
            return Integer.MIN_VALUE;
        } else {
            System.out.print("Maximum nad HD: ");
        }
       
        return max;
    }
}
