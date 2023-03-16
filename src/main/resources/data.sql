INSERT INTO User (id,email, password, name, last_name) VALUES
    (1, 'm.wojnar@onet.pl', '$2a$12$m7fwXE0fhOxy4IBjovBMTew/RtVY0.eQCTr94CT.vFmBQgT.f27vC', 'Marek', 'Wojnar'),
    (2, 'michald@ont.pl', '$2a$12$39wKHsMQcXHAv61aViwYhe4FtQVXSimnV4cDAjXXdumR16hoMv6Ou', 'Michał', 'Dolas');


INSERT INTO Plant (id, description, name, user_id) VALUES
    (1,'suchy', 'kaktus', 1),
    (2,'suchy2', 'kaktus2', 1),
    (3,'suchy3', 'kaktus3', 1),
    (4,'suchy4', 'kaktus4', 2);
