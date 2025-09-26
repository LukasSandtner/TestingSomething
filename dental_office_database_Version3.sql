-- Vytvoření databáze
CREATE DATABASE IF NOT EXISTS ZubniOrdinace;
USE ZubniOrdinace;

-- Tabulka Pacient - informace o pacientech
CREATE TABLE Pacient (
    id_pacient INT PRIMARY KEY AUTO_INCREMENT,
    jmeno VARCHAR(50) NOT NULL,
    prijmeni VARCHAR(50) NOT NULL,
    datum_narozeni DATE NOT NULL,
    rodne_cislo VARCHAR(11) NOT NULL UNIQUE,
    telefon VARCHAR(15) NOT NULL,
    email VARCHAR(100),
    adresa VARCHAR(200) NOT NULL,
    pojistovna VARCHAR(50) NOT NULL,
    datum_registrace DATE NOT NULL
);

-- Tabulka Zamestnanec - zaměstnanci ordinace
CREATE TABLE Zamestnanec (
    id_zamestnanec INT PRIMARY KEY AUTO_INCREMENT,
    jmeno VARCHAR(50) NOT NULL,
    prijmeni VARCHAR(50) NOT NULL,
    telefon VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    pozice VARCHAR(50) NOT NULL,  -- lékař, sestra, recepční
    datum_nastupu DATE NOT NULL
);

-- Tabulka Zákrok - typy zubních zákroků
CREATE TABLE Zakrok (
    id_zakrok INT PRIMARY KEY AUTO_INCREMENT,
    nazev VARCHAR(100) NOT NULL,
    popis TEXT,
    trvani_minut INT NOT NULL,
    cena DECIMAL(10, 2) NOT NULL,
    kod_pojistovny VARCHAR(20)
);

-- Tabulka Rezervace - termíny návštěv
CREATE TABLE Rezervace (
    id_rezervace INT PRIMARY KEY AUTO_INCREMENT,
    id_pacient INT NOT NULL,
    id_zamestnanec INT NOT NULL,
    datum_cas DATETIME NOT NULL,
    ucel VARCHAR(200) NOT NULL,
    stav VARCHAR(20) NOT NULL DEFAULT 'potvrzeno', -- potvrzeno, zrušeno, dokončeno
    FOREIGN KEY (id_pacient) REFERENCES Pacient(id_pacient),
    FOREIGN KEY (id_zamestnanec) REFERENCES Zamestnanec(id_zamestnanec)
);

-- Tabulka ZdravotniKarta - zdravotní záznamy pacientů
CREATE TABLE ZdravotniKarta (
    id_zdravotni_karta INT PRIMARY KEY AUTO_INCREMENT,
    id_pacient INT NOT NULL,
    datum_vytvoreni DATE NOT NULL,
    FOREIGN KEY (id_pacient) REFERENCES Pacient(id_pacient)
);

-- Tabulka Zaznam - jednotlivé záznamy v zdravotní kartě
CREATE TABLE Zaznam (
    id_zaznam INT PRIMARY KEY AUTO_INCREMENT,
    id_zdravotni_karta INT NOT NULL,
    id_zamestnanec INT NOT NULL,
    datum_cas DATETIME NOT NULL,
    popis TEXT NOT NULL,
    diagnozy TEXT,
    FOREIGN KEY (id_zdravotni_karta) REFERENCES ZdravotniKarta(id_zdravotni_karta),
    FOREIGN KEY (id_zamestnanec) REFERENCES Zamestnanec(id_zamestnanec)
);

-- Tabulka ZaznamZakrok - M:N vazba mezi záznamy a zákroky
CREATE TABLE ZaznamZakrok (
    id_zaznam INT NOT NULL,
    id_zakrok INT NOT NULL,
    pocet INT NOT NULL DEFAULT 1,
    poznamka TEXT,
    PRIMARY KEY (id_zaznam, id_zakrok),
    FOREIGN KEY (id_zaznam) REFERENCES Zaznam(id_zaznam),
    FOREIGN KEY (id_zakrok) REFERENCES Zakrok(id_zakrok)
);

-- Tabulka PracovniNeschopnost
CREATE TABLE PracovniNeschopnost (
    id_neschopnost INT PRIMARY KEY AUTO_INCREMENT,
    id_pacient INT NOT NULL,
    id_zamestnanec INT NOT NULL,
    datum_od DATE NOT NULL,
    datum_do DATE,
    duvod TEXT NOT NULL,
    FOREIGN KEY (id_pacient) REFERENCES Pacient(id_pacient),
    FOREIGN KEY (id_zamestnanec) REFERENCES Zamestnanec(id_zamestnanec)
);

