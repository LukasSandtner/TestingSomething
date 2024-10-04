
import java.util.Scanner;

public class Kruhy_Java {

    public static void main(String[] args) {
        double prumer, obvod, obsah;
        byte volba;
        System.out.println("Obvod(1)|Obsah(2): ");
        Scanner volba_1 = new Scanner(System.in);
        volba = volba_1.nextByte();

        if (volba == 1) {
            System.out.println("Zadejte prumer: ");
            Scanner vstup = new Scanner(System.in);
            prumer = vstup.nextDouble();
            if (prumer != 0) {
                obvod = Math.round(Math.PI * prumer * 2 * 100) / 100d;
                System.out.println("Obvod: " + obvod);
            } else {
                System.out.println("Prumer nesmi byt nula!");
            }
        } else if (volba == 2) {
            System.out.println("Zadejte prumer: ");
            Scanner vstup = new Scanner(System.in);
            prumer = vstup.nextDouble();
            if (prumer != 0) {
                obsah = Math.round(Math.PI * prumer * prumer * 100) / 100d;
                System.out.println("Obvod: " + obsah);
            } else {
                System.out.println("Prumer nesmi byt nula!");
            }
        } else {
            System.out.println("Vyberte pouze 1 nebo 2!");
        }
    }
}
