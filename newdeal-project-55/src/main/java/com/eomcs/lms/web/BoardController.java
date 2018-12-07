package com.eomcs.lms.web;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;

@Controller
@RequestMapping("/board")
public class BoardController {

  BoardDao boardDao;
  LessonDao lessonDao;

  public BoardController(BoardDao boardDao, LessonDao lessonDao) {
    this.boardDao = boardDao;
    this.lessonDao = lessonDao;
  }

  @RequestMapping("add")
  public String add(
      HttpServletRequest request, HttpServletResponse response)
          throws Exception {

    Board board = new Board();
    board.setContents(request.getParameter("contents"));

    Member loginUser = 
        (Member) request.getSession().getAttribute("loginUser");
    board.setWriterNo(loginUser.getNo());

    board.setLessonNo(Integer.parseInt(
        request.getParameter("lessonNo")));

    boardDao.insert(board);

    return "redirect:list";
  }
  
  @RequestMapping("delete")
  public String delete(
      HttpServletRequest request, HttpServletResponse response)
          throws Exception {

      int no = Integer.parseInt(request.getParameter("no"));
      request.setAttribute("count", boardDao.delete(no));
      response.setContentType("text/html;charset=UTF-8");
      
      return "/board/delete.jsp";
  }
  
  @RequestMapping("detail")
  public String detail(
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {
      
    int no = Integer.parseInt(request.getParameter("no"));
      Board board = boardDao.findByNo(no);
      request.setAttribute("board", board);
      
      response.setContentType("text/html;charset=UTF-8");
      return "/board/detail.jsp";
  }
  
  @RequestMapping("form")
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
  
  @RequestMapping("list")
  public String list(
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    List<Board> list = boardDao.findAll();
    request.setAttribute("list", list);
    response.setContentType("text/html;charset=UTF-8");

    return "/board/list.jsp";
  }
  
  @RequestMapping("update")
  public String update(
      HttpServletRequest request, HttpServletResponse response)
          throws Exception {

    Board board = new Board();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setContents(request.getParameter("contents"));

    boardDao.update(board);

    return "redirect:list";
  }
}








