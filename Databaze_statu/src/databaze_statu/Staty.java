package databaze_statu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author st75720
 */
public class Staty {
    private final Stat[] staty;

    public Staty(Stat stat) {
        this.staty = new Stat[3];
        for (int i = 0; i < staty.length; i++) {
            staty[i] = stat;
        }
    }
    
    public String maxHustota(){
        float max = 0;
        String nazev = "";
        String hl = "";
        for (int i = 0; i < staty.length; i++) {
            if(staty[i].hustotaObyvatel() > max){
                max = staty[i].hustotaObyvatel();
                nazev = staty[i].getNazev();
                hl = staty[i].getHlavniMesto();
            }
        }
        return String.format("Stat s max hustotou %s (%s); Hustota: %.2f obyvatel na km2", nazev, hl, max); 
    }
    
}
