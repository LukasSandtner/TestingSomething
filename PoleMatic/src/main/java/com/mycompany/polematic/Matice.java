/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.polematic;

/**
 *
 * @author Lukas
 */
public class Matice {
    private Radky[] radky;

    public Matice(Radky[] radky) {
        this.radky = radky;
    }

    public Radky[] getRadky() {
        return radky;
    }

    public void setRadky(Radky[] radky) {
        this.radky = radky;
    }

    public void printMatice() {
        for (Radky radek : radky) {
            System.out.println(radek.toString());
        }
    }
}

