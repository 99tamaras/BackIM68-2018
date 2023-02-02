INSERT INTO "proizvodjac"("id", "naziv", "adresa", "kontakt")
VALUES(nextval('proizvodjac3_seq'), 'AD Imlek', 'Industrijsko naselje bb, Padinska skela, Beograd', '+381 11 30 50 505');
INSERT INTO "proizvodjac"("id", "naziv", "adresa", "kontakt")
VALUES(nextval('proizvodjac3_seq'), 'Henkel Srbija', 'Bulevar oslobodenja 383, 11040 Beograd, Srbija', '+381 11 20 72 200');
INSERT INTO "proizvodjac"("id", "naziv", "adresa", "kontakt")
VALUES(nextval('proizvodjac3_seq'), 'Fruit D.O.O.', 'Justina Popovica 3, 11080 Zemun, Beograd', '+381 11 3143 171');
INSERT INTO "proizvodjac"("id", "naziv", "adresa", "kontakt")
VALUES(nextval('proizvodjac3_seq'), 'CENTROPROIZVOD', 'DOBANOVACKI PUT B.B. 11271, SURCIN', '+381 11 3773 600');

INSERT INTO "racun"("id", "datum")
VALUES(nextval('racun3_seq'), to_date('01.03.2017.', 'dd.mm.yyyy.'));
INSERT INTO "racun"("id", "datum")
VALUES(nextval('racun3_seq'), to_date('06.03.2017.', 'dd.mm.yyyy.'));
INSERT INTO "racun"("id", "datum")
VALUES(nextval('racun3_seq'), to_date('08.03.2017.', 'dd.mm.yyyy.'));
INSERT INTO "racun"("id", "datum")
VALUES(nextval('racun3_seq'), to_date('07.03.2017.', 'dd.mm.yyyy.'));



INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES (nextval('proizvod3_seq'), 'mleko',1);
INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES (nextval('proizvod3_seq'), 'jogurt',1);
INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES (nextval('proizvod3_seq'),'jabuka', 2 );
INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES (nextval('proizvod3_seq'), 'prasak',2);
INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES (nextval('proizvod3_seq'), 'jagoda',2 );

INSERT INTO "stavka_racuna"("id", "proizvod", "redni_broj", "racun", "kolicina", "jedinica_mere", "cena")
VALUES (nextval('stavka_racuna3_seq'), 1, 1, 1, 20, 'komad', 100);
INSERT INTO "stavka_racuna"("id", "proizvod", "redni_broj", "racun", "kolicina", "jedinica_mere", "cena")
VALUES (nextval('stavka_racuna3_seq'), 1, 2, 1, 30, 'komad', 150);
INSERT INTO "stavka_racuna"("id", "proizvod", "redni_broj", "racun", "kolicina", "jedinica_mere", "cena")
VALUES (nextval('stavka_racuna3_seq'), 1, 3, 1, 15, 'komad', 500);


