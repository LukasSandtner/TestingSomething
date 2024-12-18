/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavody;

/**
 *
 * @author st75720
 */
public class StartovniListina {

    final int pocatecniVelikost = 5;
    final int dodatecnaVelikost = 10;
    private Zavodnik[] seznam;
    private int aktPocetZavodniku;
    private boolean jeUsporadano;

    public StartovniListina() {
        aktPocetZavodniku = 0;
        seznam = new Zavodnik[pocatecniVelikost];
        jeUsporadano = true;
    }

    private boolean existujeStartCislo(int hledaneStartovniCislo) {
        for (int i = 0; i < aktPocetZavodniku; i++) {
            if (seznam[i].getStartovniCislo() == hledaneStartovniCislo) {
                return true;
            }
        }
        return false;
    }

    public int pridejZavodnika(Zavodnik zavodnik) throws Exception {
        try {
            if (aktPocetZavodniku == seznam.length) {
                realokujPole();
            }
        } catch (Exception e) {
            throw new Exception("CHYBA, listina je plna");
        }

        if (existujeStartCislo(zavodnik.getStartovniCislo())) {
            throw new Exception("CHYBA, cislo je jiz na listine");
        }

        seznam[aktPocetZavodniku] = zavodnik;
        aktPocetZavodniku++;
        jeUsporadano = false;

        return zavodnik.getStartovniCislo();
    }

    public void odstranZavodnika(Zavodnik zavodnik) throws Exception{}

    private void realokujPole() {
        System.out.println("Realokace pole...");
        Zavodnik[] novySeznam = new Zavodnik[seznam.length + dodatecnaVelikost];

        System.arraycopy(seznam, 0, novySeznam, 0, seznam.length);

        seznam = novySeznam;
    }

    public Zavodnik nastavCas(int startovniCislo, double cas) {
        for (Zavodnik zavodnik : seznam) {
            if (zavodnik != null && zavodnik.getStartovniCislo() == startovniCislo) {
                zavodnik.setCas(cas);
                return zavodnik;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String result = "";
        result += "----------------------------------\n";
        result += "Startovni listina\n";
        result += "----------------------------------\n";

        for (Zavodnik zavodnik : seznam) {
            if (zavodnik != null) {
                result += zavodnik.toString() + "\n";
            }
        }
        result += "----------------------------------\n";
        return result;
    }

    public String listinaToString() {
        String result = "";
        result += "----------------------------------\n";
        result += "Startovni listina\n";
        result += "----------------------------------\n";

        int poradi = 1;
        String poradiStr = "";
        for (Zavodnik zavodnik : seznam) {
            if (zavodnik != null) {
                poradiStr = (zavodnik.jeDNS() ? "       " : String.format("%d.", poradi));
                result += zavodnik.toString() + "\n";
                poradi++;
            }

        }
        return result + poradiStr;
    }
    
    public void vitez(){}
    
    public void usporadat(){}
    
    void resetCasy() {
        for (Zavodnik zavodnik : seznam) {
            if (zavodnik != null) {
                zavodnik.resetCas();
            }
        }
        jeUsporadano = true;
    }
}
