DROP TABLE IF EXISTS racun CASCADE;
DROP TABLE IF EXISTS proizvodjac CASCADE;
DROP TABLE IF EXISTS proizvod CASCADE;
DROP TABLE IF EXISTS stavka_racuna CASCADE;

DROP SEQUENCE IF EXISTS racun3_seq;
DROP SEQUENCE IF EXISTS proizvodjac3_seq;
DROP SEQUENCE IF EXISTS proizvod3_seq;
DROP SEQUENCE IF EXISTS stavka_racuna3_seq;

CREATE TABLE racun(
	id integer NOT NULL,
    datum date NOT NULL,
    nacin_placanja varchar(50)
);

CREATE TABLE proizvodjac(
	id integer NOT NULL,
    naziv VARCHAR(50) NOT NULL,
    adresa VARCHAR(200) NOT NULL,
    kontakt VARCHAR(100) NOT NULL
);

CREATE TABLE proizvod(
	id integer NOT NULL,
    naziv varchar(50),
    proizvodjac integer NOT NULL
);

CREATE TABLE stavka_racuna(
	id integer NOT NULL,
    redni_broj integer NOT NULL,
    kolicina numeric NOT NULL,
    jedinica_mere VARCHAR(50) NOT NULL,
    cena numeric NOT NULL,
    racun integer NOT NULL,
    proizvod integer NOT NULL
);

ALTER TABLE racun ADD CONSTRAINT PK_Racun
	PRIMARY KEY(id);
ALTER TABLE proizvodjac ADD CONSTRAINT PK_Proizvodjac
	PRIMARY KEY(id);
ALTER TABLE proizvod ADD CONSTRAINT PK_Proizvod
	PRIMARY KEY(id);
ALTER TABLE stavka_racuna ADD CONSTRAINT PK_Stavka_Racuna
	PRIMARY KEY(id);

ALTER TABLE proizvod ADD CONSTRAINT FK_Proizvod_Proizvodjac
	FOREIGN KEY (proizvodjac) REFERENCES proizvodjac (id);
ALTER TABLE stavka_racuna ADD CONSTRAINT FK_Stavka_Racuna_Proizvod
	FOREIGN KEY (proizvod) REFERENCES proizvod (id);
ALTER TABLE stavka_racuna ADD CONSTRAINT FK_Stavka_Racuna_Racun
	FOREIGN KEY (racun) REFERENCES racun (id);

CREATE INDEX IDXFK_Proizvod_Proizvodjac
	ON proizvod (proizvodjac);
CREATE INDEX IDXFK_Stavka_Racuna_Proizvod
	ON stavka_racuna (proizvod);
CREATE INDEX IDXFK_Stavka_Racuna_Racun
	ON stavka_racuna (racun);
	
CREATE SEQUENCE racun3_seq
INCREMENT 1
START 1;
CREATE SEQUENCE proizvodjac3_seq
INCREMENT 1
START 1;
CREATE SEQUENCE proizvod3_seq
INCREMENT 1
START 1;
CREATE SEQUENCE stavka_racuna3_seq
INCREMENT 1
START 1;
