/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_sandtner;

/**
 *
 * @author st75720
 */
public class Sedadlo {
    public boolean rezervace;

    public Sedadlo() {
        rezervace = false;
    }
    
    public boolean jeRezervovane(){
        return rezervace;
    }
    
    public void rezervuj(){
        rezervace = true;
    }
    
    public void zrusRezervaci(){
        rezervace = false;
    }
    
    @Override
    public String toString() {
        return rezervace ? "[X]" : "[ ]";
    }
}
