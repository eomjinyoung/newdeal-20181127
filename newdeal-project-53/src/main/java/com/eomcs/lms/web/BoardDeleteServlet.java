package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;

@Component("/board/delete")
public class BoardDeleteServlet implements PageController {

  BoardDao boardDao;

  public BoardDeleteServlet(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  
  @Override
  public String execute(
      HttpServletRequest request, HttpServletResponse response)
          throws Exception {

      int no = Integer.parseInt(request.getParameter("no"));
      request.setAttribute("count", boardDao.delete(no));
      response.setContentType("text/html;charset=UTF-8");
      
      return "/board/delete.jsp";
  }
}





