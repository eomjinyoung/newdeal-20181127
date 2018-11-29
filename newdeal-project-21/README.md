# eomcs-java-project-2.0

패키지로 클래스를 분류하기

- 패키지를 이용하여 관련 클래스를 분류하는 방법

## 프로젝트 - 수업관리 시스템  

### 과제 1: 데이터 타입 클래스를 별도의 패키지로 분류하라.

- 기본 애플리케이션 패키지 생성
    - `com.eomcs.lms` 패키지 생성
- 도메인 패키지 생성
    - `com.eomcs.lms.domain` 패키지 생성
- 도메인 클래스를 `domain` 패키지로 이동
    - `Lesson`, `Member`, `Board` 클래스를 `com.eomcs.lms.domain` 패키지로 옮긴다.
    - 다른 패키지에서 변수에 접근할 수 있도록 접근 제어를 `public` 으로 변경
- 핸들러 클래스에 import 문 추가
    - `LessonHandler`, `MemberHandler`, `BoardHandler` 클래스를 변경한다.

#### 실행 결과

`App` 클래스의 실행 결과는 이전 버전과 같다.

### 과제 2: 사용자 명령을 처리하는 클래스를 별도의 패키지로 분류하라.

- 핸들러 패키지 생성
    - `com.eomcs.lms.handler` 패키지 생성
- 핸들러 클래스를 `handler` 패키지로 이동
    - `LessonHandler`, `MemberHandler`, `BoardHandler` 클래스를 `com.eomcs.lms.handler` 패키지로 옮긴다. 
    - 다른 패키지에서 변수에 접근할 수 있도록 접근 제어를 `public` 으로 변경
- App.java 변경
    - 핸들러 클래스에 대해 import 문 추가
  
#### 실행 결과

`App` 클래스의 실행 결과는 이전 버전과 같다.

### 과제 3: App 클래스를 애플리케이션 기본 패키지로 옮려라.

- App 클래스를 `com.eomcs.lms` 패키지로 이동시킨다.

#### 실행 결과

`App` 클래스의 실행 결과는 이전 버전과 같다.

## 실습 소스

- src/main/java/com/eomcs/lms/App.java 변경
- src/main/java/com/eomcs/lms/handler/LessonHandler.java 변경
- src/main/java/com/eomcs/lms/handler/MemberHandler.java 변경
- src/main/java/com/eomcs/lms/handler/BoardHandler.java 변경
- src/main/java/com/eomcs/lms/domain/Lesson.java 변경
- src/main/java/com/eomcs/lms/domain/Member.java 변경
- src/main/java/com/eomcs/lms/domain/Board.java 변경