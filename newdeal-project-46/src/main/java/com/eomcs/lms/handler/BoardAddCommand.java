package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class BoardAddCommand implements Command {
  
  Scanner keyboard;
  
  public BoardAddCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  public void execute() {
    Connection con = null;
    Statement stmt = null;
    
    try {
      System.out.print("내용? ");
      String content = keyboard.nextLine();
      
      System.out.print("작성자번호? ");
      String writerNo = keyboard.nextLine();
      
      System.out.print("수업번호? ");
      String lessonNo = keyboard.nextLine();
      
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/studydb", 
          "study", "1111");
      stmt = con.createStatement();
      
      // SQL을 서버에 전송 
      stmt.executeUpdate("insert into board(cont,mno,lno)"
          + " values('" + content + "',"
          + writerNo + ","
          + lessonNo + ")");
      
      System.out.println("입력했습니다!");
    
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
}








