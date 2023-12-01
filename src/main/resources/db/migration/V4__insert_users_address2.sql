CREATE SEQUENCE address_t_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 999999999
    CYCLE;


INSERT INTO ADDRESS_T (ID, LINE_ONE, CITY, POST_CODE, COUNTRY) VALUES (  NEXTVAL('address_t_seq'),'43 Jenson street', 'Nottingham', 'NG6 5TY','UK' );
INSERT INTO ADDRESS_T (ID, LINE_ONE, CITY, POST_CODE, COUNTRY) VALUES ( NEXTVAL('address_t_seq'),'65 Broadson street', 'Nottingham', 'NG8 9TY','UK' );
INSERT INTO ADDRESS_T (ID, LINE_ONE, CITY, POST_CODE, COUNTRY) VALUES ( NEXTVAL('address_t_seq'),'73 Rhysen street', 'Nottingham', 'NG76OY','UK' );

INSERT INTO USER_T (ID, NAME, PHONE_NUMBER,EMAIL) VALUES ( NEXTVAL('user_t_seq'),'Tolu Adetomiwa','07347284950', 'toluadetomiwa@gmail.com' );
INSERT INTO USER_T (ID, NAME, PHONE_NUMBER,EMAIL) VALUES ( NEXTVAL('user_t_seq'),'Tise Oludayomi','07347583840', 'tiseoludayomi@gmail.com' );
INSERT INTO USER_T (ID, NAME, PHONE_NUMBER,EMAIL) VALUES ( NEXTVAL('user_t_seq'),'Dami Bankole','07347254780', 'damibankole@gmail.com' );