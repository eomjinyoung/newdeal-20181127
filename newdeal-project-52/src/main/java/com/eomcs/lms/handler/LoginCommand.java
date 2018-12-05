package com.eomcs.lms.handler;

import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

//Spring IoC 컨테이너가 이 클래스의 인스턴스를 자동 생성하도록 
//클래스에 표시해 둔다.
@Component("/auth/login")
public class LoginCommand implements Command {
  
  Scanner keyboard;
  MemberDao memberDao;
  
  public LoginCommand(Scanner keyboard, MemberDao memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }
  
  public void execute() {
    try {
      System.out.print("이메일? ");
      String email = keyboard.nextLine();
      
      System.out.print("암호? ");
      String password = keyboard.nextLine();
      
      Member member = memberDao.findByEmailPassword(email, password);
      
      if (member != null)
        System.out.printf("%s 님 환영합니다.\n", member.getName());
      else 
        System.out.println("이메일 또는 암호가 일치하지 않습니다.");
    
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}








