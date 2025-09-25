-- Informační systém ordinace zubního lékaře
-- Databáze s českými názvy proměnných a entit

-- 1. Pacienti
CREATE TABLE pacienti (
    id_pacienta INT PRIMARY KEY AUTO_INCREMENT,
    jmeno VARCHAR(50) NOT NULL,
    prijmeni VARCHAR(50) NOT NULL,
    datum_narozeni DATE NOT NULL,
    rodne_cislo VARCHAR(11) UNIQUE,
    adresa VARCHAR(200),
    telefon VARCHAR(20),
    email VARCHAR(100),
    pojistovna VARCHAR(100),
    cislo_pojistence VARCHAR(20),
    datum_registrace DATE DEFAULT CURRENT_DATE,
    aktivni BOOLEAN DEFAULT TRUE,
    poznamky TEXT
);

-- 2. Lékaři
CREATE TABLE lekari (
    id_lekare INT PRIMARY KEY AUTO_INCREMENT,
    jmeno VARCHAR(50) NOT NULL,
    prijmeni VARCHAR(50) NOT NULL,
    titul VARCHAR(20),
    specializace VARCHAR(100),
    telefon VARCHAR(20),
    email VARCHAR(100),
    cislo_licence VARCHAR(50) UNIQUE,
    datum_nastupu DATE,
    aktivni BOOLEAN DEFAULT TRUE
);

-- 3. Zdravotní karty
CREATE TABLE zdravotni_karty (
    id_karty INT PRIMARY KEY AUTO_INCREMENT,
    id_pacienta INT NOT NULL,
    datum_vytvoreni DATE DEFAULT CURRENT_DATE,
    anamneza TEXT,
    alergie TEXT,
    chronicky_onemocneni TEXT,
    uzivane_leky TEXT,
    posledni_aktualizace TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (id_pacienta) REFERENCES pacienti(id_pacienta)
);

-- 4. Typy zákroků
CREATE TABLE typy_zakroku (
    id_typu INT PRIMARY KEY AUTO_INCREMENT,
    nazev VARCHAR(100) NOT NULL,
    popis TEXT,
    prumerna_doba_minut INT,
    zakladni_cena DECIMAL(8,2),
    kod_zakroku VARCHAR(20) UNIQUE
);

-- 5. Zákroky
CREATE TABLE zakroky (
    id_zakroku INT PRIMARY KEY AUTO_INCREMENT,
    id_pacienta INT NOT NULL,
    id_lekare INT NOT NULL,
    id_typu INT NOT NULL,
    datum_zakroku DATE NOT NULL,
    cas_zacatku TIME,
    cas_konce TIME,
    popis TEXT,
    cena DECIMAL(8,2),
    stav ENUM('naplanovany', 'probihajici', 'dokonceny', 'zruseny') DEFAULT 'naplanovany',
    poznamky TEXT,
    FOREIGN KEY (id_pacienta) REFERENCES pacienti(id_pacienta),
    FOREIGN KEY (id_lekare) REFERENCES lekari(id_lekare),
    FOREIGN KEY (id_typu) REFERENCES typy_zakroku(id_typu)
);

-- 6. Stav chrupu
CREATE TABLE stav_chrupu (
    id_stavu INT PRIMARY KEY AUTO_INCREMENT,
    id_pacienta INT NOT NULL,
    cislo_zubu INT NOT NULL CHECK (cislo_zubu BETWEEN 11 AND 48),
    typ_problemu ENUM('zdravy', 'kaz', 'plomba', 'korunka', 'most', 'implant', 'extrakce', 'korenavyplnenka') DEFAULT 'zdravy',
    material VARCHAR(50),
    datum_zmeny DATE DEFAULT CURRENT_DATE,
    popis TEXT,
    FOREIGN KEY (id_pacienta) REFERENCES pacienti(id_pacienta)
);

-- 7. Pracovní neschopnost
CREATE TABLE pracovni_neschopnost (
    id_neschopnosti INT PRIMARY KEY AUTO_INCREMENT,
    id_pacienta INT NOT NULL,
    id_lekare INT NOT NULL,
    datum_od DATE NOT NULL,
    datum_do DATE NOT NULL,
    duvod TEXT,
    kod_diagnozy VARCHAR(10),
    cislo_potvrzeni VARCHAR(50) UNIQUE,
    datum_vystaveni DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (id_pacienta) REFERENCES pacienti(id_pacienta),
    FOREIGN KEY (id_lekare) REFERENCES lekari(id_lekare)
);

