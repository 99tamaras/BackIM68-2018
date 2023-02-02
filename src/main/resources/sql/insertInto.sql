INSERT INTO "proizvodjac"("id", "naziv", "adresa", "kontakt")
VALUES(nextval('proizvodjac_seq'), 'AD Imlek', 'Industrijsko naselje bb, Padinska skela, Beograd', '+381 11 30 50 505');
INSERT INTO "proizvodjac"("id", "naziv", "adresa", "kontakt")
VALUES(nextval('proizvodjac_seq'), 'Henkel Srbija', 'Bulevar oslobodenja 383, 11040 Beograd, Srbija', '+381 11 20 72 200');
INSERT INTO "proizvodjac"("id", "naziv", "adresa", "kontakt")
VALUES(nextval('proizvodjac_seq'), 'Fruit D.O.O.', 'Justina Popovica 3, 11080 Zemun, Beograd', '+381 11 3143 171');
INSERT INTO "proizvodjac"("id", "naziv", "adresa", "kontakt")
VALUES(nextval('proizvodjac_seq'), 'CENTROPROIZVOD', 'DOBANOVACKI PUT B.B. 11271, SURCIN', '+381 11 3773 600');

INSERT INTO "racun"("id", "datum")
VALUES(nextval('racun_seq'), to_date('01.03.2017.', 'dd.mm.yyyy.'));
INSERT INTO "racun"("id", "datum")
VALUES(nextval('racun_seq'), to_date('06.03.2017.', 'dd.mm.yyyy.'));
INSERT INTO "racun"("id", "datum")
VALUES(nextval('racun_seq'), to_date('08.03.2017.', 'dd.mm.yyyy.'));
INSERT INTO "racun"("id", "datum")
VALUES(nextval('racun_seq'), to_date('07.03.2017.', 'dd.mm.yyyy.'));


INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES (nextval('proizvod_seq'), 'mleko',9);
INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES (nextval('proizvod_seq'), 'jogurt',9);
INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES (nextval('proizvod_seq'),'jabuka', 11 );
INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES (nextval('proizvod_seq'), 'prasak',10);
INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES (nextval('proizvod_seq'), 'jagoda',11 );

INSERT INTO "stavka_racuna"("id", "proizvod", "redni_broj", "racun", "kolicina", "jedinica_mere", "cena")
VALUES (nextval('stavka_racuna_seq'), 9, 1, 9, 20, 'komad', 100);
INSERT INTO "stavka_racuna"("id", "proizvod", "redni_broj", "racun", "kolicina", "jedinica_mere", "cena")
VALUES (nextval('stavka_racuna_seq'), 9, 2, 10, 30, 'komad', 150);
INSERT INTO "stavka_racuna"("id", "proizvod", "redni_broj", "racun", "kolicina", "jedinica_mere", "cena")
VALUES (nextval('stavka_racuna_seq'), 9, 3, 11, 15, 'komad', 500);

INSERT INTO "stavka_racuna"("id", "proizvod", "redni_broj", "racun", "kolicina", "jedinica_mere", "cena")
VALUES (nextval('stavka_racuna_seq'), 10, 1, 9, 30, 'komad', 1000);
INSERT INTO "stavka_racuna"("id", "proizvod", "redni_broj", "racun", "kolicina", "jedinica_mere", "cena")
VALUES (nextval('stavka_racuna_seq'), 10, 2, 10, 18, 'komad', 1300);
INSERT INTO "stavka_racuna"("id", "proizvod", "redni_broj", "racun", "kolicina", "jedinica_mere", "cena")
VALUES (nextval('stavka_racuna_seq'), 10, 3, 11, 20, 'komad', 500);

INSERT INTO "stavka_racuna"("id", "proizvod", "redni_broj", "racun", "kolicina", "jedinica_mere", "cena")
VALUES (nextval('stavka_racuna_seq'), 9, 1, 9, 30, 'kg', 200);
INSERT INTO "stavka_racuna"("id", "proizvod", "redni_broj", "racun", "kolicina", "jedinica_mere", "cena")
VALUES (nextval('stavka_racuna_seq'), 10, 2, 10, 50, 'kg', 80);
INSERT INTO "stavka_racuna"("id", "proizvod", "redni_broj", "racun", "kolicina", "jedinica_mere", "cena")
VALUES (nextval('stavka_racuna_seq'), 11, 3, 11, 25, 'kg', 130);

INSERT INTO "stavka_racuna"("id", "proizvod", "redni_broj", "racun", "kolicina", "jedinica_mere", "cena")
VALUES (nextval('stavka_racuna_seq'), 9, 1, 9, 5, 'kg', 300);
INSERT INTO "stavka_racuna"("id", "proizvod", "redni_broj", "racun", "kolicina", "jedinica_mere", "cena")
VALUES (nextval('stavka_racuna_seq'), 10, 2, 10, 2, 'kg', 500);
INSERT INTO "stavka_racuna"("id", "proizvod", "redni_broj", "racun", "kolicina", "jedinica_mere", "cena")
VALUES (nextval('stavka_racuna_seq'), 11, 3, 11, 3, 'kg', 400);

INSERT INTO "stavka_racuna"("id", "proizvod", "redni_broj", "racun", "kolicina", "jedinica_mere", "cena")
VALUES (nextval('stavka_racuna_seq'), 9, 1, 9, 10, 'kg', 300);
INSERT INTO "stavka_racuna"("id", "proizvod", "redni_broj", "racun", "kolicina", "jedinica_mere", "cena")
VALUES (nextval('stavka_racuna_seq'), 10, 2, 10, 10, 'kg', 500);
