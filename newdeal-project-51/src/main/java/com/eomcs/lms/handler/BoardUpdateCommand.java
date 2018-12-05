package com.eomcs.lms.handler;

import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

//Spring IoC 컨테이너가 이 클래스의 인스턴스를 자동 생성하도록 
//클래스에 표시해 둔다.
@Component("/board/update")
public class BoardUpdateCommand implements Command {
  
  Scanner keyboard;
  BoardDao boardDao;
  
  public BoardUpdateCommand(Scanner keyboard, BoardDao boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }
  
  public void execute() {
    try {
      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());
      
      Board board = boardDao.findByNo(no);
      
      System.out.printf("내용(%s)? ", board.getContents());
      board.setContents(keyboard.nextLine());
      
      boardDao.update(board);
      
      System.out.println("변경했습니다!");
    
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
