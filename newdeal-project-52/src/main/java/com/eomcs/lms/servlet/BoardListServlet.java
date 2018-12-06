package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

// 서블릿을 만들었으면 톰캣 서버에 알려줘야 한다.
// => 서블릿에 URL을 부여한다.
// => URL은 항상 '/'로 시작해야 한다.
// => 서블릿을 추가했으면 톰캣 서버를 재시작해야 사용할 수 있다.
// => 한 번 톰캣 서버에 서블릿을 추가한 후 서블릿을 변경한다면
//    일정 시간이 지난 후에 자동으로 해당 서블릿을 재적재한다.
//    즉 서버를 재시작할 필요가 없다.
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  BoardDao boardDao;
  
  @Override
  public void init() throws ServletException {
    // 이 메서드는 서블릿 객체가 최초로 생성될 때 생성자 다음에 
    // 바로 호출된다.
    // => 원래는 init(ServletConfig)가 먼저 호출되고,
    //    init(ServletConfig)가 이 init()를 호출한다.
    // 
    // BoardDao 객체를 꺼내기 위해 먼저 IoC 컨테이너를 꺼낸다.
    ServletContext sc = this.getServletContext();
    ApplicationContext iocContainer = 
        (ApplicationContext) sc.getAttribute("iocContainer");
    
    try {
      boardDao = iocContainer.getBean(BoardDao.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void doGet(
      HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>게시물</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시물</h1>");
    out.println("<table border='1'>");
    out.println("<tr>");
    out.println("  <th>번호</th><th>내용</th><th>작성일</th><th>조회수</th>");
    out.println("</tr>");
    
    try {
      List<Board> list = boardDao.findAll();
      
      for (Board board : list) {
        out.println("<tr>");
        out.printf("<td>%d</td><td>%s</td><td>%s</td><td>%d</td>",
            board.getNo(), 
            board.getContents(), 
            board.getCreatedDate(), 
            board.getViewCount());
        out.println("</tr>");
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    out.println("</table>");
    out.println("</body>");
    out.println("</html>");

  }
} 
