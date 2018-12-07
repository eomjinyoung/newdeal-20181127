package com.eomcs.lms.web;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
      Board board, HttpSession session) throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");
    board.setWriterNo(loginUser.getNo());
    boardDao.insert(board);
    return "redirect:list";
  }
  
  @RequestMapping("delete")
  public void delete(int no, Model model) throws Exception {
      model.addAttribute("count", boardDao.delete(no));
      //return "board/delete";
  }
  
  @RequestMapping("detail")
  public void detail(int no, Model model) throws Exception {
    Board board = boardDao.findByNo(no);
    model.addAttribute("board", board);
    //return "board/detail";
  }
  
  @RequestMapping("form")
  public void form(
      HttpSession session, Model model) throws Exception {
    Member loginUser = (Member) session.getAttribute("loginUser");
    List<Map<String,Object>> lessons = 
        lessonDao.findByParticipantNo(loginUser.getNo());
    model.addAttribute("lessons", lessons);
    //return "board/form";
  }
  
  @RequestMapping("list")
  public void list(Model model) throws Exception {
    List<Board> list = boardDao.findAll();
    model.addAttribute("list", list);
    //return "board/list"
  }
  
  @RequestMapping("update")
  public String update(Board board) throws Exception {
    boardDao.update(board);
    return "redirect:list";
  }
}








