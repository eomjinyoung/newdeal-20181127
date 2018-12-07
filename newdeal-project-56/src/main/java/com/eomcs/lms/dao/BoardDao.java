package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Board;

public interface BoardDao {
  
  List<Board> findAll() throws Exception;
  
  Board findByNo(int no) throws Exception;
  
  int insert(Board board) throws Exception;
  
  int update(Board board) throws Exception;
  
  int delete(int no) throws Exception;
}














