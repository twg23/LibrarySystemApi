CREATE TABLE IF NOT EXISTS PERIODICAL
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(255),
    periodical_name VARCHAR(255),
    publication_date VARCHAR(255)
);

CREATE SEQUENCE periodical_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 999999999
    CYCLE;

INSERT INTO PERIODICAL (ID, type, periodical_name, publication_date  ) VALUES ( NEXTVAL('periodical_seq'), 'Magazine', 'OK Magazine','2023-10-11' );
INSERT INTO PERIODICAL (ID, type, periodical_name, publication_date  ) VALUES ( NEXTVAL('periodical_seq'), 'Newspaper', 'BBC News','2023-11-20' );
INSERT INTO PERIODICAL (ID, type, periodical_name, publication_date  ) VALUES ( NEXTVAL('periodical_seq'), 'Magazine', 'Magnify','2023-02-05' );
INSERT INTO PERIODICAL (ID, type, periodical_name, publication_date  ) VALUES ( NEXTVAL('periodical_seq'), 'Newspaper', 'Sky News','2023-07-13' );
INSERT INTO PERIODICAL (ID, type, periodical_name, publication_date  ) VALUES ( NEXTVAL('periodical_seq'), 'Magazine', 'Mel Made Me Do It','2023-11-05' );
