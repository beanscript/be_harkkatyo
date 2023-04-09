SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS auto;
DROP TABLE IF EXISTS projekti;
DROP TABLE IF EXISTS tila;
DROP TABLE IF EXISTS kayttaja;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE auto
(autoid BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
, merkki VARCHAR(100) NOT NULL
, malli VARCHAR(100) NOT NULL
, vuosi BIGINT
, rekno VARCHAR(7)
, tiedot VARCHAR(15)
, hinta BIGINT
, kuva VARCHAR(500)
);

INSERT INTO auto (merkki, malli, vuosi, rekno, tiedot, hinta, kuva)
VALUES ("Hyundai", "Veloster", 2013, "1.6l Turbo", 12700, "http://impoliteorange.altervista.org/koulu/velo/IMG_3035-final.jpg")
, ("Dodge", "Challenger Hellcat", 2018, "V8 Supercharged", 60000, "http://impoliteorange.altervista.org/koulu/velo/hellcat.jpg");

CREATE TABLE tila
(tilaid BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
, nimike VARCHAR(100) NOT NULL
);

INSERT INTO tila (nimike)
VALUES ("Valmis"), ("Kesken"), ("Tulossa");

CREATE TABLE projekti (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
, nimi VARCHAR(50) NOT NULL
, osat VARCHAR(200)
, kuvaus VARCHAR(200)
, kustannukset BIGINT
, autoid BIGINT
, FOREIGN KEY (autonid) REFERENCES auto(autoid)
, FOREIGN KEY (tilanid) REFERENCES tila(tilaid));

INSERT INTO car (nimi, osat, kuvaus, kustannukset, autorekno, tilanid)
VALUES ("Teippausta", "Inozek Vampire Red, mattamustaa, kiiltävän mustaa autoteippiä", "Teipataan auton etulippa, sivut, takapaneeli, peilit ja spoikka", 500.00, 1, 1),
("Vanteet", "8x18 et40, 225/40/18", "Uudet kesävanteet", 380.00, 1, 1), ("Spoileri", "spoileri, teippiä", "Spoikan tilaus ja asennus", 570.00, 1, 1), ("Cold air intake", "K&N cold air intake kit", "Moottorin ilmansuodatinjärjestelmän vaihto", 400.00, 1, 3), ("Putkisto", "MagnaFlow 2017-2023 Dodge Challenger xMOD Series Cat-Back Performance Exhaust System", "sporttiputkisto", 3000.00, 2, 3);

CREATE TABLE kayttaja
(kayttajaid BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
, nimi VARCHAR(20) NOT NULL
, rooli VARCHAR(20) NOT NULL
, tunnus VARCHAR(50) NOT NULL
, salasana VARCHAR(250) NOT NULL);

INSERT INTO kayttaja (nimi, tunnus, salasana, rooli)
VALUES ('Minna', 'user',
'$2a$10$pRGLapVsL1uKwMxLOCb16eOdN7YDlOZU3zPISEaViCGRm2cMIcypa', 'USER'),
('Elia', 'admin',
'$2a$10$bMFMIA5G2G8xQIHn76g/ReT3Tg2D8TaxwYIhhAtbS6UBRz7p7wNbC', 'ADMIN');

SELECT * FROM auto;
SELECR * FROM tila;
SELECT * FROM projekti;
SELECT * FROM kayttaja;