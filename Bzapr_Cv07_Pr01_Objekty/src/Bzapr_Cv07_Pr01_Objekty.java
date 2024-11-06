/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

public class Bzapr_Cv07_Pr01_Objekty {

    //TODO
    //ZAPOUZDRIT 1D POLE DO TRIDY STATISTIKA S 2 KONSTRUKTORY(NEW INT[]) A (INT[] VSTUP), VYPISPOLE(), SECISTPOLE(), PRUMERPOLE(); 
    public static void main(String[] args) {
        Vypinac vypinac_1 = new Vypinac();
        vypinac_1.zapni();
        vypinac_1.vypisStav();
        vypinac_1.vypni();
        vypinac_1.vypisStav();
        vypinac_1.prepni();
        vypinac_1.vypisStav();
        
        System.out.println("\n");
        Vypinac vypinac_2 = new Vypinac(false);
        System.out.println(vypinac_2);
        vypinac_2.prepni();
        System.out.println(vypinac_2);
    }
}
