INSERT INTO obras (titulo,precio) VALUES ('Poemas para leer frente al espejo',1000);
INSERT INTO obras (titulo,precio) VALUES ('Que aparezca Maresca',1200);
INSERT INTO obras (titulo,precio) VALUES ('Trampa de vocales',1300);

INSERT INTO artistas (apellido) VALUES ('Levstein');
INSERT INTO artistas (apellido) VALUES ('Kovensky');
INSERT INTO artistas (apellido) VALUES ('Casile');
INSERT INTO artistas (apellido) VALUES ('Arrigoni');

-- para poblar las artistas de las obras en la primera carga
UPDATE obras SET artista_id=1 WHERE obra_id=1;
UPDATE obras SET artista_id=2 WHERE obra_id=2;
UPDATE obras SET artista_id=3 WHERE obra_id=3;