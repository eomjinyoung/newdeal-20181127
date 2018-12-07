# eomcs-java-project-56

## 작업

### CharacterEncodingFilter 를 스프링에서 제공하는 클래스로 교체하기

### JSP 파일을 클라이언트로부터 감추기

- 외부에서 JSP를 직접 접근하지 못하게 /WEB-INF/jsp 폴더로 옮긴다.

### 기존의 ViewResolver를 InternalResourceViewResolver로 교체하기

- AppConfig.java 
  - 객체 생성 메서드를 추가한다.

### 페이지 컨트롤러의 리턴 값을 변경

- ViewResolver 교체에 맞춰 페이지 컨트롤러의 리턴 값을 변경한다.