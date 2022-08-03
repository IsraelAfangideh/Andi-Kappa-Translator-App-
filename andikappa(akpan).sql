CREATE TABLE english (
english_id serial PRIMARY KEY, 
english_word TEXT NOT null
);

CREATE TABLE efik (
efik_id serial PRIMARY KEY,
efik_word TEXT NOT null
);

CREATE TABLE X (
english_id int REFERENCES english (english_id) ON UPDATE CASCADE ON DELETE CASCADE,
efik_id int REFERENCES efik (efik_id) ON UPDATE CASCADE ON DELETE CASCADE,
Constraint x_id PRIMARY KEY (english_id, efik_id)
);

INSERT INTO english (english_word)
VALUES ('A'), ('Abandon'), ('Abandoned');

INSERT INTO english (english_word)
VALUES ('Adversity'), ('Bacon'); 

INSERT INTO efik (efik_word)
VALUES ('Has no significance in Efik, As significant in proportion: "Ke", e.g, Okuk ikie KE isua- 100 money in a year or 100 money per year'), 
('Kpöñ'), ('daha'), ('dianare'), ('yak'), ('yak nö'), ('kpoñ nö'), ('nyine'),
('Oburobut'), ('Obukpo'), ('Idiök'), ('Idiok ñkpo'), ('nan eyin'), ('afan eköñ'), ('Unam Edi');

SELECT * FROM english;
DROP TABLE efik;
DROP TABLE english;

SELECT * FROM x;

CREATE TABLE X (
english_id int REFERENCES english (english_id) ON UPDATE CASCADE ON DELETE CASCADE,
efik_id int REFERENCES efik (efik_id) ON UPDATE CASCADE ON DELETE CASCADE,
efik_word TEXT NOT NULL,
english_word TEXT NOT NULL,
Constraint x_id PRIMARY KEY (english_id, efik_id)
);

INSERT INTO x (efik_word, english_word)
VALUES ('1', '1', 'Has no significance in Efik, As significant in proportion: "Ke", e.g, Okuk ikie KE isua- 100 money in a year or 100 money per year','A'),
('Kpöñ', 'Abandon'), ('Daha', 'Abandon'), ('dianare', 'Abandon'), ('yak', 'Abandon'), ('yak nö', 'Abandon'), ('kpoñ nö', 'Abandon'), ('nyine', 'Abandon'),
('Oburobut', 'Abandoned'), ('Obukpo', 'Abandoned'), ('Idiök', 'Abandoned'), ('Idiok ñkpo', 'Adversity'), ('nan eyin', 'Adversity'), ('afan eköñ', 'Adversity'), ('Unam Edi', 'Bacon');

/* New Start, 1 table */

CREATE TABLE X (
x_id serial PRIMARY KEY,
english_word TEXT,
efik_word TEXT,
word_type TEXT, 
context TEXT
);

INSERT INTO x (english_word, efik_word, word_type, context)
VALUES ('a', 'has no significance in efik', 'determiner', 'The efik-ibibio languages do not use determiners like a cup or a dish, it does use the number one, see the efik word "kiet", and it does use the efik word "Ke" which means "per", or "in a + (insert noun here)" as in per year or in a year, etc. ');

INSERT INTO x (english_word, efik_word, word_type, context)
VALUES ('a', 'ke', 'prepositon', '')

SELECT * FROM x WHERE english_word = lower('A');
SELECT * FROM x WHERE efik_word = lower('KE');

TRUNCATE TABLE x;

INSERT INTO x (english_word, efik_word, word_type, context)
VALUES ('a', 'has no significance in efik', 'determiner', 'The efik-ibibio languages do not use determiners like a cup or a dish, it does use the number one, see the efik word "kiet", and it does use the efik word "Ke" which means "per", or "in a + (insert noun here)" as in per year or in a year, etc. ');

INSERT INTO x (english_word, efik_word, word_type, context)
VALUES ('a', 'ke', 'prepositon', '')

SELECT * FROM x WHERE english_word = lower('A');
SELECT * FROM x WHERE efik_word = lower('KE');


