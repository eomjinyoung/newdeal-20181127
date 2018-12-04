package com.eomcs.lms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class MariaDBBoardDao implements BoardDao {
  
  public List<Board> findAll() throws Exception {
    DriverManager.registerDriver(new Driver());
    
    try (
        Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", 
        "study", "1111");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select bno, cont, cdt, view from board");) {
      
      ArrayList<Board> list = new ArrayList<>();
      
      while (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("bno"));
        board.setContents(rs.getString("cont"));
        board.setCreatedDate(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("view"));
        
        list.add(board);
      }
      
      return list;
    }
  }
  
  public Board findByNo(int no) throws Exception {
    DriverManager.registerDriver(new Driver());
    try (
        Connection con = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3306/studydb", 
            "study", "1111");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select bno, cont, cdt, view, mno, lno"
            + " from board"
            + " where bno=" + no);) {
      
      if (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("bno"));
        board.setContents(rs.getString("cont"));
        board.setCreatedDate(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("view"));
        board.setWriterNo(rs.getInt("mno"));
        board.setLessonNo(rs.getInt("lno"));
        return board;
      } else {
        return null;
      }
    }
  }
  
  public int insert(Board board) throws Exception {
    DriverManager.registerDriver(new Driver());
    try (
        Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", 
        "study", "1111");
        Statement stmt = con.createStatement();) {

      // SQL을 서버에 전송 
      return stmt.executeUpdate("insert into board(cont,mno,lno)"
          + " values('" + board.getContents() + "',"
          + board.getWriterNo() + ","
          + board.getLessonNo() + ")");
    }
  }
  
  public int update(Board board) throws Exception {
    Connection con = null;
    Statement stmt = null;
    
    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/studydb", 
          "study", "1111");
      stmt = con.createStatement();
      
      return stmt.executeUpdate(
          "update board set cont='" + 
          board.getContents() + 
          "' where bno=" + board.getNo());
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
  
  public int delete(int no) throws Exception {
    Connection con = null;
    Statement stmt = null;
    
    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/studydb", 
          "study", "1111");
      stmt = con.createStatement();

      return stmt.executeUpdate("delete from board where bno=" + no);
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
}














