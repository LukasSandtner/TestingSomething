-- ===============================================
-- INFORMAČNÍ SYSTÉM ZUBNÍ ORDINACE
-- ===============================================

-- 1. POZICE (role zaměstnanců)
CREATE TABLE pozice (
    id_pozice INT PRIMARY KEY IDENTITY(1,1),
    nazev_pozice NVARCHAR(100) NOT NULL,
    popis NVARCHAR(500),
    datum_vytvoreni DATETIME2 DEFAULT GETDATE()
);

-- 2. ORDINACE (místnosti/pracoviště)
CREATE TABLE ordinace (
    id_ordinace INT PRIMARY KEY IDENTITY(1,1),
    nazev_ordinace NVARCHAR(100) NOT NULL,
    adresa NVARCHAR(200) NOT NULL,
    telefon NVARCHAR(20),
    email NVARCHAR(100),
    otviraci_doba NVARCHAR(200),
    kapacita_pacientu INT DEFAULT 1,
    je_aktivni BIT DEFAULT 1,
    datum_vytvoreni DATETIME2 DEFAULT GETDATE()
);

-- 3. ZAMĚSTNANCI
CREATE TABLE zamestnanci (
    id_zamestnanec INT PRIMARY KEY IDENTITY(1,1),
    jmeno NVARCHAR(50) NOT NULL,
    prijmeni NVARCHAR(50) NOT NULL,
    rodne_cislo NVARCHAR(11) UNIQUE,
    telefon NVARCHAR(20),
    email NVARCHAR(100) UNIQUE,
    adresa NVARCHAR(200),
    datum_nastupu DATE,
    plat DECIMAL(10,2),
    id_pozice INT,
    id_ordinace INT,
    je_aktivni BIT DEFAULT 1,
    datum_vytvoreni DATETIME2 DEFAULT GETDATE(),
    FOREIGN KEY (id_pozice) REFERENCES pozice(id_pozice),
    FOREIGN KEY (id_ordinace) REFERENCES ordinace(id_ordinace)
);

-- 4. PACIENTI
CREATE TABLE pacienti (
    id_pacient INT PRIMARY KEY IDENTITY(1,1),
    jmeno NVARCHAR(50) NOT NULL,
    prijmeni NVARCHAR(50) NOT NULL,
    rodne_cislo NVARCHAR(11) UNIQUE NOT NULL,
    datum_narozeni DATE NOT NULL,
    pohlavi NVARCHAR(10) CHECK (pohlavi IN ('Muž', 'Žena', 'Jiné')),
    telefon NVARCHAR(20),
    email NVARCHAR(100),
    adresa NVARCHAR(200),
    cislo_pojistovny NVARCHAR(10),
    kontaktni_osoba NVARCHAR(100),
    kontaktni_telefon NVARCHAR(20),
    alergie NVARCHAR(500),
    chronické_nemoci NVARCHAR(500),
    poznamky NVARCHAR(1000),
    je_aktivni BIT DEFAULT 1,
    datum_registrace DATETIME2 DEFAULT GETDATE()
);

-- 5. TYPY ZÁKROKŮ
CREATE TABLE typy_zakroku (
    id_typ_zakroku INT PRIMARY KEY IDENTITY(1,1),
    nazev_zakroku NVARCHAR(100) NOT NULL,
    popis NVARCHAR(500),
    predpokladana_doba_minut INT,
    zakladni_cena DECIMAL(10,2),
    kod_zakroku NVARCHAR(20) UNIQUE,
    je_aktivni BIT DEFAULT 1,
    datum_vytvoreni DATETIME2 DEFAULT GETDATE()
);

-- 6. ZDRAVOTNÍ KARTY (záznamy o zákrocích)
CREATE TABLE zdravotni_karty (
    id_karta INT PRIMARY KEY IDENTITY(1,1),
    id_pacient INT NOT NULL,
    id_zamestnanec INT,
    id_typ_zakroku INT NOT NULL,
    datum_zakroku DATETIME2 NOT NULL,
    popis_zakroku NVARCHAR(1000),
    cislo_zubu NVARCHAR(10),
    diagnoza NVARCHAR(200),
    vysledek_zakroku NVARCHAR(500),
    cena_zakroku DECIMAL(10,2),
    uhrazeno DECIMAL(10,2) DEFAULT 0,
    zpusob_uhrady NVARCHAR(50),
    poznamky NVARCHAR(500),
    datum_vytvoreni DATETIME2 DEFAULT GETDATE(),
    FOREIGN KEY (id_pacient) REFERENCES pacienti(id_pacient),
    FOREIGN KEY (id_zamestnanec) REFERENCES zamestnanci(id_zamestnanec),
    FOREIGN KEY (id_typ_zakroku) REFERENCES typy_zakroku(id_typ_zakroku)
);

