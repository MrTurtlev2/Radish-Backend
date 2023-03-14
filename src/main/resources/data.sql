INSERT INTO User (id,email, password, name, last_name) VALUES
    (1, 'm.wojnar@onet.pl', '$2akkk', 'Marek', 'Wojnar'),
    (2, 'michald@ont.pl', '$2appp', 'Michał', 'Dolas');


INSERT INTO Plant (id, description, name, user_id) VALUES
    (1,'suchy', 'kaktus', 1),
    (2,'suchy2', 'kaktus2', 1),
    (3,'suchy3', 'kaktus3', 1),
    (4,'suchy4', 'kaktus4', 2);
