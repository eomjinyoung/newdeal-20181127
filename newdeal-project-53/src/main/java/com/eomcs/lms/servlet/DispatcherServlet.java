package com.eomcs.lms.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.web.PageController;

@WebServlet("/app/*")
public class DispatcherServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  ApplicationContext iocContainer;
  
  @Override
  public void init() {
    iocContainer = (ApplicationContext) this.getServletContext()
                                 .getAttribute("iocContainer");
  }
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    // 클라이언트가 요청한 URL에서 명령을 추출하기
    // => /app/board/list ---> /board/list
    String controllerPath = request.getPathInfo();
    
    try {
      // 클라이언트가 요청한 명령을 처리할 객체를 
      // Spring IoC Container에서 찾는다.
      PageController controller = 
          (PageController) iocContainer.getBean(controllerPath);
      
      // 페이지 컨트롤러의 메서드를 호출한다.
      String viewUrl = controller.execute(request, response);
      
      if (viewUrl.startsWith("redirect:")) {
        response.sendRedirect(viewUrl.replace("redirect:",""));
      } else {
        // PageController가 알려준 JSP를 include 한다.
        RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
        rd.include(request, response);
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    }
    
  }
}








