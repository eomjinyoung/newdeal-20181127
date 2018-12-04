package com.eomcs.lms.handler;

import java.util.Scanner;
import com.eomcs.lms.dao.BoardDao;

public class BoardDeleteCommand implements Command {
  
  Scanner keyboard;
  BoardDao boardDao;
  
  public BoardDeleteCommand(Scanner keyboard, BoardDao boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }
  
  public void execute() {
    try {
      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());
      
      if (boardDao.delete(no) > 0)
        System.out.println("삭제했습니다!");
      else 
        System.out.println("해당 번호의 게시물이 없습니다.");
    
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