-- 7. PRACOVNÍ NESCHOPNOST
CREATE TABLE pracovni_neschopnost (
    id_neschopnost INT PRIMARY KEY IDENTITY(1,1),
    id_pacient INT NOT NULL,
    id_zamestnanec INT NOT NULL,
    datum_od DATE NOT NULL,
    datum_do DATE NOT NULL,
    duvod_neschopnosti NVARCHAR(200) NOT NULL,
    cislo_potvrzeni NVARCHAR(50) UNIQUE,
    poznamky NVARCHAR(500),
    datum_vystaveni DATETIME2 DEFAULT GETDATE(),
    FOREIGN KEY (id_pacient) REFERENCES pacienti(id_pacient),
    FOREIGN KEY (id_zamestnanec) REFERENCES zamestnanci(id_zamestnanec)
);

-- 8. LÉČIVA
CREATE TABLE leciva (
    id_lecivo INT PRIMARY KEY IDENTITY(1,1),
    nazev_leciva NVARCHAR(100) NOT NULL,
    ucinna_latka NVARCHAR(100),
    forma_leciva NVARCHAR(50), -- tableta, sirup, mast, atd.
    sila_davkovani NVARCHAR(50),
    vyrobce NVARCHAR(100),
    indikace NVARCHAR(500),
    kontraindikace NVARCHAR(500),
    vedlejsi_ucinky NVARCHAR(500),
    je_na_predpis BIT DEFAULT 1,
    je_aktivni BIT DEFAULT 1,
    datum_vytvoreni DATETIME2 DEFAULT GETDATE()
);

-- 9. LÉKAŘSKÉ PŘEDPISY
CREATE TABLE lekarske_predpisy (
    id_predpis INT PRIMARY KEY IDENTITY(1,1),
    id_pacient INT NOT NULL,
    id_zamestnanec INT NOT NULL,
    cislo_predpisu NVARCHAR(50) UNIQUE NOT NULL,
    datum_vystaveni DATETIME2 DEFAULT GETDATE(),
    datum_platnosti DATE,
    diagnoza NVARCHAR(200),
    poznamky NVARCHAR(500),
    FOREIGN KEY (id_pacient) REFERENCES pacienti(id_pacient),
    FOREIGN KEY (id_zamestnanec) REFERENCES zamestnanci(id_zamestnanec)
);

-- 10. PŘEDPIS LÉČIVA (položky předpisu)
CREATE TABLE predpis_leciva (
    id_predpis_leciva INT PRIMARY KEY IDENTITY(1,1),
    id_predpis INT NOT NULL,
    id_lecivo INT NOT NULL,
    mnozstvi INT NOT NULL,
    jednotka NVARCHAR(20) DEFAULT 'ks',
    davkovani NVARCHAR(100) NOT NULL,
    delka_uzivani_dni INT,
    pokyny_k_uziti NVARCHAR(300),
    FOREIGN KEY (id_predpis) REFERENCES lekarske_predpisy(id_predpis),
    FOREIGN KEY (id_lecivo) REFERENCES leciva(id_lecivo)
);

-- 11. REZERVACE
CREATE TABLE rezervace (
    id_rezervace INT PRIMARY KEY IDENTITY(1,1),
    id_pacient INT NOT NULL,
    id_zamestnanec INT,
    id_ordinace INT NOT NULL,
    datum_rezervace DATETIME2 NOT NULL,
    doba_trvani_minut INT DEFAULT 30,
    typ_rezervace NVARCHAR(50) DEFAULT 'Vyšetření',
    popis_pozadavku NVARCHAR(300),
    stav_rezervace NVARCHAR(20) CHECK (stav_rezervace IN ('Potvrzená', 'Zrušená', 'Dokončená', 'Nedostavil se')) DEFAULT 'Potvrzená',
    poznamky NVARCHAR(500),
    datum_vytvoreni DATETIME2 DEFAULT GETDATE(),
    datum_zruseni DATETIME2,
    FOREIGN KEY (id_pacient) REFERENCES pacienti(id_pacient),
    FOREIGN KEY (id_zamestnanec) REFERENCES zamestnanci(id_zamestnanec),
    FOREIGN KEY (id_ordinace) REFERENCES ordinace(id_ordinace)
);

-- 12. TYPY KOMUNIKACE
CREATE TABLE typy_komunikace (
    id_typ_komunikace INT PRIMARY KEY IDENTITY(1,1),
    nazev_typu NVARCHAR(50) NOT NULL, -- telefon, email, SMS, osobně
    popis NVARCHAR(200),
    je_aktivni BIT DEFAULT 1
);

