/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bzapr_cv10_pr01_rozhrani;

/**
 *
 * @author st75720
 */
public class Faktura implements ISplatne{
    private String kodZbozi;
    private int mnozstvi;
    private String popisZbozi;
    private double jednotkovaCena;

    public Faktura(String kodZbozi, int mnozstvi, String popisZbozi, double jednotkovaCena) {
        this.kodZbozi = kodZbozi;
        this.mnozstvi = mnozstvi;
        this.popisZbozi = popisZbozi;
        this.jednotkovaCena = jednotkovaCena;
    }

    public String getKodZbozi() {
        return kodZbozi;
    }

    public int getMnozstvi() {
        return mnozstvi;
    }

    public String getPopisZbozi() {
        return popisZbozi;
    }

    public double getJednotkovaCena() {
        return jednotkovaCena;
    }

    public void setKodZbozi(String kodZbozi) {
        this.kodZbozi = kodZbozi;
    }

    public void setMnozstvi(short mnozstvi) {
        this.mnozstvi = mnozstvi;
    }

    public void setPopisZbozi(String popisZbozi) {
        this.popisZbozi = popisZbozi;
    }

    public void setJednotkovaCena(double jednotkovaCena) {
        this.jednotkovaCena = jednotkovaCena;
    }
    
    @Override
    public double zaplatitCasktu(){
        return jednotkovaCena * mnozstvi;
    }
    
    @Override
    public String toString() {
      return String.format("Kód: %s, Mnozstvi: %d, Popis: %s, Cena/kus: %f", kodZbozi, mnozstvi, popisZbozi, jednotkovaCena);
    }
    
    
}
