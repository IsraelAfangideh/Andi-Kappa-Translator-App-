CREATE TABLE english (
english_id serial PRIMARY KEY, 
english_word TEXT
);

CREATE TABLE efik (
efik_id serial,
efik_word TEXT,
english_id_fk int REFERENCES english (english_id)
);

INSERT INTO english (english_word)
VALUES ('A'), ('Abandon'), ('Abandoned'); --('Abandoning'), ('Abase'), ('Abased'), ('Abasement')

--ööööööööööööö  -- ññññññññññññññññ
INSERT INTO efik (efik_word, english_id_fk)
VALUES ('Has no significance in Efik, As significant in proportion: "Ke", e.g, Okuk ikie KE isua- 100 money in a year or 100 money per year', 1), 
('Kpöñ', 2), ('daha', 2), ('dianare', 2), ('yak', 2), ('yak nö', 2), ('kpoñ nö', 2), ('nyine', 2),
('Oburobut', 3), ('Obukpo', 3), ('Idiök', 3), ('Idiok ñkpo', 4), ('nan eyin', 4), ('afan eköñ', 4), ('Unam Edi', 5);


--Select Statements
SELECT * FROM english FULL OUTER JOIN efik ON english_id_fk = english_id;

SELECT * FROM english INNER JOIN efik ON english_id_fk = english_id;

SELECT * FROM english INNER JOIN efik ON english_id_fk = english_id WHERE english_id = 1;
SELECT * FROM english INNER JOIN efik ON english_id_fk = english_id WHERE english_id = 2;
SELECT * FROM english INNER JOIN efik ON english_id_fk = english_id WHERE english_id = 3;

SELECT * FROM english INNER JOIN efik ON english_id_fk = english_id WHERE english_word = 'A';
SELECT * FROM english;
CREATE TABLE users (
username TEXT,
PASSWORD TEXT 
);

INSERT INTO users (username, password)
VALUES ('username', 'password');

SELECT * FROM users;


INSERT INTO english (english_word)
VALUES ('Adversity'), ('Bacon'); 

SELECT * FROM english;

DROP TABLE english;

SELECT * FROM english;
