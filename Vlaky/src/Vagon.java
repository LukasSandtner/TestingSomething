/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lukas
 */
public class Vagon {

    private boolean[][] sedadla;

    // Konstruktor nastaví velikost pole sedadel podle počtu řad a sedadel v řadě
    public Vagon(int radky, int sedadlaNaRadek) {
        sedadla = new boolean[radky][sedadlaNaRadek];
    }

    // Rezervace konkrétního místa
    public void rezervujMisto(int radek, int sedadlo) {
        if (!sedadla[radek][sedadlo]) {
            sedadla[radek][sedadlo] = true;
            System.out.println("Sedadlo " + (radek + 1) + "-" + (sedadlo + 1) + " bylo úspěšně rezervováno.");
        } else {
            System.out.println("Sedadlo " + (radek + 1) + "-" + (sedadlo + 1) + " je již rezervováno.");
        }
    }

    // Uvolnění konkrétního místa
    public void uvolniMisto(int radek, int sedadlo) {
        if (sedadla[radek][sedadlo]) {
            sedadla[radek][sedadlo] = false;
            System.out.println("Sedadlo " + (radek + 1) + "-" + (sedadlo + 1) + " bylo uvolněno.");
        } else {
            System.out.println("Sedadlo " + (radek + 1) + "-" + (sedadlo + 1) + " není rezervováno.");
        }
    }

    // Zobrazení stavu sedadel v textovém formátu
    public void zobrazitSedadla() {
        for (boolean[] radek : sedadla) {
            for (boolean sedadlo : radek) {
                System.out.print(sedadlo ? "X " : "_ ");
            }
            System.out.println();
        }
    }

    // Výpočet volných míst ve vagonu
    public int pocetVolnychMist() {
        int pocet = 0;
        for (boolean[] radek : sedadla) {
            for (boolean sedadlo : radek) {
                if (!sedadlo) {
                    pocet++;
                }
            }
        }
        return pocet;
    }
}
