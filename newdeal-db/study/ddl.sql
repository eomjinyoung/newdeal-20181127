-- 수강신청
DROP TABLE IF EXISTS nd_appl RESTRICT;

-- 수업
DROP TABLE IF EXISTS nd_lesn RESTRICT;

-- 강사
DROP TABLE IF EXISTS nd_tchr RESTRICT;

-- 수강생
DROP TABLE IF EXISTS nd_stud RESTRICT;

-- 매니저
DROP TABLE IF EXISTS nd_mgr RESTRICT;

-- 강의실
DROP TABLE IF EXISTS nd_cls_room RESTRICT;

-- 주소
DROP TABLE IF EXISTS nd_addr RESTRICT;

-- 강사배정
DROP TABLE IF EXISTS nd_lesn_tchr RESTRICT;

-- 회원
DROP TABLE IF EXISTS nd_memb RESTRICT;

-- 수강신청
CREATE TABLE nd_appl (
  aplno  INTEGER  NOT NULL COMMENT '수강신청번호', -- 수강신청번호
  reg_dt DATETIME NOT NULL COMMENT '신청일', -- 신청일
  stat   CHAR(1)  NULL     COMMENT '신청상태', -- 신청상태
  lno    INTEGER  NOT NULL COMMENT '수업번호', -- 수업번호
  mno    INTEGER  NOT NULL COMMENT '수강생번호' -- 수강생번호
)
COMMENT '수강신청';

-- 수강신청
ALTER TABLE nd_appl
  ADD CONSTRAINT PK_nd_appl -- 수강신청 기본키
    PRIMARY KEY (
      aplno -- 수강신청번호
    );

ALTER TABLE nd_appl
  MODIFY COLUMN aplno INTEGER NOT NULL AUTO_INCREMENT COMMENT '수강신청번호';

-- 수업
CREATE TABLE nd_lesn (
  lno    INTEGER      NOT NULL COMMENT '수업번호', -- 수업번호
  title  VARCHAR(255) NOT NULL COMMENT '과목', -- 과목
  sdt    DATE         NOT NULL COMMENT '시작일', -- 시작일
  edt    DATE         NOT NULL COMMENT '종료일', -- 종료일
  tot_hr INTEGER      NOT NULL COMMENT '총교육시간', -- 총교육시간
  day_hr INTEGER      NOT NULL COMMENT '일교육시간', -- 일교육시간
  crno   INTEGER      NULL     COMMENT '강의실번호', -- 강의실번호
  mno    INTEGER      NULL     COMMENT '매니저번호' -- 매니저번호
)
COMMENT '수업';

-- 수업
ALTER TABLE nd_lesn
  ADD CONSTRAINT PK_nd_lesn -- 수업 기본키
    PRIMARY KEY (
      lno -- 수업번호
    );

-- 수업 인덱스
CREATE INDEX IX_nd_lesn
  ON nd_lesn( -- 수업
    title ASC -- 과목
  );

ALTER TABLE nd_lesn
  MODIFY COLUMN lno INTEGER NOT NULL AUTO_INCREMENT COMMENT '수업번호';

-- 강사
CREATE TABLE nd_tchr (
  mno    INTEGER NOT NULL COMMENT '강사번호', -- 강사번호
  pay_hr INTEGER NULL     COMMENT '강의료' -- 강의료
)
COMMENT '강사';

-- 강사
ALTER TABLE nd_tchr
  ADD CONSTRAINT PK_nd_tchr -- 강사 기본키
    PRIMARY KEY (
      mno -- 강사번호
    );

-- 수강생
CREATE TABLE nd_stud (
  mno      INTEGER      NOT NULL COMMENT '수강생번호', -- 수강생번호
  ano      INTEGER      NULL     COMMENT '주소번호', -- 주소번호
  det_addr VARCHAR(255) NULL     COMMENT '상세주소' -- 상세주소
)
COMMENT '수강생';

-- 수강생
ALTER TABLE nd_stud
  ADD CONSTRAINT PK_nd_stud -- 수강생 기본키
    PRIMARY KEY (
      mno -- 수강생번호
    );

-- 매니저
CREATE TABLE nd_mgr (
  mno  INTEGER     NOT NULL COMMENT '매니저번호', -- 매니저번호
  posi VARCHAR(50) NULL     COMMENT '직위' -- 직위
)
COMMENT '매니저';

-- 매니저
ALTER TABLE nd_mgr
  ADD CONSTRAINT PK_nd_mgr -- 매니저 기본키
    PRIMARY KEY (
      mno -- 매니저번호
    );

-- 강의실
CREATE TABLE nd_cls_room (
  crno INTEGER     NOT NULL COMMENT '강의실번호', -- 강의실번호
  loc  VARCHAR(50) NOT NULL COMMENT '교육센터', -- 교육센터
  room VARCHAR(50) NOT NULL COMMENT '강의실' -- 강의실
)
COMMENT '강의실';

-- 강의실
ALTER TABLE nd_cls_room
  ADD CONSTRAINT PK_nd_cls_room -- 강의실 기본키
    PRIMARY KEY (
      crno -- 강의실번호
    );

-- 강의실 유니크 인덱스
CREATE UNIQUE INDEX UIX_nd_cls_room
  ON nd_cls_room ( -- 강의실
    loc ASC,  -- 교육센터
    room ASC  -- 강의실
  );