-- Tabulka Lek - katalog léků
CREATE TABLE Lek (
    id_lek INT PRIMARY KEY AUTO_INCREMENT,
    nazev VARCHAR(100) NOT NULL,
    kod_sukl VARCHAR(20) NOT NULL UNIQUE,
    popis TEXT,
    jednotka VARCHAR(20) NOT NULL,
    davkovani VARCHAR(100) NOT NULL
);

-- Tabulka LekarskyPredpis
CREATE TABLE LekarskyPredpis (
    id_predpis INT PRIMARY KEY AUTO_INCREMENT,
    id_pacient INT NOT NULL,
    id_zamestnanec INT NOT NULL,
    id_lek INT NOT NULL,
    datum_vystaveni DATE NOT NULL,
    mnozstvi INT NOT NULL,
    navod TEXT NOT NULL,
    FOREIGN KEY (id_pacient) REFERENCES Pacient(id_pacient),
    FOREIGN KEY (id_zamestnanec) REFERENCES Zamestnanec(id_zamestnanec),
    FOREIGN KEY (id_lek) REFERENCES Lek(id_lek)
);

-- Tabulka Komunikace - záznamy o komunikaci s pacienty
CREATE TABLE Komunikace (
    id_komunikace INT PRIMARY KEY AUTO_INCREMENT,
    id_pacient INT NOT NULL,
    id_zamestnanec INT NOT NULL,
    datum_cas DATETIME NOT NULL,
    typ VARCHAR(20) NOT NULL, -- email, telefon, osobní
    obsah TEXT NOT NULL,
    FOREIGN KEY (id_pacient) REFERENCES Pacient(id_pacient),
    FOREIGN KEY (id_zamestnanec) REFERENCES Zamestnanec(id_zamestnanec)
);

-- Tabulka Material - katalog materiálů pro zákroky
CREATE TABLE Material (
    id_material INT PRIMARY KEY AUTO_INCREMENT,
    nazev VARCHAR(100) NOT NULL,
    popis TEXT,
    mernaJednotka VARCHAR(20) NOT NULL,
    cena_za_jednotku DECIMAL(10, 2) NOT NULL
);

-- Tabulka SkladovaZasoba - evidence materiálu na skladě
CREATE TABLE SkladovaZasoba (
    id_zasoba INT PRIMARY KEY AUTO_INCREMENT,
    id_material INT NOT NULL,
    mnozstvi DECIMAL(10, 2) NOT NULL,
    datum_expirace DATE,
    sarzeCislo VARCHAR(50),
    FOREIGN KEY (id_material) REFERENCES Material(id_material)
);

-- Tabulka StavChrupu - celkový stav chrupu pacienta
CREATE TABLE StavChrupu (
    id_stav INT PRIMARY KEY AUTO_INCREMENT,
    id_pacient INT NOT NULL UNIQUE,
    datum_aktualizace DATE NOT NULL,
    celkovy_popis TEXT,
    FOREIGN KEY (id_pacient) REFERENCES Pacient(id_pacient)
);

-- Tabulka Zub - jednotlivé zuby
CREATE TABLE Zub (
    id_zub INT PRIMARY KEY AUTO_INCREMENT,
    id_stav INT NOT NULL,
    cislo_zubu INT NOT NULL, -- standardní označení zubů 11-48
    stav VARCHAR(50) NOT NULL, -- zdravý, plomba, náhrada, chybějící, apod.
    poznamka TEXT,
    FOREIGN KEY (id_stav) REFERENCES StavChrupu(id_stav),
    UNIQUE KEY (id_stav, cislo_zubu)
);

-- Tabulka ZubniOsetreni - vazba mezi zubem a provedením konkrétního zákroku
CREATE TABLE ZubniOsetreni (
    id_osetreni INT PRIMARY KEY AUTO_INCREMENT,
    id_zub INT NOT NULL,
    id_zaznam INT NOT NULL,
    id_zakrok INT NOT NULL,
    poznamka TEXT,
    FOREIGN KEY (id_zub) REFERENCES Zub(id_zub),
    FOREIGN KEY (id_zaznam) REFERENCES Zaznam(id_zaznam),
    FOREIGN KEY (id_zakrok) REFERENCES Zakrok(id_zakrok)
);
