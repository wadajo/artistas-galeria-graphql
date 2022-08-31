INSERT INTO obras (titulo,precio) VALUES ('Poemas para leer frente al espejo',1000);
INSERT INTO obras (titulo,precio) VALUES ('Que aparezca Maresca',1200);
INSERT INTO obras (titulo,precio) VALUES ('Trampa de vocales',1300);

INSERT INTO artistas (apellido,nacimiento) VALUES ('Levstein',1991);
INSERT INTO artistas (apellido,nacimiento) VALUES ('Kovensky',1993);
INSERT INTO artistas (apellido,nacimiento) VALUES ('Casile',1992);
INSERT INTO artistas (apellido,nacimiento) VALUES ('Arrigoni',1985);

-- para poblar las artistas de las obras en la primera carga
UPDATE obras SET artista_id=1 WHERE obra_id=1;
UPDATE obras SET artista_id=2 WHERE obra_id=2;
UPDATE obras SET artista_id=3 WHERE obra_id=3;