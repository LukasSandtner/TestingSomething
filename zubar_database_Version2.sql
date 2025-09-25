-- Informační systém ordinace zubního lékaře
-- Všechny proměnné a názvy v češtině

-- 1. PACIENTI
CREATE TABLE pacienti (
    id_pacient INT PRIMARY KEY AUTO_INCREMENT,
    jmeno VARCHAR(50) NOT NULL,
    prijmeni VARCHAR(50) NOT NULL,
    datum_narozeni DATE NOT NULL,
    rodne_cislo VARCHAR(11) UNIQUE,
    adresa VARCHAR(200),
    telefon VARCHAR(15),
    email VARCHAR(100),
    cislo_pojistovny VARCHAR(10),
    cislo_pojistence VARCHAR(20),
    datum_registrace DATE DEFAULT (CURRENT_DATE),
    poznamky TEXT,
    aktivni BOOLEAN DEFAULT TRUE
);

-- 2. ZDRAVOTNÍ KARTY
CREATE TABLE zdravotni_karty (
    id_karta INT PRIMARY KEY AUTO_INCREMENT,
    id_pacient INT NOT NULL,
    datum_vytvoreni DATE DEFAULT (CURRENT_DATE),
    posledni_kontrola DATE,
    alergie TEXT,
    chronicke_choroby TEXT,
    uzivane_leky TEXT,
    poznamky TEXT,
    FOREIGN KEY (id_pacient) REFERENCES pacienti(id_pacient)
);

-- 3. TYPY ZÁKROKŮ
CREATE TABLE typy_zakroku (
    id_typ_zakroku INT PRIMARY KEY AUTO_INCREMENT,
    nazev_zakroku VARCHAR(100) NOT NULL,
    popis_zakroku TEXT,
    standardni_cena DECIMAL(10,2),
    odhadovana_doba_minut INT,
    aktivni BOOLEAN DEFAULT TRUE
);

-- 4. ZÁKROKY
CREATE TABLE zakroky (
    id_zakrok INT PRIMARY KEY AUTO_INCREMENT,
    id_pacient INT NOT NULL,
    id_typ_zakroku INT NOT NULL,
    id_zub VARCHAR(3),
    datum_zakroku DATE NOT NULL,
    cas_zacatek TIME,
    cas_konec TIME,
    popis_zakroku TEXT,
    cena DECIMAL(10,2),
    stav_zakroku ENUM('naplanovany', 'probihajici', 'dokonceny', 'zruseny') DEFAULT 'naplanovany',
    poznamky TEXT,
    FOREIGN KEY (id_pacient) REFERENCES pacienti(id_pacient),
    FOREIGN KEY (id_typ_zakroku) REFERENCES typy_zakroku(id_typ_zakroku)
);

-- 5. CELKOVÝ STAV CHRUPU
CREATE TABLE stav_chrupu (
    id_stav INT PRIMARY KEY AUTO_INCREMENT,
    id_pacient INT NOT NULL,
    cislo_zubu VARCHAR(3) NOT NULL,
    typ_zubu ENUM('staly', 'mlecny', 'mudrostni') DEFAULT 'staly',
    stav_zubu ENUM('zdravy', 'kazovy', 'leceny', 'chybi', 'nahrada') DEFAULT 'zdravy',
    typ_nahrady ENUM('plomba', 'korunka', 'most', 'implantata', 'proteza') NULL,
    material_nahrady VARCHAR(50),
    datum_osetreni DATE,
    poznamky TEXT,
    FOREIGN KEY (id_pacient) REFERENCES pacienti(id_pacient),
    UNIQUE KEY unik_pacient_zub (id_pacient, cislo_zubu)
);

-- 6. PRACOVNÍ NESCHOPNOST
CREATE TABLE pracovni_neschopnost (
    id_neschopnost INT PRIMARY KEY AUTO_INCREMENT,
    id_pacient INT NOT NULL,
    datum_od DATE NOT NULL,
    datum_do DATE NOT NULL,
    duvod_neschopnosti TEXT,
    cislo_potvrzeni VARCHAR(20),
    datum_vydani DATE DEFAULT (CURRENT_DATE),
    poznamky TEXT,
    FOREIGN KEY (id_pacient) REFERENCES pacienti(id_pacient)
);

