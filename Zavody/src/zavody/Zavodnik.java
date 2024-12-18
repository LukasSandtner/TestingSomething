package zavody;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author st75720
 */
public class Zavodnik {
    private String jmeno;
    private int startovniCislo;
    private double cas;

    public Zavodnik(int cislo, String jmeno, double cas) {
        this.jmeno = jmeno;
        this.startovniCislo = cislo;
        this.cas = cas;
    }

    public Zavodnik(int cislo, String jmeno) {
        this (cislo, jmeno, Double.NaN);
    }

    public String getJmeno() {
        return jmeno;
    }

    public int getStartovniCislo() {
        return startovniCislo;
    }

    public double getCas() {
        return cas;
    }

    public void setCas(double cas) {
        this.cas = cas;
    }
    
    public void resetCas() {
        cas = Double.NaN;
    }
    
    public boolean jeDNS() {
        return (Double.isNaN(cas));
    }

    @Override
    public String toString() {
        return String.format("[%03d] %-15s %s", startovniCislo,
                jmeno, 
                (!jeDNS() ? String.format("%10.2f", cas) : "          DNS"));
    }
}
