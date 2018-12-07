# eomcs-java-project-52

## 작업

### 웹 프로젝트 관련 빌드 명령을 사용할 수 있게 준비하기

- build.gradle 
    - `eclipse` 플러그인 대신에 `eclipse-wtp` 플러그인을 추가한다.
    - 웹 애플리케이션 배치 파일(.war)을 만들 `war` 플러그인을 추가한다.
    - 단독으로 실행할 수 없기 때문에 `application` 플러그인은 제거한다.
    - `application` 플러그인과 관련된 변수 `mainClassName`을 제거한다.

### 서블릿 애플리케이션 개발에 사용할 라이브러리 추가하기

- `mvnrepository.com`에서 `servlet-api`를 검색하여 라이브러리 정보를 알아낸다.
- build.gradle 파일에 등록
- `$ gradle eclipse` 실행하여 이클립스 설정

### 이클립스 웹 프로젝트 설정하기

- src/main/webapp
    - HTML, CSS, JavaScript, PNG, JPEG, JSP 등 웹 자원을 둘 디렉토리를 생성한다.
- index.html
    - 웹 애플리케이션에 대해 간단히 소개하는 웹 페이지를 만든다.
- `$ gradle eclipse` 실행하여 이클립스 설정파일을 갱신한다.
    - `src/main/webapp` 폴더가 웹 프로젝트에 정식으로 등록된다.

### 이클립스에 톰캣 서버 등록

- 환경설정
    - 톰캣 서버가 설치된 디렉토리 정보를 등록한다.
- 웹 애플리케이션 테스트 환경 설정
    - `Servers` 뷰에 톰캣 테스트 환경을 추가한다.
    - 웹 프로젝트를 테스트 환경에 추가한다.    

### JSTL 환경 구축

- JSTL 구현 라이브러리를 가져온다.
    - mvnrepository.com에서 `jstl` 로 검색한다.

### MVC 아키텍처 적용

### HttpSession을 이용한 로그인/로그아웃

### Filter를 이용하여 서블릿을 실행하기 전에 특정 작업을 수행한다.

### MyBatis의 고급 Result Map 다루기

### MyBatis의 DAO 구현체 자동 생성하기

- AppConfig.java
    - @MapperScan 애노테이션 사용하여 DAO 인터페이스 구현체를 자동 생성한다.