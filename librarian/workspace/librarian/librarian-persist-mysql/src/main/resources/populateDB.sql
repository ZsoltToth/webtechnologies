START TRANSACTION;
insert into author(authorName, nationality, birthDate) values('Jozsef Attila','Hungarian',Date('1905-04-11'));
insert into author(authorName, nationality, birthDate) values('William Shakespeare','British',Date('1564-04-23'));
insert into author(authorName, nationality, birthDate) values('Ady Endre','Hungarian',Date('1877-11-22'));


insert into book(title) values ('Romeo and Juliet');

insert into genre values('Romance',1);

COMMIT;