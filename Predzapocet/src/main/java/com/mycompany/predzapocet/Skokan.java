/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.predzapocet;

/**
 *
 * @author Lukas
 */
public class Skokan {
     private final String jmeno;
    private final int prvniSkok;
    private final int druhySkok;
    private final int tretiSkok;

    public Skokan(String jmeno, int prvniSkok, int druhySkok, int tretiSkok) {
        this.jmeno = jmeno;
        this.prvniSkok = prvniSkok;
        this.druhySkok = druhySkok;
        this.tretiSkok = tretiSkok;
    }

    public String getJmeno() {
        return jmeno;
    }

    public int getPrvniSkok() {
        return prvniSkok;
    }

    public int getDruhySkok() {
        return druhySkok;
    }

    public int getTretiSkok() {
        return tretiSkok;
    }

    @Override
    public String toString() {
        return "Skokan: " +
                "'" + jmeno + '\'' +
                ", prvniSkok: " + prvniSkok +
                ", druhySkok: " + druhySkok +
                ", tretiSkok: " + tretiSkok +
                '}';
    }

    public int delkaNejdelsihoSkoku() {
        return Math.max(prvniSkok, Math.max(druhySkok, tretiSkok));
    }
}
