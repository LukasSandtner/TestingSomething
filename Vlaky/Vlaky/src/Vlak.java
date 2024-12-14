/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lukas
 */
public class Vlak {
    private final Vagon[] vagony;
    private int pocetVagonu = 1;

    public Vlak(int maxPocetVagonu) {
        vagony = new Vagon[maxPocetVagonu];
        vagony[0] = new Vagon(10, 10);
    }

    // Přidání vagonu
    public void pridatVagon(Vagon vagon) {
        if (pocetVagonu < vagony.length) {
            vagony[pocetVagonu] = vagon;
            pocetVagonu++;
            System.out.println("Vagon byl pridan do vlaku.");
        } else {
            System.out.println("Nelze pridat dalsi vagon - kapacita vlaku je plna.");
        }
    }

    // Odebrání vagonu
    public void odebratVagon(int index) {
        if (index >= 0 && index < pocetVagonu) {
            for (int i = index; i < pocetVagonu - 1; i++) {
                vagony[i] = vagony[i + 1];
            }
            vagony[pocetVagonu - 1] = null;
            pocetVagonu--;
            System.out.println("Vagon byl odebran z vlaku.");
        } else {
            System.out.println("Neplatny index vagonu.");
        }
    }

    // Rezervace místa ve vybraném vagonu
    public void rezervujMisto(int indexVagonu, int radek, int sedadlo) {
        if (indexVagonu >= 0 && indexVagonu < pocetVagonu) {
            vagony[indexVagonu].rezervujMisto(radek, sedadlo);
        } else {
            System.out.println("Neplatny index vagonu.");
        }
    }

    // Uvolnění místa ve vybraném vagonu
    public void uvolniMisto(int indexVagonu, int radek, int sedadlo) {
        if (indexVagonu >= 0 && indexVagonu < pocetVagonu) {
            vagony[indexVagonu].uvolniMisto(radek, sedadlo);
        } else {
            System.out.println("Neplatny index vagonu.");
        }
    }

    // Zobrazení stavu všech vagonů
    public void zobrazitVagony() {
        for (int i = 0; i < pocetVagonu; i++) {
            System.out.println("Vagon " + (i + 1) + ":");
            vagony[i].zobrazitSedadla();
            System.out.println();
        }
    }

    // Výpočet celkového počtu volných míst ve vlaku
    public int pocetVolnychMist() {
        int celkem = 0;
        for (int i = 0; i < pocetVagonu; i++) {
            celkem += vagony[i].pocetVolnychMist();
        }
        return celkem;
    }
}
