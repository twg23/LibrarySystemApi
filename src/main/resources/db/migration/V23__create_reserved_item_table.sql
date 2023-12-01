DROP TABLE IF EXISTS BOOKING;

CREATE TABLE IF NOT EXISTS RESERVED_ITEM
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    item_type VARCHAR(255),
    date  VARCHAR(255),
    period INT NOT NULL,
    user_id BIGINT NOT NULL
);

CREATE SEQUENCE reserved_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 999999999
    CYCLE;

INSERT INTO RESERVED_ITEM (ID,item_type, date, period,user_id) VALUES ( NEXTVAL('reserved_seq'),'BOOK',   '30/10/2023',7,1);
INSERT INTO RESERVED_ITEM (ID,item_type, date, period,user_id) VALUES ( NEXTVAL('reserved_seq'),'MOVIE',  '12/10/2023',7,3);
INSERT INTO RESERVED_ITEM (ID,item_type, date, period,user_id) VALUES ( NEXTVAL('reserved_seq'),'PERIODICAL',  '01/10/2023',7,2);
