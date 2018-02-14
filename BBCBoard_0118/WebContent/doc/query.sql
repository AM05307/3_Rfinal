-- 게시판 목록
select bl.bcode, bl.bname, bl.btype, c.ccode, c.cname,
		decode(bl.btype, 5, 'reboard',
						 6, 'album',
 						 7, 'bbs',
						 'board') controller 
from board_list bl, category c
where bl.ccode = c.ccode
order by bl.bcode;


-------------------- 답변형 게시판 ----------------------
-- 글작성
insert all
	into board (seq, name, id, email, subject, content, hit, logtime, bcode)
	values (?, ?, ?, ?, ?, ?, 0, sysdate, ?)
	into reboard (rseq, seq, ref, lev, step, pseq, reply)
	values (reboard_rseq.nextval, ?, ?, 0, 0, 0, 0)
select * from dual

-- 글보기
select b.seq, b.name, b.id, b.email, b.subject, 
		b.content, b.hit, b.logtime, b.bcode, 
		r.rseq, r.ref, r.lev, r.step, r.pseq, r.reply
from board b, reboard r
where b.seq = r.seq
and b.seq = ?

-- 글목록
-- page당 20개씩 출력
-- 오늘쓴글 O 12:25:53
--       X 17.11.23
select b.*
from (
	  select rownum rn, a.*
	  from (
	  	  select  b.seq, b.name, b.id, b.email, b.subject, 
			  	  b.content, b.hit, b.bcode,
				  case 
					when to_char(b.logtime, 'yymmdd') = to_char(sysdate, 'yymmdd')
					then to_char(b.logtime, 'hh24:mi:ss')
					else to_char(b.logtime, 'yy.mm.dd')
				  end logtime, 
			  	  r.rseq, r.ref, r.lev, r.step, r.pseq, r.reply
	  	  from board b, reboard r
	  	  where b.seq = r.seq
	  	  and bcode = 3
	  	  order by seq desc
	 	  ) a
	  where rownum <= 20
	 ) b
where b.rn > 0


-- 새글수
select count(seq) 
from board
where bcode = ?
and to_char(logtime, 'yymmdd') = to_char(sysdate, 'yymmdd')

-- 전체글수 
select count(seq) 
from board
where bcode = ?
and key = word









select  * from member;




