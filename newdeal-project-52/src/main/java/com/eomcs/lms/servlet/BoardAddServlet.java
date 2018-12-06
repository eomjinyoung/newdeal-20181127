package com.eomcs.lms.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;

@WebServlet("/board/add")
public class BoardAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  BoardDao boardDao;
  
  @Override
  public void init() {
    ApplicationContext iocContainer = 
        (ApplicationContext) this.getServletContext()
                                 .getAttribute("iocContainer");
    this.boardDao = iocContainer.getBean(BoardDao.class);
  }
  
  @Override
  protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    RequestDispatcher rd = request.getRequestDispatcher(
        "/board/form.jsp");
    rd.forward(request, response);
  }
  
  @Override
  protected void doPost(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    
    try {
      Board board = new Board();
      board.setContents(request.getParameter("contents"));
      
      Member loginUser = 
          (Member) request.getSession().getAttribute("loginUser");
      board.setWriterNo(loginUser.getNo());
      
      board.setLessonNo(Integer.parseInt(
          request.getParameter("lessonNo")));
      
      boardDao.insert(board);
      
      response.sendRedirect("list");
    
    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    }
  }
}








