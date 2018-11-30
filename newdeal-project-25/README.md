# eomcs-java-project-2.4

인스턴스 연산자와 메서드

- 메서드를 활용하여 인스턴스 값을 다루는 연산자를 정의하는 방법
- 캡슐화와 셋터/겟터의 의미

## 프로젝트 - 수업관리 시스템  

### 과제 1: Lesson 인스턴스의 값을 다룰 연산자를 정의하라.

- Lesson.java
    - 인스턴스 변수(필드)를 비공개(private)로 전환한다.
    - 값을 설정하고 리턴해주는 세터/게터를 정의한다. 
- LessonHandler.java
    - Lesson 인스턴스에 값을 넣고 꺼낼 때 세터/겟터를 사용한다.

#### 실행 결과

`App` 클래스의 실행 결과는 이전 버전과 같다.

### 과제 2: Member 인스턴스의 값을 다룰 연산자를 정의하라.

- Member.java
    - 인스턴스 변수(필드)를 비공개(private)로 전환한다.
    - 값을 설정하고 리턴해주는 세터/게터를 정의한다. 
- MemberHandler.java
    - Member 인스턴스에 값을 넣고 꺼낼 때 세터/겟터를 사용한다.

#### 실행 결과

`App` 클래스의 실행 결과는 이전 버전과 같다.

### 과제 3: Board 인스턴스의 값을 다룰 연산자를 정의하라.

- Board.java
    - 인스턴스 변수(필드)를 비공개(private)로 전환한다.
    - 값을 설정하고 리턴해주는 세터/게터를 정의한다. 
- BoardHandler.java
    - Board 인스턴스에 값을 넣고 꺼낼 때 세터/겟터를 사용한다.

#### 실행 결과

`App` 클래스의 실행 결과는 이전 버전과 같다.

## 실습 소스

- src/main/java/com/eomcs/lms/domain/Lesson.java 변경
- src/main/java/com/eomcs/lms/domain/Member.java 변경
- src/main/java/com/eomcs/lms/domain/Board.java 변경
- src/main/java/com/eomcs/lms/handler/LessonHandler.java 변경
- src/main/java/com/eomcs/lms/handler/MemberHandler.java 변경
- src/main/java/com/eomcs/lms/handler/BoardHandler.java 변경