-- 13. KOMUNIKACE
CREATE TABLE komunikace (
    id_komunikace INT PRIMARY KEY IDENTITY(1,1),
    id_pacient INT NOT NULL,
    id_zamestnanec INT,
    id_typ_komunikace INT NOT NULL,
    datum_komunikace DATETIME2 DEFAULT GETDATE(),
    predmet NVARCHAR(200),
    obsah_komunikace NVARCHAR(2000) NOT NULL,
    smer_komunikace NVARCHAR(20) CHECK (smer_komunikace IN ('Příchozí', 'Odchozí')) NOT NULL,
    priorita NVARCHAR(20) CHECK (priorita IN ('Nízká', 'Střední', 'Vysoká')) DEFAULT 'Střední',
    vyrizeno BIT DEFAULT 0,
    poznamky NVARCHAR(500),
    FOREIGN KEY (id_pacient) REFERENCES pacienti(id_pacient),
    FOREIGN KEY (id_zamestnanec) REFERENCES zamestnanci(id_zamestnanec),
    FOREIGN KEY (id_typ_komunikace) REFERENCES typy_komunikace(id_typ_komunikace)
);

-- 14. DODAVATELÉ
CREATE TABLE dodavatele (
    id_dodavatel INT PRIMARY KEY IDENTITY(1,1),
    nazev_spolecnosti NVARCHAR(100) NOT NULL,
    ico NVARCHAR(20) UNIQUE,
    dic NVARCHAR(20),
    adresa NVARCHAR(200),
    telefon NVARCHAR(20),
    email NVARCHAR(100),
    kontaktni_osoba NVARCHAR(100),
    platebni_podminky NVARCHAR(200),
    je_aktivni BIT DEFAULT 1,
    datum_vytvoreni DATETIME2 DEFAULT GETDATE()
);

-- 15. KATEGORIE MATERIÁLU
CREATE TABLE kategorie_materialu (
    id_kategorie INT PRIMARY KEY IDENTITY(1,1),
    nazev_kategorie NVARCHAR(100) NOT NULL,
    popis NVARCHAR(300),
    je_aktivni BIT DEFAULT 1
);

-- 16. SKLADOVÉ ZÁSOBY
CREATE TABLE skladove_zasoby (
    id_zasoba INT PRIMARY KEY IDENTITY(1,1),
    nazev_materialu NVARCHAR(100) NOT NULL,
    kod_materialu NVARCHAR(50) UNIQUE,
    id_kategorie INT,
    id_dodavatel INT,
    jednotka NVARCHAR(20) DEFAULT 'ks',
    aktualni_mnozstvi DECIMAL(10,2) DEFAULT 0,
    minimalni_mnozstvi DECIMAL(10,2) DEFAULT 0,
    maximalni_mnozstvi DECIMAL(10,2),
    nakupni_cena DECIMAL(10,2),
    prodejni_cena DECIMAL(10,2),
    datum_expirace DATE,
    umisteni_ve_skladu NVARCHAR(100),
    poznamky NVARCHAR(500),
    je_aktivni BIT DEFAULT 1,
    datum_vytvoreni DATETIME2 DEFAULT GETDATE(),
    FOREIGN KEY (id_kategorie) REFERENCES kategorie_materialu(id_kategorie),
    FOREIGN KEY (id_dodavatel) REFERENCES dodavatele(id_dodavatel)
);

-- 17. CELKOVÝ STAV CHRUPU
CREATE TABLE celkovy_stav_chrupu (
    id_stav_chrupu INT PRIMARY KEY IDENTITY(1,1),
    id_pacient INT UNIQUE NOT NULL,
    datum_posledni_aktualizace DATETIME2 DEFAULT GETDATE(),
    celkovy_stav NVARCHAR(20) CHECK (celkovy_stav IN ('Výborný', 'Dobrý', 'Uspokojivý', 'Špatný', 'Velmi špatný')) DEFAULT 'Dobrý',
    pocet_zdravych_zubu INT DEFAULT 0,
    pocet_kazivych_zubu INT DEFAULT 0,
    pocet_osetrených_zubu INT DEFAULT 0,
    pocet_chybejicich_zubu INT DEFAULT 0,
    ma_paradentitidu BIT DEFAULT 0,
    kvalita_hygieny NVARCHAR(20) CHECK (kvalita_hygieny IN ('Výborná', 'Dobrá', 'Uspokojivá', 'Špatná')) DEFAULT 'Dobrá',
    poznamky NVARCHAR(1000),
    FOREIGN KEY (id_pacient) REFERENCES pacienti(id_pacient)
);

-- 18. ZUBY
CREATE TABLE zuby (
    id_zub INT PRIMARY KEY IDENTITY(1,1),
    id_stav_chrupu INT NOT NULL,
    cislo_zubu INT NOT NULL CHECK (cislo_zubu BETWEEN 11 AND 85), -- mezinárodní číslování
    nazev_zubu NVARCHAR(50),
    stav_zubu NVARCHAR(20) CHECK (stav_zubu IN ('Zdravý', 'Kazivý', 'Ošetřený', 'Chybí', 'Náhrada')) NOT NULL,
    poznamky NVARCHAR(300),
    datum_posledni_zmeny DATETIME2 DEFAULT GETDATE(),
    FOREIGN KEY (id_stav_chrupu) REFERENCES celkovy_stav_chrupu(id_stav_chrupu),
    UNIQUE(id_stav_chrupu, cislo_zubu)
);

