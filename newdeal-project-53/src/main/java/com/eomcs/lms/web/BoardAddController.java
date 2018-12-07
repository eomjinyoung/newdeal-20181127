package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;

@Component("/board/add")
public class BoardAddController implements PageController {

  BoardDao boardDao;

  public BoardAddController(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public String execute(
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
}








