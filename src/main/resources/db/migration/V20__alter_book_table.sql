DROP TABLE IF EXISTS BOOK;

CREATE TABLE IF NOT EXISTS BOOK
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    author_id BIGINT NOT NULL,
    genre VARCHAR(255),
    is_available BOOLEAN

);


INSERT INTO BOOK (ID, title, author_id, genre,is_available) VALUES ( NEXTVAL('book_seq'), 'Mary had a little lamb',1 , 'FICTION',true);
INSERT INTO BOOK (ID, title, author_id, genre,is_available) VALUES ( NEXTVAL('book_seq'), 'Blah Blah sheep',2 , 'THRILLER',true);
INSERT INTO BOOK (ID, title, author_id, genre, is_available) VALUES ( NEXTVAL('book_seq'), 'Upon the old solid rock',3, 'ACTION',true);
INSERT INTO BOOK (ID, title, author_id, genre,is_available) VALUES ( NEXTVAL('book_seq'), 'Mirror Mirror',1 , 'SCIENTIFIC',true);

