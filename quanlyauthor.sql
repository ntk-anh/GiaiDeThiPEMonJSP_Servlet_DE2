create database quanlyauthor;
use quanlyauthor;

create table author(
	authorid int,
    authorname varchar(20),
    primary key(authorid)
);
create table article(
	articleid int,
    articlename varchar(20),
    articledate date,
    primary key(articleid)
);

create table author_article(
	authorid int,
    articleid int,
    primary key(authorid,articleid),
    foreign key(authorid) references author(authorid),
    foreign key(articleid) references article(articleid)
);

insert into article
values  (1000,"Article 1000","2000-12-25"),
		(1001,"Article 1001","1996-09-08"),
		(1002,"Article 1002","1995-03-02");
        
insert into author
values  (1000,"mr A"),
		(1001,"mr B"),
		(1002,"mr C");

 
insert into author_article
values  (1000,1000),
		(1000,1001),
		(1000,1002),
		(1002,1002);
        
select article.*
from article 
join author_article on article.articleid=author_article.articleid
where authorid=1002;