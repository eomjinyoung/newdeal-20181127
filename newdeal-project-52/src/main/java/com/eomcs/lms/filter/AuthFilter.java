package com.eomcs.lms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.eomcs.lms.domain.Member;

@WebFilter("/*")
public class AuthFilter implements Filter {
  
  @Override
  public void doFilter(
      ServletRequest request, 
      ServletResponse response, 
      FilterChain chain)
      throws IOException, ServletException {
    
    HttpServletRequest httpReq = (HttpServletRequest) request;
    HttpServletResponse httpResp = (HttpServletResponse) response;
    
    String servletPath = httpReq.getServletPath();
    
    if (!servletPath.startsWith("/auth") &&
        !servletPath.endsWith(".html") &&
        !servletPath.endsWith(".css") &&
        !servletPath.endsWith(".js") &&
        !servletPath.endsWith(".png") &&
        !servletPath.endsWith(".jpeg")) {
      HttpSession session = httpReq.getSession();
      Member loginUser = (Member) session.getAttribute("loginUser");
      if (loginUser == null) {
        httpResp.sendRedirect("/auth/login");
        return;
      }
    }

    chain.doFilter(request, response);
    
  }
}






