create table if not exists author  (
authorId integer auto_increment primary key,
authorName varchar(50) not null,
nationality varchar(20),
birthDate date
)
engine=MyISAM;

create table if not exists book(
bookId integer auto_increment primary key,
title varchar(50) not null
)
engine=MyISAM;

create table if not exists genre(
genre varchar(20),
book integer,
foreign key (book) references book(bookId) on delete cascade
)
engine=MyISAM;

create table if not exists bookAuthor(
bookId integer,
authorId integer,
primary key (bookId,authorId),
foreign key (bookId) references book(bookId) on delete cascade,
foreign key (authorId) references author(authorId) on delete cascade
)
engine=MyISAM;

create table if not exists bookInstance(
inventoryNo integer auto_increment primary key,
instanceOfBook integer,
price double,
foreign key (instanceOfBook) references book(bookId) on delete cascade
)
engine=MyISAM;