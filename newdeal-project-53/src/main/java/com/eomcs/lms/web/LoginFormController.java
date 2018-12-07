package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component("/auth/form")
public class LoginFormController implements PageController {

  @Override
  public String execute(
      HttpServletRequest request, HttpServletResponse response)
          throws Exception {
    
    response.setContentType("text/html;charset=UTF-8");

    return "/auth/form.jsp";
  }
}