ALTER TABLE nd_cls_room
  MODIFY COLUMN crno INTEGER NOT NULL AUTO_INCREMENT COMMENT '강의실번호';

-- 주소
CREATE TABLE nd_addr (
  ano      INTEGER      NOT NULL COMMENT '주소번호', -- 주소번호
  pst_no   VARCHAR(10)  NOT NULL COMMENT '우편번호', -- 우편번호
  bas_addr VARCHAR(255) NOT NULL COMMENT '기본주소' -- 기본주소
)
COMMENT '주소';

-- 주소
ALTER TABLE nd_addr
  ADD CONSTRAINT PK_nd_addr -- 주소 기본키
    PRIMARY KEY (
      ano -- 주소번호
    );

ALTER TABLE nd_addr
  MODIFY COLUMN ano INTEGER NOT NULL AUTO_INCREMENT COMMENT '주소번호';

-- 강사배정
CREATE TABLE nd_lesn_tchr (
  lno INTEGER NOT NULL COMMENT '수업번호', -- 수업번호
  mno INTEGER NOT NULL COMMENT '강사번호' -- 강사번호
)
COMMENT '강사배정';

-- 강사배정
ALTER TABLE nd_lesn_tchr
  ADD CONSTRAINT PK_nd_lesn_tchr -- 강사배정 기본키
    PRIMARY KEY (
      lno, -- 수업번호
      mno  -- 강사번호
    );

-- 회원
CREATE TABLE nd_memb (
  mno   INTEGER     NOT NULL COMMENT '회원번호', -- 회원번호
  name  VARCHAR(50) NOT NULL COMMENT '이름', -- 이름
  tel   VARCHAR(30) NULL     COMMENT '전화', -- 전화
  email VARCHAR(40) NOT NULL COMMENT '이메일', -- 이메일
  pwd   VARCHAR(80) NOT NULL COMMENT '암호' -- 암호
)
COMMENT '회원';

-- 회원
ALTER TABLE nd_memb
  ADD CONSTRAINT PK_nd_memb -- 회원 기본키
    PRIMARY KEY (
      mno -- 회원번호
    );

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX UIX_nd_memb
  ON nd_memb ( -- 회원
    email ASC -- 이메일
  );

ALTER TABLE nd_memb
  MODIFY COLUMN mno INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 수강신청
ALTER TABLE nd_appl
  ADD CONSTRAINT FK_nd_lesn_TO_nd_appl -- 수업 -> 수강신청
    FOREIGN KEY (
      lno -- 수업번호
    )
    REFERENCES nd_lesn ( -- 수업
      lno -- 수업번호
    );

-- 수강신청
ALTER TABLE nd_appl
  ADD CONSTRAINT FK_nd_stud_TO_nd_appl -- 수강생 -> 수강신청
    FOREIGN KEY (
      mno -- 수강생번호
    )
    REFERENCES nd_stud ( -- 수강생
      mno -- 수강생번호
    );

-- 수업
ALTER TABLE nd_lesn
  ADD CONSTRAINT FK_nd_cls_room_TO_nd_lesn -- 강의실 -> 수업
    FOREIGN KEY (
      crno -- 강의실번호
    )
    REFERENCES nd_cls_room ( -- 강의실
      crno -- 강의실번호
    );

-- 수업
ALTER TABLE nd_lesn
  ADD CONSTRAINT FK_nd_mgr_TO_nd_lesn -- 매니저 -> 수업
    FOREIGN KEY (
      mno -- 매니저번호
    )
    REFERENCES nd_mgr ( -- 매니저
      mno -- 매니저번호
    );

-- 강사
ALTER TABLE nd_tchr
  ADD CONSTRAINT FK_nd_memb_TO_nd_tchr -- 회원 -> 강사
    FOREIGN KEY (
      mno -- 강사번호
    )
    REFERENCES nd_memb ( -- 회원
      mno -- 회원번호
    );

-- 수강생
ALTER TABLE nd_stud
  ADD CONSTRAINT FK_nd_addr_TO_nd_stud -- 주소 -> 수강생
    FOREIGN KEY (
      ano -- 주소번호
    )
    REFERENCES nd_addr ( -- 주소
      ano -- 주소번호
    );

-- 수강생
ALTER TABLE nd_stud
  ADD CONSTRAINT FK_nd_memb_TO_nd_stud -- 회원 -> 수강생
    FOREIGN KEY (
      mno -- 수강생번호
    )
    REFERENCES nd_memb ( -- 회원
      mno -- 회원번호
    );

-- 매니저
ALTER TABLE nd_mgr
  ADD CONSTRAINT FK_nd_memb_TO_nd_mgr -- 회원 -> 매니저
    FOREIGN KEY (
      mno -- 매니저번호
    )
    REFERENCES nd_memb ( -- 회원
      mno -- 회원번호
    );

-- 강사배정
ALTER TABLE nd_lesn_tchr
  ADD CONSTRAINT FK_nd_lesn_TO_nd_lesn_tchr -- 수업 -> 강사배정
    FOREIGN KEY (
      lno -- 수업번호
    )
    REFERENCES nd_lesn ( -- 수업
      lno -- 수업번호
    );

-- 강사배정
ALTER TABLE nd_lesn_tchr
  ADD CONSTRAINT FK_nd_tchr_TO_nd_lesn_tchr -- 강사 -> 강사배정
    FOREIGN KEY (
      mno -- 강사번호
    )
    REFERENCES nd_tchr ( -- 강사
      mno -- 강사번호
    );