START TRANSACTION;
insert into author(authorId,authorName, nationality, birthDate) values(1,'Jozsef Attila','Hungarian',Date('1905-04-11'));
insert into author(authorId,authorName, nationality, birthDate) values(2,'William Shakespeare','British',Date('1564-04-23'));
insert into author(authorId,authorName, nationality, birthDate) values(3,'Ady Endre','Hungarian',Date('1877-11-22'));


insert into book(bookId, title) values (1,'Romeo and Juliet');

insert into bookAuthor values(1,2);

insert into genre values('Romance',1);

COMMIT;