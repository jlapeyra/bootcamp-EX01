
insert into user (username, email, password_hash) values ('jlapeyra', 'jl@exemple.com', 'giufh3378rgf8qvdx93v8')
insert into user (username, email, password_hash) values ('jmarin', 'jm@exemple.com', 'ibvcave8ovd23fvc8vce7')
insert into user (username, email, password_hash) values ('jsmith', 'js@exemple.com', '483ufvbeciueiubq349fv')

insert into game (name) values ('Minecraft')
insert into game (name) values ('League of Legends')

insert into party (name, game) values ('Party Minecraft 1', 1)
insert into party (name, game) values ('Party Minecraft 2', 1)
insert into party (name, game) values ('Party LOL', 2)

insert into message (text, timestamp, sender, party) values ('Hola', NOW(), 1, 1)
insert into message (text, timestamp, sender, party) values ('Comencem?', NOW(), 2, 1)
insert into message (text, timestamp, sender, party) values ('Si', NOW(), 1, 1)

