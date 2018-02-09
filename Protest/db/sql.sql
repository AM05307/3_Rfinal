시군구	번지	단지명	전월세구분	전용면적(㎡)	계약일	보증금(만원)	월세(만원)	층	건축년도	도로명

drop table;
CREATE TABLE departments (
  ID           NUMBER(10)    NOT NULL,
  DESCRIPTION  VARCHAR2(50)  NOT NULL);

CREATE SEQUENCE dept_seq START WITH 1;

CREATE OR REPLACE TRIGGER dept_bir
BEFORE INSERT ON departments 
FOR EACH ROW
BEGIN
  SELECT dept_seq.NEXTVAL
  INTO   : new.id
  FROM   dual
END;

INSERT INTO departments (DESCRIPTION) VALUES ('k123');
select * from departments;


create sequence seq_inc increment by 1 start with 1;

 drop table apt;
 drop table jun;
 
select * from apt;
 
create table apt (
no number ,
si varchar2(100),
gun varchar2(100),
gu varchar2(100),
bunji varchar2(100),
danji varchar2(100),
myunjuk number,
cheung number,
gunchook number,
doromyung varchar2(100));

drop sequence seq_num;
create sequence seq_num start with 1;

CREATE OR REPLACE TRIGGER apt_no
BEFORE INSERT ON apt_t
FOR EACH ROW
 
BEGIN
  SELECT seq_inc.nextval
  INTO   :new.aptno
  FROM   dual
END;

drop table apt_t;

create table apt_t (
aptno number,
aptname varchar2(10));

insert into apt_t (aptname) values ('kang');
insert into apt_t (aptname) values ('kim');

select * from apt_t;

create table apt (
no number ,
sigungu varchar2(100),
bunji varchar2(100),
danji varchar2(100),
myunjuk number,
cheung number,
gunchook number,
doromyung varchar2(100));

create table jun(
no number,
junwol varchar2(100),
gyeyak varchar2(100),
bojeung number,
wolse number);

insert into APT values(sigungu, bunji, danji, 1,2, 3,doromyung);

select * from apt;
select count(*) from apt;
select * from jun;

select sigungu, bunji, danji, myunjuk,cheung, gunchook,	doromyung from apt;

delete from apt where no > 11;
delete from jun where no > 11;
===================== csv input
create table csvtest(
sigungu varchar2(100),
bunji varchar2(100),
bon varchar2(100),
bu varchar2(100),
danji varchar2(100),
junwol varchar2(100),
myunjuk varchar2(100),
geyyaknyun varchar2(100),
geyyakil varchar2(100),
bojeung varchar2(100),
wolse varchar2(100),
cheung varchar2(100),
gunchook varchar2(100),
doromyung varchar2(100)
);


drop table csvtest;
select count(*) from csvtest;
select * from csvtest;

drop table csvtest;

create table csvtest(
sigungu varchar2(100),
bunji varchar2(20),
bon varchar2(20),
bu number,
danji varchar2(100),
junwol varchar2(100),
myunjuk number,
geyyaknyun number,
geyyakil varchar2(100),
bojeung number,
wolse number,
cheung number,
gunchook number,
doromyung varchar2(100)
);

==================== sequence
create sequence csv_seq
start with 1
increment by 1
nomaxvalue

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
doromyung varchar2(100)
);

select * from csvtest;
select count(*) from csvtest;




drop sequence csv_seq;
drop table csvtest;

create table seq_test01(
no number primary key,
remark varchar2(10) );

create sequence seq_seq_teest01_no;

insert into seq_test01(no,remark)
values(seq_seq_teest01_no.nextval,'연습');

select * from seq_test01

select seq from dual;


create sequence csv_seq minvalue 1 maxvalue 9999999999 increment 
by 1 start with 1 cache 20 noorder nocycle;



create
or replace trigger dual_1_triggerq
before insert
on csvtest
referencing new as new
for each row
begin select seq_dual.nextval into :new.aptno from csvtest;
end;


CREATE OR REPLACE TRIGGER csvtest_type_trigger1
BEFORE
INSERT ON csvtest
REFERENCING NEW AS NEW
FOR EACH ROW
BEGIN
INSERT INTO csvtest(c_type) values (0);
END;

INSERT INTO csvtest(c_type) values ('0');

desc;
select * from APTINFO;
select * from aptinfo;

select * from user;