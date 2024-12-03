/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kino_stepanek;

/**
 *
 * @author vojta
 */
public class Kino {
    private final Sedadlo[][] sedadla;

    public Kino(int pocetRadku, int pocetSloupcu) {
        sedadla = new Sedadlo[pocetRadku][pocetSloupcu];
        for (int i = 0; i < pocetRadku; i++) {
            for (int j = 0; j < pocetSloupcu; j++) {
                sedadla[i][j] = new Sedadlo(); 
            }
        }
    }
    
    public void vypisSedadla(){
        for (int i = 0; i < sedadla.length; i++) {
            for (int j = 0; j < sedadla[i].length; j++) {
                System.out.print(sedadla[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public boolean rezervujSedadlo(int rada, int pozice){
        if (rada >= 0 && rada < sedadla.length && pozice >= 0) {
            if (!sedadla[rada - 1][pozice - 1].jeRezervovane()) {
                sedadla[rada - 1][pozice - 1].rezervuj();
                return true;
            }
        }
        return false;
    }
    
    public boolean zrusrezervaciSedadla(int rada, int pozice){
        if (rada >= 0 && rada < sedadla.length && pozice >= 0) {
            if (sedadla[rada - 1][pozice - 1].jeRezervovane()) {
                sedadla[rada - 1][pozice - 1].zrusRezervaci();
                return true;
            }
        }
        return false;
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
        for (Sedadlo[] rada : sedadla) {
            for (Sedadlo sedadlo : rada) {
                pocet++;
            }
        }
        return pocet;
    }
    
    
}
