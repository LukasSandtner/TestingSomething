/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bzapr_cv10_pr01_rozhrani;

/**
 *
 * @author st75720
 */
public class Zamestnanec implements ISplatne{
    private String jmeno;
    private int id;
    private double mesicniPlat;

    public Zamestnanec(String jmeno, int id, double mesicniPlat) {
        this.jmeno = jmeno;
        this.id = id;
        this.mesicniPlat = mesicniPlat;
    }

    public String getJmeno() {
        return jmeno;
    }

    public int getId() {
        return id;
    }

    public double getMesicniPlat() {
        return mesicniPlat;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMesicniPlat(double mesicniPlat) {
        this.mesicniPlat = mesicniPlat;
    }
    
    @Override
    public double zaplatitCasktu(){
        return getMesicniPlat();
    }
    
    @Override
    public String toString() {
      return String.format("Jmeno: %s, ID: %d, Plat: %f", jmeno, id, mesicniPlat);
    }
    
}
