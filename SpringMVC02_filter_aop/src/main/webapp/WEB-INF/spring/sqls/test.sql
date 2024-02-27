DROP TABLE MYBOARD;

create table MYBOARD(
	MYNO INT auto_increment primary key,
	MYNAME VARCHAR(500) not null,
	MYTITLE VARCHAR(1000) not null,
	MYCONTENT VARCHAR(4000) not null,
	MYDATE DATE not NULL
);

insert into MYBOARD VALUES(null, '관리자','스프링 테스트', 'SPRING MVC 재밌다!!....',NOW());

select * from MYBOARD order by MYNO desc;



