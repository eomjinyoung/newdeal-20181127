package com.eomcs.lms.web;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@Component("/auth/login")
public class LoginController implements PageController {

  MemberDao memberDao;

  public LoginController(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public String execute(
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
}








