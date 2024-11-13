/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokladna;

/**
 *
 * @author Lukas
 */
public class Nakup {

    private Polozka[] polePolozek;
    private int aktPocetPolozek = 0;

    public Nakup(int maxPolozek) {
        if (maxPolozek > 0) {
            this.polePolozek = new Polozka[maxPolozek];
        } else {
            this.polePolozek = new Polozka[0];
        }
    }

    public void pridejPolozku(Polozka polozka) {
        if (aktPocetPolozek >= polePolozek.length) {
            System.out.println("\nPlny seznam");
            return;
        }
        if (polozka == null) {
            System.out.println("\nPrazdne");
            return;
        }
        polePolozek[aktPocetPolozek] = polozka;
        aktPocetPolozek++;
    }

    public boolean odeberPolozku(String nazev) {
//        if (nazev.trim() == null) {
//            System.out.println("\nPolozka neexistuje");
//            return false;
//        }
//        if (nazev.isEmpty()) {
//            System.out.println("\nPolozka je prazdna");
//            return false;
//        }
        
        int indexNalezenePolozky = -1;
        for (int i = 0; i < aktPocetPolozek; i++) {
            if(polePolozek[i].getNazev().equals(nazev)){
                indexNalezenePolozky = i;
                break;
            } 
        }
        if(indexNalezenePolozky < 0){
            System.out.println("\nPolozka nenalezena");
            return false;
        }
        for (int i = indexNalezenePolozky; i < aktPocetPolozek; i++) {
            polePolozek[i] = polePolozek[i+1];     
        }
        
        polePolozek[aktPocetPolozek - 1] = null;
        aktPocetPolozek--;
        System.out.printf("Polozka %s odebrana", nazev);
        return true;
    }

    public void cenaVseho() {
        float sum = 0;
        for (Polozka polozka : polePolozek) {
            if (polozka != null) {
                sum += polozka.celkovaCena();
            }
        }
        System.out.printf("Celkova cena: %1.2f\n", sum);
    }

    public void vypisNakupu() {
        System.out.println("-------------\nUCTENKA\n-------------");
        for (Polozka polozka : polePolozek) {
            if (polozka != null) {
                System.out.println(polozka.toString());
            }
        }
        System.out.println("-----------------------------------------------");
    }
}
