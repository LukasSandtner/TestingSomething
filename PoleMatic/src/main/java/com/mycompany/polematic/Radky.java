/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.polematic;

/**
 *
 * @author Lukas
 */
public class Radky {
    private int[] radek;

    public Radky(int[] radek) {
        this.radek = radek;
    }

    public int[] getRadek() {
        return radek;
    }

    public void setRadek(int[] radek) {
        this.radek = radek;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : radek) {
            sb.append("|").append(String.format("%02d", i)).append("|");
        }
        return sb.toString().trim();
    }
}

