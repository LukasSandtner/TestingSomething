/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bzapr_cv08_pr01_pokladna;

/**
 *
 * @author st75720
 */
public class Bzapr_Cv08_Pr01_Pokladna {
    //TODO 5 moznosti pro uzivatele, interaktivni menu v cyklu
    public static void main(String[] args) {
        Polozka produkt1 = new Polozka("Rohlik", 10, (float) 3.50, "Kc");
        Polozka produkt2 = new Polozka("Houska", 3, (float) 5.50, "Kc");
        Polozka produkt3 = new Polozka("Chleba", 1, (float) 29.90, "Kc");
        
//        System.out.println(produkt1.celkovaCena());
//        System.out.println(produkt1.toString());
        
        Nakup nakup = new Nakup(5);
        nakup.pridejPolozku(produkt1);
        nakup.pridejPolozku(produkt2);
        nakup.pridejPolozku(produkt3);
        nakup.vypisNakupu();
        nakup.cenaVseho();
        nakup.odeberPolozku("Salat");
        nakup.vypisNakupu();
    }
    
}
