package com.eomcs.lms.web;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@Controller
@RequestMapping("/auth")
public class AuthController {

  MemberDao memberDao;

  public AuthController(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @RequestMapping("login")
  public String login(
      HttpServletRequest request, HttpServletResponse response)
          throws Exception {

    HashMap<String,Object> params = new HashMap<>();
    params.put("email", request.getParameter("email"));
    params.put("password", request.getParameter("password"));

    Member member = memberDao.findByEmailPassword(params);

    HttpSession session = request.getSession();

    if (member != null) {
      session.setAttribute("loginUser", member);
      return "redirect:../board/list";
    } else {
      session.invalidate();
      return "redirect:form";
    }

  }
  
  @RequestMapping("form")
  public String form(
      HttpServletRequest request, HttpServletResponse response)
          throws Exception {
    
    response.setContentType("text/html;charset=UTF-8");

    return "/auth/form.jsp";
  }
  
  @RequestMapping("logout")
  public String logout(
      HttpServletRequest request, HttpServletResponse response)
          throws Exception {
    
    request.getSession().invalidate();
    
    return "redirect:login";
  }
}








