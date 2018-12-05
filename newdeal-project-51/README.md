# eomcs-java-project-49

## 작업

### MyBatis-Spring 연동 라이브러리 추가

- `mvnrepository.com`에서 `mybatis-spring`을 검색하여 라이브러리 정보를 알아낸다.
- build.gradle 파일에 등록
- `$ gradle eclipse` 실행하여 이클립스 설정 파일을 갱신한다.
- 이클립스에서 프로젝트 리프래시한다.

### SqlSessionFactory 객체 생성

- apache common-dbcp 라이브러리 추가
    - DataSource 구현체(DB 커넥션풀 객체)
- spring-jdbc 라이브러리 추가
    - Spring 트랜잭션 관련 클래스가 있다.
- AppConfig.java 작성
    - DataSource 객체를 생성하는 메서드 추가
    - SqlSessionFactory 객체를 생성하는 메서드 변경
        - MyBatis-Spring 연동 라이브러리에서 제공하는 도우미 클래스를 사용하여 SqlSessionFactory 객체를 만든다.
    - TransactionManager 객체를 생성하는 메서드 추가

### Spring IoC 컨테이너 준비

- App.java
    - Spring IoC 컨테이너 객체를 준비한다.
