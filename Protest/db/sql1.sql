create sequence csv_seq
start with 1
increment by 1
nomaxvalue

create sequence type_seq
start with 1
increment by 1
maxvalue 2


drop sequence csv_seq;
drop sequence type_seq;

create table csvtest(
aptno number primary key,
sigungu varchar2(100),
bunji varchar2(100),
bon varchar2(100),
bu varchar2(100),
danji varchar2(100),
junwol varchar2(100),
myunjuk varchar2(20),
geyyaknyun varchar2(100),
geyyakil varchar2(100),
bojeung varchar2(100),
wolse varchar2(100),
cheung varchar2(100),
gunchook varchar2(100),
doromyung varchar2(100),
hit number
);
======================
create table csvtest(
aptno number primary key,
c_type number,
sigungu varchar2(100),
bunji varchar2(100),
bon varchar2(100),
bu varchar2(100),
danji varchar2(100),
junwol varchar2(100),
myunjuk varchar2(20),
geyyaknyun varchar2(100),
geyyakil varchar2(100),
bojeung varchar2(100),
wolse varchar2(100),
cheung varchar2(100),
gunchook varchar2(100),
doromyung varchar2(100),
hit number
);

drop table csvtest;

select * from csvtest;
select count(*) from csvtest;







