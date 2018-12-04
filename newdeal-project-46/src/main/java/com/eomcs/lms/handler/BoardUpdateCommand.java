package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class BoardUpdateCommand implements Command {
  
  Scanner keyboard;
  
  public BoardUpdateCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  public void execute() {
    Connection con = null;
    Statement stmt = null;
    
    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/studydb", 
          "study", "1111");
      stmt = con.createStatement();
      
      System.out.print("번호? ");
      String no = keyboard.nextLine();
      
      ResultSet rs = stmt.executeQuery(
          "select cont from board where bno=" + no);
      rs.next();
      String oldContent = rs.getString("cont");
      rs.close();
      
      System.out.printf("내용(%s)? ", oldContent);
      String content = keyboard.nextLine();
      
      // SQL을 서버에 전송 
      stmt.executeUpdate("update board set cont='" + 
          content + "' where bno=" + no);
      
      System.out.println("변경했습니다!");
    
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
}
