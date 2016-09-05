create database librarian;

create user lily identified by 'lily';

grant all on librarian.* to 'lily' with grant option;