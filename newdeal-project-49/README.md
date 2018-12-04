# eomcs-java-project-49

## 작업

### MyBatis 라이브러리 추가

- `mvnrepository.com`에서 `mybatis`를 검색하여 라이브러리 정보를 알아낸다.
- build.gradle 파일에 등록
- `$ gradle eclipse` 실행하여 이클립스 설정 파일을 갱신한다.
- 이클립스에서 프로젝트 리프래시한다.

### MyBatis 설정 파일 추가

- mybatis.org 사이트의 문서를 참고하여 `mybatis-config.xml` 파일을 작성한다.
- jdbc.properties 파일을 작성한다.
    - DBMS 연결 정보를 둔다.
    - MyBatis 설정 파일에서 참고할 것이다.
- `src/main/resources/com/eomcs/lms/conf` 디렉토리에 파일을 둔다.
- `src/main/resources` 폴더를 추가한 후 자바 소스 폴더로 등록해야 한다.
- 즉 폴더를 만든 후에 `$ gradle eclipse`를 다시 실행한다.
- 물론 이클립스에서도 프로젝트를 리프래시한다.

### SQL 분리 

- `src/main/resources/com/eomcs/lms/mapper/BoardMapper.xml` 파일을 작성한다.
- `BoardDao` 클래스에 있는 SQL을 이 파일로 옮긴다.
- 물론 MyBatis 문서를 참고하여 작성하라!

### SqlSessionFactory 인스턴스를 생성

- `App` 클래스에서 MyBatis의 SqlSessionFactory 객체를 준비한다.
- DAO 객체가 사용할 수 있게 생성자에 주입해준다.

### DAO에 적용 

