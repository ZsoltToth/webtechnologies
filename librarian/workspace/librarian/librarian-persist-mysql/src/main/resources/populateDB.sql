START TRANSACTION;
insert into author(authorName, nationality, birthDate) values('Jozsef Attila','Hungarian',Date('1892-12-25'));
insert into author(authorName, nationality, birthDate) values('William Shakespeare','British',Date('1392-01-15'));
insert into author(authorName, nationality, birthDate) values('Ady Endre','Hungarian',Date('1912-05-05'));
COMMIT;