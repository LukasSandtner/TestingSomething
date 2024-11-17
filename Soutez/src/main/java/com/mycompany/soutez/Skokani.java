package com.mycompany.soutez;

import com.mycompany.soutez.Skokan;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Lukas
 */
public class Skokani {

    private final Skokan[] skokani;
    private int aktPocetSkokanu;

    public Skokani(int maxSkokanu) {
        this.skokani = new Skokan[maxSkokanu];
        this.aktPocetSkokanu = 0;
    }

    public void pridejSkokana(Skokan skokan) {
        if (aktPocetSkokanu >= skokani.length) {
            System.out.println("Nelze pridat dalsi skokany");
        } else {
            skokani[aktPocetSkokanu] = skokan;
            aktPocetSkokanu++;
            System.out.println("Skokan pridan");
        }
    }

    public void OdeberSkokana(String jmeno) {
        for (int i = 0; i < skokani.length; i++) {
            if (skokani[i] != null && skokani[i].getJmeno().equals(jmeno)) {
                for (int j = i; j < aktPocetSkokanu; j++) {
                    skokani[j] = skokani[j + 1];
                }
                skokani[aktPocetSkokanu - 1] = null;
                aktPocetSkokanu--;
                System.out.println("Skokan odebran");
            }
        }
    }

    public void vypisSkokany() {
        System.out.println("Seznam skokanu:"
                + "\n--------------------------------------------------------");
        for (Skokan skokan : skokani) {
            if (skokan != null) {
                System.out.println(skokan.toString());
                System.out.println("-----------------------------------------");
            }
        }
    }

    public double prumernySkok() {
        int pocetSkoku = 0;
        int soucetSkoku = 0;

        for (Skokan skokan : skokani) {
            if (skokan != null) {
                soucetSkoku += skokan.getPrvniSkok();
                soucetSkoku += skokan.getDruhySkok();
                soucetSkoku += skokan.getTretiSkok();
                pocetSkoku += 3;
            }
        }
        if (pocetSkoku == 0) {
            return 0;
        }
        return (double) soucetSkoku / pocetSkoku;
    }

    public float prumerSkokana(String jmeno) {
        int suma = 0;
        for (int i = 0; i < skokani.length; i++) {
            if((skokani[i] != null) && (skokani[i].getJmeno().equals(jmeno))){
                suma = skokani[i].getPrvniSkok() 
                       + skokani[i].getDruhySkok()
                       + skokani[i].getTretiSkok();
            }            
        }
        return (float) suma / 3;
    }

    public String nejlepsiSkokan() {
        if (aktPocetSkokanu == 0) {
            return null;
        }
        Skokan nejlepsi = skokani[0];

        for (Skokan skokan : skokani) {
            if (skokan != null
                    && (skokan.delkaNejdelsihoSkoku() > nejlepsi.delkaNejdelsihoSkoku())) {
                nejlepsi = skokan;
            }
        }
        return String.format("Nejlepsi skokan: %s", nejlepsi.getJmeno());
    }

}
