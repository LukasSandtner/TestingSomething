
import java.util.Scanner;

public class Vteriny_Java {

    public static void main(String[] args) {
        System.out.print("Vlozte vteriny: ");
        Scanner vstup = new Scanner(System.in);
        long vstupniVteriny = vstup.nextLong();
        int vterinyZaMinutu = 60;
        int vterinyZaHodinu = vterinyZaMinutu * 60;
        int vterinyZaDen = vterinyZaHodinu * 24;
        int vterinyZaRok = vterinyZaDen * 365;
        int vterinyZaDekadu = vterinyZaRok * 10;
        int vterinyZaStoleti = vterinyZaDekadu * 10;
        int vterinyZaMilenium = vterinyZaStoleti * 10;

        long milenia = vstupniVteriny / vterinyZaMilenium;
        long zbytek = vstupniVteriny % vterinyZaMilenium;

        long stoleti = zbytek / vterinyZaStoleti;
        zbytek %= vterinyZaStoleti;

        long dekady = zbytek / vterinyZaDekadu;
        zbytek %= vterinyZaDekadu;

        long roky = zbytek / vterinyZaRok;
        zbytek %= vterinyZaRok;

        long dny = zbytek / vterinyZaDen;
        zbytek %= vterinyZaDen;

        long hodiny = zbytek / vterinyZaHodinu;
        zbytek %= vterinyZaHodinu;

        long minuty = zbytek / vterinyZaMinutu;
        long vteriny = zbytek % vterinyZaMinutu;

        String str = "\n\t\t\t\t\t\t\tMilenia: "
                + "%d\n\t\t\t\t\t\tStoleti: "
                + "%d\n\t\t\t\t\tDekady: "
                + "%d\n\t\t\t\tRoky: "
                + "%d\n\t\t\tDny: "
                + "%d\n\t\tHodiny: "
                + "%d\n\tMinuty: "
                + "%d\nVteriny: "
                + "%d";
        
        String vysledek = String.format(str, milenia, stoleti, dekady, roky, dny, hodiny, minuty, vteriny);
        System.out.println(vysledek);
    }
}
