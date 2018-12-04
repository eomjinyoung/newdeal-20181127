package com.eomcs.lms.handler;

import java.util.Scanner;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

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
