CREATE TABLE IF NOT EXISTS AUTHOR
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)

);

CREATE SEQUENCE author_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 999999999
    CYCLE;

INSERT INTO AUTHOR (ID, name) VALUES ( NEXTVAL('author_seq'), 'Wole Shoyinka' );
INSERT INTO AUTHOR (ID, name) VALUES ( NEXTVAL('author_seq'), 'Tolani Shoneye' );
INSERT INTO AUTHOR (ID, name) VALUES ( NEXTVAL('author_seq'), 'Lani Good' );
INSERT INTO AUTHOR (ID, name) VALUES ( NEXTVAL('author_seq'), 'Milena Sanchez' );
