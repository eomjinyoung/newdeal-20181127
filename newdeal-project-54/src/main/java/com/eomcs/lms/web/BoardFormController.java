package com.eomcs.lms.web;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Member;

@Controller
public class BoardFormController {
  
  LessonDao lessonDao;
  
  public BoardFormController(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }
  
  @RequestMapping("/board/form")
  public String form(
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    
    HttpSession session = request.getSession();
    Member loginUser = (Member) session.getAttribute("loginUser");
    
    List<Map<String,Object>> lessons = 
        lessonDao.findByParticipantNo(loginUser.getNo());
    request.setAttribute("lessons", lessons);
    
    response.setContentType("text/html;charset=UTF-8");
    
    return "/board/form.jsp";
  }
}








