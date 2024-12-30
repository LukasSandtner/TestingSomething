/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zavodnici;

/**
 *
 * @author Lukas
 */
public class ZavodnikZaznam {
    private String jmeno;
    private int prvniSkok;
    private int druhySkok;

    public ZavodnikZaznam(String jmeno, int prvniSkok, int druhySkok) throws InvalidZaznamException {
        
        if(jmeno == null || jmeno.isEmpty()){
            throw new InvalidZaznamException("Jmeno nesmi byt prazdne");
        }
        
        
        this.jmeno = jmeno;
        this.prvniSkok = prvniSkok;
        this.druhySkok = druhySkok;
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

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setPrvniSkok(int prvniSkok) {
        this.prvniSkok = prvniSkok;
    }

    public void setDruhySkok(int druhySkok) {
        this.druhySkok = druhySkok;
    }
    
    public int dejLepsiCas() {
        return Math.min(prvniSkok, prvniSkok);
    }

    @Override
    public String toString() {
        return String.format("%s; %d; %d;", jmeno, prvniSkok, druhySkok);
    }
    
    
}