-- 8. Léky
CREATE TABLE leky (
    id_leku INT PRIMARY KEY AUTO_INCREMENT,
    nazev VARCHAR(100) NOT NULL,
    ucinna_latka VARCHAR(100),
    forma VARCHAR(50),
    koncentrace VARCHAR(50),
    baleni VARCHAR(50),
    cena_za_baleni DECIMAL(8,2),
    kod_sukl VARCHAR(20) UNIQUE,
    na_predpis BOOLEAN DEFAULT TRUE
);

-- 9. Lékařské předpisy
CREATE TABLE lekarske_predpisy (
    id_predpisu INT PRIMARY KEY AUTO_INCREMENT,
    id_pacienta INT NOT NULL,
    id_lekare INT NOT NULL,
    datum_vystaveni DATE DEFAULT CURRENT_DATE,
    cislo_predpisu VARCHAR(50) UNIQUE,
    duvod_predpisu TEXT,
    platnost_do DATE,
    FOREIGN KEY (id_pacienta) REFERENCES pacienti(id_pacienta),
    FOREIGN KEY (id_lekare) REFERENCES lekari(id_lekare)
);

-- 10. Předepsané léky (M:N vazba mezi předpisy a léky)
CREATE TABLE predepsane_leky (
    id_predepsaneho INT PRIMARY KEY AUTO_INCREMENT,
    id_predpisu INT NOT NULL,
    id_leku INT NOT NULL,
    davkovani VARCHAR(100),
    pocet_baleni INT DEFAULT 1,
    pokyny_uzivani TEXT,
    FOREIGN KEY (id_predpisu) REFERENCES lekarske_predpisy(id_predpisu),
    FOREIGN KEY (id_leku) REFERENCES leky(id_leku)
);

-- 11. Rezervace
CREATE TABLE rezervace (
    id_rezervace INT PRIMARY KEY AUTO_INCREMENT,
    id_pacienta INT NOT NULL,
    id_lekare INT NOT NULL,
    datum_rezervace DATE NOT NULL,
    cas_od TIME NOT NULL,
    cas_do TIME NOT NULL,
    typ_navstevy VARCHAR(100),
    stav ENUM('aktivni', 'potvrzena', 'dokoncena', 'zrusena', 'neprisel') DEFAULT 'aktivni',
    poznamky TEXT,
    datum_vytvoreni TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_pacienta) REFERENCES pacienti(id_pacienta),
    FOREIGN KEY (id_lekare) REFERENCES lekari(id_lekare)
);

-- 12. Typy komunikace
CREATE TABLE typy_komunikace (
    id_typu_komunikace INT PRIMARY KEY AUTO_INCREMENT,
    nazev VARCHAR(50) NOT NULL,
    popis VARCHAR(200)
);

-- 13. Komunikace s pacienty
CREATE TABLE komunikace (
    id_komunikace INT PRIMARY KEY AUTO_INCREMENT,
    id_pacienta INT NOT NULL,
    id_lekare INT,
    id_typu_komunikace INT NOT NULL,
    datum_komunikace TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    predmet VARCHAR(200),
    obsah TEXT,
    smer ENUM('odchozi', 'prichozi') NOT NULL,
    stav ENUM('odeslana', 'dorucena', 'prectena', 'zodpovedana') DEFAULT 'odeslana',
    FOREIGN KEY (id_pacienta) REFERENCES pacienti(id_pacienta),
    FOREIGN KEY (id_lekare) REFERENCES lekari(id_lekare),
    FOREIGN KEY (id_typu_komunikace) REFERENCES typy_komunikace(id_typu_komunikace)
);

-- 14. Kategorie zásob
CREATE TABLE kategorie_zasob (
    id_kategorie INT PRIMARY KEY AUTO_INCREMENT,
    nazev VARCHAR(100) NOT NULL,
    popis TEXT
);

-- 15. Dodavatelé
CREATE TABLE dodavatele (
    id_dodavatele INT PRIMARY KEY AUTO_INCREMENT,
    nazev VARCHAR(100) NOT NULL,
    adresa VARCHAR(200),
    telefon VARCHAR(20),
    email VARCHAR(100),
    ico VARCHAR(20),
    dic VARCHAR(20),
    kontaktni_osoba VARCHAR(100),
    aktivni BOOLEAN DEFAULT TRUE
);

