/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_sandtner;

/**
 *
 * @author st75720
 */
public class Kino {
     private final Sedadlo[][] sedadla;

    public Kino(int pocetRadku, int pocetSloupcu) {
        this.sedadla = new Sedadlo[pocetRadku][pocetSloupcu];
        for (int i = 0; i < pocetRadku; i++) {
            for (int j = 0; j < pocetSloupcu; j++) {
                sedadla[i][j] = new Sedadlo(); 
            }
        }
    }
    
    public void vypisSedadla(){
         for (Sedadlo[] radek : sedadla) {
             for (Sedadlo sedadlo : radek) {
                 System.out.print(sedadlo.toString() + " ");
             }
             System.out.println();
         }
    }
    
    public void rezervujSedadlo(int rada, int pozice){
        if ((rada - 1) >= 0 && (rada - 1) < sedadla.length && (pozice - 1) >=0){
            if (!sedadla[rada - 1][pozice - 1].jeRezervovane()) {
                sedadla[rada - 1][pozice - 1].rezervuj();
                System.out.printf("\nSedadlo v rade %d, pozice %d"
                        + " bylo uspesne rezervovano.", rada, pozice);
            } else {
                System.out.printf("\nSedadlo v rade %d, pozice %d "
                        + "je jiz rezervovano.", rada, pozice);
            }
        } else {
            System.out.println("Sedadlo neexistuje.");
        }
    }
    
    public void zrusrezervaciSedadla(int rada, int pozice){
        if ((rada - 1) >= 0 && (rada - 1) < sedadla.length && (pozice - 1) >=0){
            if (sedadla[rada - 1][pozice - 1].jeRezervovane()) {
                sedadla[rada - 1][pozice - 1].zrusRezervaci();
                System.out.printf("\nSedadlo v rade %d, pozice %d "
                        + "bylo uspesne uvolneno.", rada, pozice);
            } else {
                System.out.printf("\nSedadlo v rade %d, pozice %d"
                        + " je jiz uvolneno.", rada, pozice);
            }
        } else {
            System.out.println("Sedadlo neexistuje.");
        }
    }
    
    public int pocetRezervovanych(){
        int pocet = 0;
        for (Sedadlo[] rada : sedadla) {
            for (Sedadlo sedadlo : rada) {
                if (sedadlo.jeRezervovane()) {
                    pocet++;
                }
            }
        }
        return pocet;
    }
    
    public int pocetVolnych(){
        int pocet = 0;
        for (Sedadlo[] rada : sedadla) {
            for (Sedadlo sedadlo : rada) {
                if (!sedadlo.jeRezervovane()) {
                    pocet++;
                }
            }
        }
        return pocet;
    }
    
    public int pocetCelkove(){
        int pocet = 0;
        for (int i = 0; i < sedadla.length; i++) {
            for (int j = 0; j < sedadla[i].length; j++) {
                pocet++;                
            }    
        }
        return pocet;
    }
}
