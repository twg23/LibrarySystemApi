DROP TABLE IF EXISTS GENRE;

CREATE TABLE IF NOT EXISTS GENRE
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    book_genre VARCHAR(255)

);

CREATE SEQUENCE genre_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 999999999
    CYCLE;


INSERT INTO GENRE(ID, book_genre) VALUES (NEXTVAL('genre_seq'), 'Fiction');
INSERT INTO GENRE(ID, book_genre) VALUES (NEXTVAL('genre_seq'), 'Romance');
INSERT INTO GENRE(ID, book_genre) VALUES (NEXTVAL('genre_seq'), 'Children');
INSERT INTO GENRE(ID, book_genre) VALUES (NEXTVAL('genre_seq'), 'Scientific');
INSERT INTO GENRE(ID, book_genre) VALUES (NEXTVAL('genre_seq'), 'Thriller');