-- 16. Skladové zásoby
CREATE TABLE skladove_zasoby (
    id_zasoby INT PRIMARY KEY AUTO_INCREMENT,
    nazev VARCHAR(100) NOT NULL,
    popis TEXT,
    id_kategorie INT NOT NULL,
    id_dodavatele INT,
    jednotka VARCHAR(20),
    aktualni_mnozstvi DECIMAL(10,2) DEFAULT 0,
    minimalni_mnozstvi DECIMAL(10,2) DEFAULT 0,
    maximalni_mnozstvi DECIMAL(10,2),
    nakupni_cena DECIMAL(8,2),
    prodejni_cena DECIMAL(8,2),
    datum_posledni_dodavky DATE,
    datum_expirace DATE,
    aktivni BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (id_kategorie) REFERENCES kategorie_zasob(id_kategorie),
    FOREIGN KEY (id_dodavatele) REFERENCES dodavatele(id_dodavatele)
);

-- 17. Pohyby zásob
CREATE TABLE pohyby_zasob (
    id_pohybu INT PRIMARY KEY AUTO_INCREMENT,
    id_zasoby INT NOT NULL,
    typ_pohybu ENUM('prijem', 'vydej', 'inventura', 'skoda') NOT NULL,
    mnozstvi DECIMAL(10,2) NOT NULL,
    cena_za_jednotku DECIMAL(8,2),
    datum_pohybu TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    duvod VARCHAR(200),
    id_uzivatel INT,
    FOREIGN KEY (id_zasoby) REFERENCES skladove_zasoby(id_zasoby)
);

-- 18. Použité materiály při zákrocích (M:N vazba mezi zákroky a zásobami)
CREATE TABLE pouzite_materialy (
    id_pouziti INT PRIMARY KEY AUTO_INCREMENT,
    id_zakroku INT NOT NULL,
    id_zasoby INT NOT NULL,
    pouzite_mnozstvi DECIMAL(10,2) NOT NULL,
    cena_za_jednotku DECIMAL(8,2),
    FOREIGN KEY (id_zakroku) REFERENCES zakroky(id_zakroku),
    FOREIGN KEY (id_zasoby) REFERENCES skladove_zasoby(id_zasoby)
);

-- 19. Faktury
CREATE TABLE faktury (
    id_faktury INT PRIMARY KEY AUTO_INCREMENT,
    id_pacienta INT NOT NULL,
    cislo_faktury VARCHAR(50) UNIQUE NOT NULL,
    datum_vystaveni DATE DEFAULT CURRENT_DATE,
    datum_splatnosti DATE,
    celkova_castka DECIMAL(10,2) NOT NULL,
    dph DECIMAL(10,2) DEFAULT 0,
    stav ENUM('nevystavena', 'vystavena', 'odeslana', 'zaplacena', 'po_splatnosti') DEFAULT 'nevystavena',
    poznamky TEXT,
    FOREIGN KEY (id_pacienta) REFERENCES pacienti(id_pacienta)
);

-- 20. Položky faktury
CREATE TABLE polozky_faktury (
    id_polozky INT PRIMARY KEY AUTO_INCREMENT,
    id_faktury INT NOT NULL,
    id_zakroku INT,
    popis VARCHAR(200) NOT NULL,
    mnozstvi DECIMAL(10,2) DEFAULT 1,
    jednotkova_cena DECIMAL(8,2) NOT NULL,
    celkova_cena DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_faktury) REFERENCES faktury(id_faktury),
    FOREIGN KEY (id_zakroku) REFERENCES zakroky(id_zakroku)
);

-- Indexy pro lepší výkon
CREATE INDEX idx_pacienti_prijmeni ON pacienti(prijmeni);
CREATE INDEX idx_pacienti_rodne_cislo ON pacienti(rodne_cislo);
CREATE INDEX idx_zakroky_datum ON zakroky(datum_zakroku);
CREATE INDEX idx_rezervace_datum ON rezervace(datum_rezervace);
CREATE INDEX idx_komunikace_datum ON komunikace(datum_komunikace);
CREATE INDEX idx_stav_chrupu_pacient_zub ON stav_chrupu(id_pacienta, cislo_zubu);
