/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Vypinac {

    private boolean poloha = false;
    
    //PRETIZENI KONSTRUKTORU
    public Vypinac(){
        
    }
    
    public Vypinac(boolean poloha){
        this.poloha = poloha;
    }

    public void zapni() {
        poloha = true;
    }

    public void vypni() {
        poloha = false;
    }

    public void prepni() {
        poloha = !poloha;
    }

    public void vypisStav() {
        System.out.printf("Stav: %s\n", (poloha)? "ZAPNUTO" : "VYPNUTO");
    }
    
    //PREKRYTI METODY Object: toString();
    @Override //POMOC PRO MĚ
    public String toString() {
        return String.format("Stav: %s\n", 
                            (poloha)? "ZAPNUTO" : "VYPNUTO");
    }
}
