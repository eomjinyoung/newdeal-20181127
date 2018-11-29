# eomcs-java-project-2.3

생성자가 필요한 이유

- 인스턴스를 사용하기 전에 필요한 값을 준비하는 방법
- 생성자의 용도 이해

## 프로젝트 - 수업관리 시스템  

### 과제 1: 핸들러 객체의 필수 입력 값인 keyboard를 반드시 설정하게 만들라!

- BoardHandler.java
    - 기본 생성자 대신에 파라미터로 keyboard를 받는 생성자를 추가한다.
    - `LessonHandler`, `MemberHandler` 클래스로 동일하게 처리한다.
- App.java 
    - 핸들러 클래스의 변화에 맞추어 코드를 변경한다.

#### 실행 결과

`App` 클래스의 실행 결과는 이전 버전과 같다.

## 실습 소스

- src/main/java/com/eomcs/lms/App.java 변경
- src/main/java/com/eomcs/lms/handler/BoardHandler.java 변경
- src/main/java/com/eomcs/lms/handler/LessonHandler.java 변경
- src/main/java/com/eomcs/lms/handler/MemberHandler.java 변경