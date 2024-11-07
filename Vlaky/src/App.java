import java.util.Scanner;

public class App {
    private static Vlak vlak;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Zadejte maximální počet vagonů ve vlaku: ");
        int maxPocetVagonu = scanner.nextInt();
        vlak = new Vlak(maxPocetVagonu);

        boolean running = true;

        while (running) {
            System.out.println("\n1. Přidat vagon");
            System.out.println("2. Odebrat vagon");
            System.out.println("3. Rezervovat místo");
            System.out.println("4. Uvolnit místo");
            System.out.println("5. Zobrazit stav vlaku");
            System.out.println("6. Zobrazit počet volných míst");
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
                    System.out.println("Celkový počet volných míst: " + vlak.pocetVolnychMist());
                    break;
                case 7:
                    running = false;
                    System.out.println("Aplikace byla ukončena.");
                    break;
                default:
                    System.out.println("Neplatná volba.");
            }
        }
    }

    private static void pridatVagon() {
        System.out.print("Zadejte počet řad: ");
        int radky = scanner.nextInt();
        System.out.print("Zadejte počet sedadel na řadu: ");
        int sedadlaNaRadek = scanner.nextInt();
        vlak.pridatVagon(new Vagon(radky, sedadlaNaRadek));
    }

    private static void odebratVagon() {
        System.out.print("Zadejte číslo vagonu k odebrání: ");
        int index = scanner.nextInt() - 1;
        vlak.odebratVagon(index);
    }

    private static void rezervovatMisto() {
        System.out.print("Zadejte číslo vagonu: ");
        int vagonIndex = scanner.nextInt() - 1;
        System.out.print("Zadejte číslo řady: ");
        int radek = scanner.nextInt() - 1;
        System.out.print("Zadejte číslo sedadla: ");
        int sedadlo = scanner.nextInt() - 1;
        vlak.rezervujMisto(vagonIndex, radek, sedadlo);
    }

    private static void uvolnitMisto() {
        System.out.print("Zadejte číslo vagonu: ");
        int vagonIndex = scanner.nextInt() - 1;
        System.out.print("Zadejte číslo řady: ");
        int radek = scanner.nextInt() - 1;
        System.out.print("Zadejte číslo sedadla: ");
        int sedadlo = scanner.nextInt() - 1;
        vlak.uvolniMisto(vagonIndex, radek, sedadlo);
    }
}
