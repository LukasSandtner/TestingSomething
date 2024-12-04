/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bzapr_cv11_pr01_soubory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//TODO vypsat matici do souboru na radky
public class Bzapr_Cv11_Pr01_Soubory {


    public static void main(String[] args) throws IOException {
        String jmenoVstupu = "cisla.txt";
        String jmenoVystupu = "vystupCisel.txt";

//        FileReader fr = null;
//        FileWriter fw = null;
        ArrayList<Integer> seznamCisel = new ArrayList<Integer> ();

        BufferedReader bufRead = null;

        try {
            bufRead = new BufferedReader(new FileReader(jmenoVstupu));

            String radek;
            String[] cisla;
            
            while ((radek = bufRead.readLine()) != null) {
                cisla = radek.split(" ");
                for (String cisloStr : cisla) {
                    seznamCisel.add(new Integer(cisloStr));
                }
            }
        } finally {
            if (bufRead != null) {
                bufRead.close();
            }
        }
        BufferedWriter bufWrite = null;
        try {
            bufWrite = new BufferedWriter(new FileWriter(jmenoVystupu));

            bufWrite.newLine();
            bufWrite.flush();
            bufWrite.write(65);
            bufWrite.write(66);
            bufWrite.write(67);
        } finally {
            if (bufWrite != null) {
                bufWrite.close();
            }
            
        }
//        FileInputStream fis = null;
//        FileOutputStream fos = null;
//        
//        File fin = null;
//        File fout = null;

//        try {
//            fr = new FileReader(jmenoVstupu);
//            fw = new FileWriter(jmenoVystupu);
//
//            int c;
//            while ((c = fr.read()) != -1) {
//                fw.write(c);
//                //System.out.format("%d ", c);
//                System.out.format("%02X ", c);
//            }
//        } finally {
//            if (fr != null) {
//                fr.close();
//            }
//            if (fw != null) {
//                fw.close();
//            }
//        }
    }

}
