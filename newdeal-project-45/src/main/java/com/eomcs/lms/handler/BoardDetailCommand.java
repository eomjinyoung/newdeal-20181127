package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class BoardDetailCommand implements Command {
  
  Scanner keyboard;
  
  public BoardDetailCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  public void execute() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());

      // MariaDB JDBC 드라이버(java.sql.Driver) 구현체를 로딩
      DriverManager.registerDriver(new Driver());
      
      // DBMS에 연결하기
      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/studydb", 
          "study", "1111");
      
      // SQL 전송을 담당할 객체를 준비
      stmt = con.createStatement();
      
      // SQL을 서버에 전송 => 서버에서 결과를 가져올 일을 할 객체를 리턴
      rs = stmt.executeQuery(
          "select bno, cont, cdt, view, mno, lno"
          + " from board"
          + " where bno=" + no);
      
      // dbms에서 한 개의 레코드를 가져온다.
      if (rs.next()) {
        System.out.printf("번호: %d\n", rs.getInt("bno"));
        System.out.printf("내용: %s\n", rs.getString("cont"));
        System.out.printf("작성일: %s\n", rs.getDate("cdt"));
        System.out.printf("조회수: %d\n", rs.getInt("view"));
        System.out.printf("작성자: %d\n", rs.getInt("mno"));
        System.out.printf("수업: %d\n", rs.getInt("lno"));
      } else {
        System.out.println("해당 번호의 게시물이 없습니다!");
      }
    
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
}
