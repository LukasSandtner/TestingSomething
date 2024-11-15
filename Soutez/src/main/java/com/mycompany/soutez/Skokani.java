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

    private Skokan[] skokani;
    private int pocetSkokanu;

    public Skokani(int maxSkokanu) {
        this.skokani = new Skokan[maxSkokanu];
        this.pocetSkokanu = 0;
    }

    public void pridejSkokana(Skokan skokan) {
        if (pocetSkokanu >= skokani.length) {
            System.out.println("Nelze pridat dalsi skokany");
        } else {
            skokani[pocetSkokanu] = skokan;
            pocetSkokanu++;
            System.out.println("Skokan pridan");
        }
    }

    public void OdeberSkokana(String jmeno) {
        for (int i = 0; i < skokani.length; i++) {
            if (skokani[i] != null && skokani[i].getJmeno().equals(jmeno)) {
                for (int j = i; j < skokani.length - 1; j++) {
                    skokani[j] = skokani[j + 1];
                }
                skokani[pocetSkokanu - 1] = null;
                pocetSkokanu--;
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

    public String nejlepsiSkokan() {
        if (pocetSkokanu == 0) {
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