-- 19. NÁHRADY
CREATE TABLE nahrady (
    id_nahrada INT PRIMARY KEY IDENTITY(1,1),
    id_zub INT NOT NULL,
    typ_nahrady NVARCHAR(50) NOT NULL, -- koruna, můstek, implantát, protéza
    material NVARCHAR(50), -- keramika, kov, kompozit
    datum_instalace DATE,
    zaruka_do DATE,
    cena DECIMAL(10,2),
    vyrobce NVARCHAR(100),
    poznamky NVARCHAR(300),
    je_aktivni BIT DEFAULT 1,
    FOREIGN KEY (id_zub) REFERENCES zuby(id_zub)
);

-- 20. PLOMBY
CREATE TABLE plomby (
    id_plomba INT PRIMARY KEY IDENTITY(1,1),
    id_zub INT NOT NULL,
    typ_plomby NVARCHAR(50) NOT NULL, -- amalgam, kompozit, skloionomer
    velikost_plomby NVARCHAR(20), -- malá, střední, velká
    poloha_plomby NVARCHAR(50), -- okluzální, mezimální, apod.
    datum_instalace DATE,
    zaruka_do DATE,
    cena DECIMAL(10,2),
    poznamky NVARCHAR(300),
    je_aktivni BIT DEFAULT 1,
    FOREIGN KEY (id_zub) REFERENCES zuby(id_zub)
);

-- ===============================================
-- INDEXY PRO OPTIMALIZACI VÝKONU
-- ===============================================

-- Indexy pro časté vyhledávání
CREATE INDEX IX_pacienti_rodne_cislo ON pacienti(rodne_cislo);
CREATE INDEX IX_pacienti_prijmeni ON pacienti(prijmeni);
CREATE INDEX IX_zdravotni_karty_datum ON zdravotni_karty(datum_zakroku);
CREATE INDEX IX_rezervace_datum ON rezervace(datum_rezervace);
CREATE INDEX IX_komunikace_datum ON komunikace(datum_komunikace);
CREATE INDEX IX_skladove_zasoby_kod ON skladove_zasoby(kod_materialu);
CREATE INDEX IX_zuby_cislo ON zuby(cislo_zubu);

-- ===============================================
-- ZÁKLADNÍ DATA PRO SPUŠTĚNÍ SYSTÉMU
-- ===============================================

-- Pozice zaměstnanců
INSERT INTO pozice (nazev_pozice, popis) VALUES
('Zubní lékař', 'Hlavní lékař provádějící zákroky'),
('Dentální hygienistka', 'Specialista na dentální hygienu'),
('Zubní asistentka', 'Asistence při zákrocích'),
('Recepční', 'Obsluha recepce a administrativy'),
('Vedoucí ordinace', 'Manažer ordinace');

-- Typy komunikace
INSERT INTO typy_komunikace (nazev_typu, popis) VALUES
('Telefon', 'Telefonická komunikace'),
('Email', 'Elektronická pošta'),
('SMS', 'Textové zprávy'),
('Osobně', 'Osobní setkání'),
('Dopis', 'Poštovní korespondence');

-- Kategorie materiálu
INSERT INTO kategorie_materialu (nazev_kategorie, popis) VALUES
('Plombovací materiály', 'Materiály pro plombování'),
('Nástroje', 'Dentální nástroje a přístroje'),
('Léčiva', 'Farmaceutické přípravky'),
('Dezinfekce', 'Dezinfekční prostředky'),
('Spotřební materiál', 'Jednorázové pomůcky'),
('Ortodoncie', 'Materiály pro ortodoncii');

-- Základní typy zákroků
INSERT INTO typy_zakroku (nazev_zakroku, popis, predpokladana_doba_minut, zakladni_cena, kod_zakroku) VALUES
('Preventivní prohlídka', 'Základní preventivní vyšetření', 30, 500.00, 'PREV001'),
('Plombování', 'Ošetření kazů plombou', 45, 1200.00, 'PLOM001'),
('Extrakce zubu', 'Vytržení zubu', 20, 800.00, 'EXTR001'),
('Endodoncické ošetření', 'Ošetření kořenových kanálků', 90, 2500.00, 'ENDO001'),
('Dentální hygiena', 'Profesionální čištění zubů', 60, 1000.00, 'HYGI001'),
('Ortodontická konzultace', 'Posouzení ortodontických potřeb', 45, 600.00, 'ORTO001');