-- 7. LÉKAŘSKÉ PŘEDPISY
CREATE TABLE lekarske_predpisy (
    id_predpis INT PRIMARY KEY AUTO_INCREMENT,
    id_pacient INT NOT NULL,
    cislo_predpisu VARCHAR(20) UNIQUE,
    datum_vydani DATE DEFAULT (CURRENT_DATE),
    platnost_do DATE,
    poznamky TEXT,
    FOREIGN KEY (id_pacient) REFERENCES pacienti(id_pacient)
);

-- 8. LÉKY NA PŘEDPISU
CREATE TABLE leky_na_predpisu (
    id_lek_predpis INT PRIMARY KEY AUTO_INCREMENT,
    id_predpis INT NOT NULL,
    nazev_leku VARCHAR(100) NOT NULL,
    davkovani VARCHAR(100),
    mnozstvi VARCHAR(50),
    poznamky TEXT,
    FOREIGN KEY (id_predpis) REFERENCES lekarske_predpisy(id_predpis)
);

-- 9. REZERVACE
CREATE TABLE rezervace (
    id_rezervace INT PRIMARY KEY AUTO_INCREMENT,
    id_pacient INT NOT NULL,
    datum_rezervace DATE NOT NULL,
    cas_od TIME NOT NULL,
    cas_do TIME NOT NULL,
    typ_navstevy VARCHAR(100),
    stav_rezervace ENUM('potvrzena', 'nepotvrzena', 'zrusena', 'dokoncena') DEFAULT 'nepotvrzena',
    poznamky TEXT,
    datum_vytvoreni TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_pacient) REFERENCES pacienti(id_pacient)
);

-- 10. KOMUNIKACE S PACIENTY
CREATE TABLE komunikace (
    id_komunikace INT PRIMARY KEY AUTO_INCREMENT,
    id_pacient INT NOT NULL,
    typ_komunikace ENUM('email', 'telefon', 'sms', 'osobne') NOT NULL,
    smer_komunikace ENUM('odchozi', 'prichozi') NOT NULL,
    predmet VARCHAR(200),
    obsah TEXT,
    datum_komunikace TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    stav_komunikace ENUM('odeslano', 'doruceno', 'precteno', 'odpovezeno') DEFAULT 'odeslano',
    poznamky TEXT,
    FOREIGN KEY (id_pacient) REFERENCES pacienti(id_pacient)
);

-- 11. KATEGORIE ZÁSOB
CREATE TABLE kategorie_zasob (
    id_kategorie INT PRIMARY KEY AUTO_INCREMENT,
    nazev_kategorie VARCHAR(100) NOT NULL,
    popis_kategorie TEXT,
    aktivni BOOLEAN DEFAULT TRUE
);

-- 12. DODAVATELÉ
CREATE TABLE dodavatele (
    id_dodavatel INT PRIMARY KEY AUTO_INCREMENT,
    nazev_spolecnosti VARCHAR(200) NOT NULL,
    ico VARCHAR(20),
    dic VARCHAR(20),
    adresa VARCHAR(200),
    telefon VARCHAR(15),
    email VARCHAR(100),
    kontaktni_osoba VARCHAR(100),
    poznamky TEXT,
    aktivni BOOLEAN DEFAULT TRUE
);

-- 13. SKLADOVÉ ZÁSOBY
CREATE TABLE skladove_zasoby (
    id_zasoba INT PRIMARY KEY AUTO_INCREMENT,
    nazev_polozky VARCHAR(200) NOT NULL,
    id_kategorie INT,
    id_dodavatel INT,
    aktualni_mnozstvi INT DEFAULT 0,
    minimalni_mnozstvi INT DEFAULT 0,
    maximalni_mnozstvi INT DEFAULT 0,
    jednotka VARCHAR(20) DEFAULT 'ks',
    nakupni_cena DECIMAL(10,2),
    datum_posledni_dodavky DATE,
    poznamky TEXT,
    aktivni BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (id_kategorie) REFERENCES kategorie_zasob(id_kategorie),
    FOREIGN KEY (id_dodavatel) REFERENCES dodavatele(id_dodavatel)
);

-- 14. POHYBY ZÁSOB
CREATE TABLE pohyby_zasob (
    id_pohyb INT PRIMARY KEY AUTO_INCREMENT,
    id_zasoba INT NOT NULL,
    typ_pohybu ENUM('prijem', 'vydej', 'inventura', 'storno') NOT NULL,
    mnozstvi INT NOT NULL,
    duvod_pohybu VARCHAR(200),
    datum_pohybu TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    poznamky TEXT,
    FOREIGN KEY (id_zasoba) REFERENCES skladove_zasoby(id_zasoba)
);

