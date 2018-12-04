package com.eomcs.lms.handler;

import java.util.Scanner;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardDetailCommand implements Command {
  
  Scanner keyboard;
  BoardDao boardDao;
  
  public BoardDetailCommand(Scanner keyboard, BoardDao boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }
  
  public void execute() {
    try {
      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());

      Board board = boardDao.findByNo(no);
      
      // dbms에서 한 개의 레코드를 가져온다.
      if (board != null) {
        System.out.printf("번호: %d\n", board.getNo());
        System.out.printf("내용: %s\n", board.getContents());
        System.out.printf("작성일: %s\n", board.getCreatedDate());
        System.out.printf("조회수: %d\n", board.getViewCount());
        System.out.printf("작성자: %d\n", board.getWriterNo());
        System.out.printf("수업: %d\n", board.getLessonNo());
      } else {
        System.out.println("해당 번호의 게시물이 없습니다!");
      }
    
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
