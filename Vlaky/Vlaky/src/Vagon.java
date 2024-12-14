/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lukas
 */
public class Vagon {

    private final boolean[][] sedadla;

    // Konstruktor nastaví velikost pole sedadel podle počtu řad a sedadel v řadě
    public Vagon(int radky, int sedadlaNaRadek) {
        sedadla = new boolean[radky][sedadlaNaRadek];

        for (int i = 0; i < radky; i++) {
            for (int j = 0; j < sedadlaNaRadek; j++) {
                sedadla[i][j] = true;
            }

        }
    }

    // Rezervace konkrétního místa
    public void rezervujMisto(int radek, int sedadlo) {
        if (sedadla[radek][sedadlo]) {
            sedadla[radek][sedadlo] = false;
            System.out.println("Sedadlo " + (radek + 1) + "-" + (sedadlo + 1) + " bylo uspesne rezervovano.");
        } else {
            System.out.println("Sedadlo " + (radek + 1) + "-" + (sedadlo + 1) + " je jiz rezervovano.");
        }
    }

    // Uvolnění konkrétního místa
    public void uvolniMisto(int radek, int sedadlo) {
        if (!sedadla[radek][sedadlo]) {
            sedadla[radek][sedadlo] = true;
            System.out.println("Sedadlo " + (radek + 1) + "-" + (sedadlo + 1) + " bylo uvolneno.");
        } else {
            System.out.println("Sedadlo " + (radek + 1) + "-" + (sedadlo + 1) + " není rezervovano.");
        }
    }

    // Zobrazení stavu sedadel v textovém formátu
    public void zobrazitSedadla() {
        for (int i = 0; i < sedadla.length; i++) {
            System.out.print("Rada " + (i + 1) + "\t");
            for (int j = 0; j < sedadla[0].length; j++) {
                System.out.print(sedadla[i][j] ? "_ " : "X ");
            }
            System.out.println();
        }
    }

    // Výpočet volných míst ve vagonu
    public int pocetVolnychMist() {
        int pocet = 0;
        for (boolean[] radek : sedadla) {
            for (boolean sedadlo : radek) {
                if (sedadlo) {
                    pocet++;
                }
            }
        }
        return pocet;
    }
}
