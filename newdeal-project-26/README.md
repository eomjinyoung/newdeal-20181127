# eomcs-java-project-2.5

UI 코드와 데이터 처리 코드를 분리하기

- 데이터 처리 코드를 캡슐화하는 방법
- 캡슐화를 통해 얻을 수 이점 이해하기 

## 프로젝트 - 수업관리 시스템  

### 과제 1: LessonHandler에서 데이터 처리 코드를 분리하라.

- LessonList.java
    - `LessonHandler`에서 데이터 처리 코드를 이 클래스로 옮긴다.
    - 수업 데이터 배열을 리턴하는 toArray() 메서드를 정의한다.
    - 수업 데이터를 저장하는 add() 메서드를 정의한다.
    - 기본 생성자와 배열의 초기 크기를 설정하는 생성자를 정의한다.  
- LessonHandler.java
    - `LessonList` 클래스를 사용하여 데이터를 처리한다.

#### 실행 결과

`App` 클래스의 실행 결과는 이전 버전과 같다.

### 과제 2: MemberHandler에서 데이터 처리 코드를 분리하라.

- MemberList.java
    - `MemberHandler`에서 데이터 처리 코드를 이 클래스로 옮긴다.
    - 회원 데이터 배열을 리턴하는 toArray() 메서드를 정의한다.
    - 회원 데이터를 저장하는 add() 메서드를 정의한다.
    - 기본 생성자와 배열의 초기 크기를 설정하는 생성자를 정의한다.  
- MemberHandler.java
    - `MemberList` 클래스를 사용하여 데이터를 처리한다.

#### 실행 결과

`App` 클래스의 실행 결과는 이전 버전과 같다.

### 과제 3: BoardHandler에서 데이터 처리 코드를 분리하라.

- BoardList.java
    - `BoardHandler`에서 데이터 처리 코드를 이 클래스로 옮긴다.
    - 게시물 데이터 배열을 리턴하는 toArray() 메서드를 정의한다.
    - 게시물 데이터를 저장하는 add() 메서드를 정의한다.
    - 기본 생성자와 배열의 초기 크기를 설정하는 생성자를 정의한다.  
- BoardHandler.java
    - `BoardList` 클래스를 사용하여 데이터를 처리한다.

#### 실행 결과

`App` 클래스의 실행 결과는 이전 버전과 같다.

## 실습 소스

- src/main/java/com/eomcs/lms/handler/LessonList.java 추가
- src/main/java/com/eomcs/lms/handler/MemberList.java 추가
- src/main/java/com/eomcs/lms/handler/BoardList.java 추가
- src/main/java/com/eomcs/lms/handler/LessonHandler.java 변경
- src/main/java/com/eomcs/lms/handler/MemberHandler.java 변경
- src/main/java/com/eomcs/lms/handler/BoardHandler.java 변경