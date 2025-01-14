/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package databaze_statu;

/**
 *
 * @author st75720
 */
public class Databaze_statu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Stat stat1 = new Stat("Polsko", "Varsava", 37950000, 312600);
        Stat stat2 = new Stat("Nemecko", "Berlin", 537950000, 312600);
        Stat stat3 = new Stat("Slovensko", "Osada", 1000, 10);
        Staty poleStatu = new Staty(stat2);
        
        System.out.println("Seznam Satatu");
        System.out.println(stat1.toString());
        System.out.println(stat2.toString());
        System.out.println(stat3.toString());
        System.out.println("-------------");
        System.out.println(poleStatu.maxHustota());
    }
    
}
