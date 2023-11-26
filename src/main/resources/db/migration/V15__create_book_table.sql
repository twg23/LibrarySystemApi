    CREATE TABLE IF NOT EXISTS BOOK
    (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     title VARCHAR(255),
    author_id BIGINT NOT NULL,
    genre_id BIGINT NOT NULL
);

    CREATE SEQUENCE book_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 999999999
    CYCLE;

    INSERT INTO BOOK (ID, title, author_id, genre_id) VALUES ( NEXTVAL('book_seq'), 'Mary had a little lamb',1 , 4);
    INSERT INTO BOOK (ID, title, author_id, genre_id) VALUES ( NEXTVAL('book_seq'), 'Blah Blah sheep',2 , 3);
    INSERT INTO BOOK (ID, title, author_id, genre_id) VALUES ( NEXTVAL('book_seq'), 'Upon the old solid rock',3, 5);
    INSERT INTO BOOK (ID, title, author_id, genre_id) VALUES ( NEXTVAL('book_seq'), 'Mirror Mirror',1 , 2);
