CREATE TABLE IF NOT EXISTS ITEM
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    item_type VARCHAR(255),
    item_title VARCHAR(255)

);

CREATE SEQUENCE item_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 999999999
    CYCLE;

INSERT INTO ITEM (ID, item_type, item_title  ) VALUES ( NEXTVAL('item_seq'),'BOOK', 'Mary had a little lamb');
INSERT INTO ITEM (ID, item_type, item_title  ) VALUES ( NEXTVAL('item_seq'),'MOVIE', 'Inception');
INSERT INTO ITEM (ID,  item_type, item_title  ) VALUES ( NEXTVAL('item_seq'),'BOOK', 'Upon the old solid rock');
INSERT INTO ITEM (ID,  item_type, item_title  ) VALUES ( NEXTVAL('item_seq'),'PERIODICAL', 'OK Magazine');
INSERT INTO ITEM (ID, item_type, item_title  ) VALUES ( NEXTVAL('item_seq'),'PERIODICAL', 'BBC News');
INSERT INTO ITEM (ID,  item_type, item_title  ) VALUES ( NEXTVAL('item_seq'),'MOVIE', 'The Shawshank Redemption');