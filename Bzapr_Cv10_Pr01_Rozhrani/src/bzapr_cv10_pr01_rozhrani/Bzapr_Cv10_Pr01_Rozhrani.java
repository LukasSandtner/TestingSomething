/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bzapr_cv10_pr01_rozhrani;

public class Bzapr_Cv10_Pr01_Rozhrani {

    //hledani indexu znaku a kolikrat (indefOf)
    //rozdeleni retezcu podle deliciho znaku (split)
    //cetnost vsech znaku (i necitelnych) v retezci (lower nebo upper)
    
    public static void main(String[] args) {
        ISplatne[] kPlaceni = new ISplatne[2];
        
        kPlaceni[0] = new Faktura("P21", 2, "procesor Intel", 5500.5);
        kPlaceni[1] = new Zamestnanec("Pepa", 007, 29000);
        
        for (ISplatne aktualniPolozka: kPlaceni) {
            System.out.println(aktualniPolozka);
            System.out.println("Zaplatit: " + aktualniPolozka.zaplatitCasktu());
            System.out.println("");
        }
    }  
}