-- 15. PLATBY
CREATE TABLE platby (
    id_platba INT PRIMARY KEY AUTO_INCREMENT,
    id_pacient INT NOT NULL,
    id_zakrok INT,
    castka DECIMAL(10,2) NOT NULL,
    typ_platby ENUM('hotove', 'karta', 'prevod', 'pojistovna') NOT NULL,
    datum_platby DATE DEFAULT (CURRENT_DATE),
    stav_platby ENUM('uhrazeno', 'neuhrazeno', 'castecne', 'storno') DEFAULT 'neuhrazeno',
    poznamky TEXT,
    FOREIGN KEY (id_pacient) REFERENCES pacienti(id_pacient),
    FOREIGN KEY (id_zakrok) REFERENCES zakroky(id_zakrok)
);

-- 16. POJIŠŤOVNY
CREATE TABLE pojistovny (
    id_pojistovna INT PRIMARY KEY AUTO_INCREMENT,
    nazev_pojistovny VARCHAR(200) NOT NULL,
    kod_pojistovny VARCHAR(10) UNIQUE NOT NULL,
    adresa VARCHAR(200),
    telefon VARCHAR(15),
    email VARCHAR(100),
    aktivni BOOLEAN DEFAULT TRUE
);

-- 17. SMLOUVY S POJIŠŤOVNAMI
CREATE TABLE smlouvy_pojistovny (
    id_smlouva INT PRIMARY KEY AUTO_INCREMENT,
    id_pojistovna INT NOT NULL,
    cislo_smlouvy VARCHAR(50),
    datum_od DATE NOT NULL,
    datum_do DATE,
    sazba_uhrada DECIMAL(5,2),
    poznamky TEXT,
    aktivni BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (id_pojistovna) REFERENCES pojistovny(id_pojistovna)
);

-- 18. ZAMĚSTNANCI
CREATE TABLE zamestnanci (
    id_zamestnanec INT PRIMARY KEY AUTO_INCREMENT,
    jmeno VARCHAR(50) NOT NULL,
    prijmeni VARCHAR(50) NOT NULL,
    pozice VARCHAR(100),
    datum_nastupu DATE,
    telefon VARCHAR(15),
    email VARCHAR(100),
    aktivni BOOLEAN DEFAULT TRUE
);

-- 19. PŘÍSTUPOVÁ PRÁVA
CREATE TABLE pristupova_prava (
    id_pravo INT PRIMARY KEY AUTO_INCREMENT,
    id_zamestnanec INT NOT NULL,
    modul_systemu VARCHAR(100) NOT NULL,
    uroven_pristupu ENUM('cist', 'upravit', 'mazat', 'admin') NOT NULL,
    datum_prirazeni DATE DEFAULT (CURRENT_DATE),
    aktivni BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (id_zamestnanec) REFERENCES zamestnanci(id_zamestnanec)
);

-- 20. ÚČETNÍ DOKLADY
CREATE TABLE ucetni_doklady (
    id_doklad INT PRIMARY KEY AUTO_INCREMENT,
    typ_dokladu ENUM('faktura', 'pokladni_poukaz', 'bankovni_vypis') NOT NULL,
    cislo_dokladu VARCHAR(50) UNIQUE NOT NULL,
    datum_dokladu DATE DEFAULT (CURRENT_DATE),
    castka DECIMAL(10,2) NOT NULL,
    id_pacient INT,
    popis TEXT,
    poznamky TEXT,
    FOREIGN KEY (id_pacient) REFERENCES pacienti(id_pacient)
);

-- INDEXY PRO OPTIMALIZACI
CREATE INDEX idx_pacienti_prijmeni ON pacienti(prijmeni);
CREATE INDEX idx_pacienti_rodne_cislo ON pacienti(rodne_cislo);
CREATE INDEX idx_zakroky_datum ON zakroky(datum_zakroku);
CREATE INDEX idx_rezervace_datum ON rezervace(datum_rezervace);
CREATE INDEX idx_komunikace_datum ON komunikace(datum_komunikace);
CREATE INDEX idx_platby_datum ON platby(datum_platby);