
import java.util.Scanner;

public class App {

    private static Vlak vlak;
    private static final Scanner scanner = new Scanner(System.in);

    public static void kontrolaVstupu(int maxPocetVagonu) throws MyCustomException {
        if (maxPocetVagonu < 1) {
            throw new MyCustomException("Minimum je jeden vagon!");
        }
        vlak = new Vlak(maxPocetVagonu);
    }

    public static void main(String[] args) {
        System.out.print("Zadejte maximalni pocet vagonu ve vlaku: ");
        int maxPocetVagonu = scanner.nextInt();
        try {
            kontrolaVstupu(maxPocetVagonu); // Test s neplatnou hodnotou
        } catch (MyCustomException e) {
            System.out.println("Vyjimka zachycena: " + e.getMessage() + "\nKONEC");
            System.exit(0);
        }
        boolean running = true;

        while (running) {
            System.out.println("\n1. Pridat vagon");
            System.out.println("2. Odebrat vagon");
            System.out.println("3. Rezervovat misto");
            System.out.println("4. Uvolnit misto");
            System.out.println("5. Zobrazit stav vlaku");
            System.out.println("6. Zobrazit pocet volnych mist");
            System.out.println("7. Konec");

            int volba = scanner.nextInt();

            switch (volba) {
                case 1:
                    pridatVagon();
                    break;
                case 2:
                    odebratVagon();
                    break;
                case 3:
                    rezervovatMisto();
                    break;
                case 4:
                    uvolnitMisto();
                    break;
                case 5:
                    vlak.zobrazitVagony();
                    break;
                case 6:
                    System.out.println("Celkovy pocet volnych mist: " + vlak.pocetVolnychMist());
                    break;
                case 7:
                    running = false;
                    System.out.println("Aplikace byla ukoncena.");
                    break;
                default:
                    System.out.println("Neplatna volba.");
            }
        }
    }

    private static void pridatVagon() {
        System.out.print("Zadejte pocet rad: ");
        int radky = scanner.nextInt();
        System.out.print("Zadejte pocet sedadel na radu: ");
        int sedadlaNaRadek = scanner.nextInt();
        vlak.pridatVagon(new Vagon(radky, sedadlaNaRadek));
    }

    private static void odebratVagon() {
        System.out.print("Zadejte cislo vagonu k odebrani: ");
        int index = scanner.nextInt() - 1;
        vlak.odebratVagon(index);
    }

    private static void rezervovatMisto() {
        System.out.print("Zadejte cislo vagonu: ");
        int vagonIndex = scanner.nextInt() - 1;
        System.out.print("Zadejte cislo rady: ");
        int radek = scanner.nextInt() - 1;
        System.out.print("Zadejte cislo sedadla: ");
        int sedadlo = scanner.nextInt() - 1;
        vlak.rezervujMisto(vagonIndex, radek, sedadlo);
    }

    private static void uvolnitMisto() {
        System.out.print("Zadejte cislo vagonu: ");
        int vagonIndex = scanner.nextInt() - 1;
        System.out.print("Zadejte cislo rady: ");
        int radek = scanner.nextInt() - 1;
        System.out.print("Zadejte cislo sedadla: ");
        int sedadlo = scanner.nextInt() - 1;
        vlak.uvolniMisto(vagonIndex, radek, sedadlo);
    }
}
