package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.BoardDao;

@Controller
public class BoardDeleteServlet {

  BoardDao boardDao;

  public BoardDeleteServlet(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  
  @RequestMapping("/board/delete")
  public String delete(
      HttpServletRequest request, HttpServletResponse response)
          throws Exception {

      int no = Integer.parseInt(request.getParameter("no"));
      request.setAttribute("count", boardDao.delete(no));
      response.setContentType("text/html;charset=UTF-8");
      
      return "/board/delete.jsp";
  }
}





