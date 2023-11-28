INSERT INTO GENRE(ID, book_genre) VALUES (1, 'Fiction');
INSERT INTO GENRE(ID, book_genre) VALUES (2, 'Romance');
INSERT INTO GENRE(ID, book_genre) VALUES (3, 'Children');
INSERT INTO GENRE(ID, book_genre) VALUES (4, 'Scientific');
INSERT INTO GENRE(ID, book_genre) VALUES (5, 'Thriller');


INSERT INTO MOVIE (ID, title,lead_actors, director,screen_writer,release_date,genre_id,rating,is_available) VALUES ( 1, 'Inception', 'Leonardo DiCaprio, Ellen Page', 'Christopher Nolan', 'Christopher Nolan','2010-07-16', 1 , 8.8,true );
INSERT INTO MOVIE (ID, title,lead_actors, director,screen_writer,release_date,genre_id,rating,is_available) VALUES ( 2, 'The Shawshank Redemption', 'Tim Robbins, Morgan Freeman', 'Frank Darabont ', 'Frank Darabont','1994-09-23', 2 , 9.3,true );
INSERT INTO MOVIE (ID, title,lead_actors, director,screen_writer,release_date,genre_id,rating,is_available) VALUES ( 3, 'Pulp Fiction ', 'John Travolta, Uma Thurman', 'Quentin Tarantino ', 'Quentin Tarantino','2008-07-18', 5 , 7.5, false );
INSERT INTO MOVIE (ID, title,lead_actors, director,screen_writer,release_date,genre_id,rating,is_available) VALUES (4, 'The Godfather ', 'Marlon Brando, Al Pacino ', 'Francis Ford Coppola  ', 'Mario Puzo','1972-03-24', 4 , 5,true );
