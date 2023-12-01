DROP TABLE IF EXISTS BOOK;

CREATE TABLE IF NOT EXISTS BOOK
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    author_id BIGINT NOT NULL,
    genre VARCHAR(255),
    quantity INT NOT NULL,
    is_available BOOLEAN

);

CREATE SEQUENCE book_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 999999999
    CYCLE;


INSERT INTO BOOK (ID, title, author_id, genre,quantity,is_available) VALUES ( NEXTVAL('book_seq'), 'Mary had a little lamb',1 , 'FICTION',4,true);
INSERT INTO BOOK (ID, title, author_id, genre,quantity,is_available) VALUES ( NEXTVAL('book_seq'), 'Blah Blah sheep',2 , 'THRILLER',5,true);
INSERT INTO BOOK (ID, title, author_id, genre, quantity,is_available) VALUES ( NEXTVAL('book_seq'), 'Upon the old solid rock',3, 'ACTION',5,true);
INSERT INTO BOOK (ID, title, author_id, genre,quantity,is_available) VALUES ( NEXTVAL('book_seq'), 'Mirror Mirror',1 , 'SCIENTIFIC',4,true);

