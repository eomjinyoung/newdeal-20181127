package com.eomcs.lms.handler;

import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

//Spring IoC 컨테이너가 이 클래스의 인스턴스를 자동 생성하도록 
//클래스에 표시해 둔다.
@Component("/board/add")
public class BoardAddCommand implements Command {
  
  Scanner keyboard;
  BoardDao boardDao;
  
  public BoardAddCommand(Scanner keyboard, BoardDao boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }
  
  public void execute() {
    try {
      Board board = new Board();
      
      System.out.print("내용? ");
      board.setContents(keyboard.nextLine());
      
      System.out.print("작성자번호? ");
      board.setWriterNo(Integer.parseInt(keyboard.nextLine()));
      
      System.out.print("수업번호? ");
      board.setLessonNo(Integer.parseInt(keyboard.nextLine()));
      
      boardDao.insert(board);
      
      System.out.println("입력했습니다!");
    
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}








