# eomcs-java-project-1.9

클래스로 메서드를 분류하기

- 클래스를 이용하여 관련 메서드를 묶어 관리하는 방법

## 프로젝트 - 수업관리 시스템  

### 과제 1: 수업 데이터 처리와 관련된 메서드를 별도의 클래스로 분리하라. 

- LessonHandler.java
    - `App.java` 에서 수업관리와 관련된 변수와 메서드를 `LessonHandler` 클래스로 옮긴다.
- App.java (App.java.01)
    - `LessonHandler` 클래스 사용한다.

#### 실행 결과

`App` 클래스의 실행 결과는 이전 버전과 같다.

### 과제 2: 회원 데이터 처리와 관련된 메서드를 별도의 클래스로 분리하라. 

- MemberHandler.java
    - `App.java` 에서 회원관리와 관련된 변수와 메서드를 `MemberHandler` 클래스로 옮긴다.
- App.java (App.java.02)
    - `MemberHandler` 클래스 사용한다.

#### 실행 결과

`App` 클래스의 실행 결과는 이전 버전과 같다.

### 과제 3: 게시물 데이터 처리와 관련된 메서드를 별도의 클래스로 분리하라. 

- BoardHandler.java
    - `App.java` 에서 게시물관리와 관련된 변수와 메서드를 `BoardHandler` 클래스로 옮긴다.
- App.java
    - `BoardHandler` 클래스 사용한다.

#### 실행 결과

`App` 클래스의 실행 결과는 이전 버전과 같다.


## 실습 소스

- src/main/java/App.java 변경
- src/main/java/LessonHandler.java 추가
- src/main/java/MemberHandler.java 추가
- src/main/java/BoardHandler.java 추가
