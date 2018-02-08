/* 게시판 */
CREATE TABLE BOARD (
	SEQ NUMBER NOT NULL, /* 글번호 */
	NAME VARCHAR2(10), /* 작성자이름 */
	ID VARCHAR2(16) NOT NULL, /* 작성자아이디 */
	EMAIL VARCHAR2(50), /* 작성자이메일 */
	SUBJECT VARCHAR2(100) NOT NULL, /* 제목 */
	CONTENT CLOB, /* 내용 */
	HIT NUMBER DEFAULT 0, /* 조회수 */
	LOGTIME DATE DEFAULT SYSDATE, /* 작성일자 */
	BCODE NUMBER /* 게시판번호 */
);

CREATE UNIQUE INDEX PK_BOARD
	ON BOARD (
		SEQ ASC
	);

ALTER TABLE BOARD
	ADD
		CONSTRAINT PK_BOARD
		PRIMARY KEY (
			SEQ
		);

COMMENT ON TABLE BOARD IS '게시판';

COMMENT ON COLUMN BOARD.SEQ IS '글번호';

COMMENT ON COLUMN BOARD.NAME IS '작성자이름';

COMMENT ON COLUMN BOARD.ID IS '작성자아이디';

COMMENT ON COLUMN BOARD.EMAIL IS '작성자이메일';

COMMENT ON COLUMN BOARD.SUBJECT IS '제목';

COMMENT ON COLUMN BOARD.CONTENT IS '내용';

COMMENT ON COLUMN BOARD.HIT IS '조회수';

COMMENT ON COLUMN BOARD.LOGTIME IS '작성일자';

COMMENT ON COLUMN BOARD.BCODE IS '게시판번호';

CREATE SEQUENCE BOARD_SEQ
START WITH 1 INCREMENT BY 1 NOCACHE;