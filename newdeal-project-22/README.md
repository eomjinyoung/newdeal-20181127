# eomcs-java-project-2.1

클래스 변수와 클래스 메서드의 한계

- 클래스 변수와 메서드의 한계를 이해하기

## 프로젝트 - 수업관리 시스템  

### 과제 1: 새 게시판을 추가하라.

- BoardHandler2.java
    - `/board2/add`, `/board2/list` 명령을 처리할 클래스를 추가한다.
- App.java
    - 새 명령을 처리하는 코드를 추가한다.

#### 실행 결과

```
명령> /board2/add
번호? 1
내용? 게시글1
저장하였습니다.

명령> /board2/add
번호? 2
내용? 게시글2
저장하였습니다.

명령> /board/add
번호? 100
내용? 게시글100
저장하였습니다.

명령> /board2/list
1, 게시글1                  , 2019-01-01, 0
2, 게시글2                  , 2019-01-01, 0

명령> /board/list
100, 게시글100              , 2019-01-01, 0
```

## 실습 소스

- src/main/java/com/eomcs/lms/App.java 변경
- src/main/java/com/eomcs/lms/handler/BoardHandler2.java 추가