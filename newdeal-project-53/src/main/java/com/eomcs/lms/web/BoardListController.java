package com.eomcs.lms.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

// 이 클래스의 객체는 Spring IoC 컨테이너가 관리하도록 설정한다.
@Component("/board/list")
public class BoardListController implements PageController {
  
  BoardDao boardDao;
  
  public BoardListController(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  
  @Override
  public String execute(
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    List<Board> list = boardDao.findAll();
    request.setAttribute("list", list);
    response.setContentType("text/html;charset=UTF-8");

    return "/board/list.jsp";
  }
} 



