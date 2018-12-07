package com.eomcs.lms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {
  
  @Override
  public void doFilter(
      ServletRequest request, 
      ServletResponse response, 
      FilterChain chain)
      throws IOException, ServletException {
    
    // POST 요청으로 들어온 데이터는 UTF-8 로 인코딩 되어 있다.
    // 그런데 request.getParameter()의 리턴 값은 Unicode(2byte)이다.
    // 즉 UTF-8을 JVM이 다루는 Unicode로 변환한 후에 리턴하는 것이다.
    // 문제는 클라이언트가 보낸 데이터가 UTF-8 로 되어 있다고 
    // 알려주지 않으면,
    // getParameter()는 클라이언트가 보낸 데이터가 ISO-8859-1이라고 
    // 착각을 한다. 즉 영어라고 착각하고 영어를 Unicode 바꾸는 것이다.
    // 그래서 UTF-8로 인코딩 된 한글 데이터가 Unicode로 바뀔 때 
    // 깨지는 것이다.
    // 해결책?
    // getParameter()를 "최초로" 호출하기 전에 
    // 클라이언트가 보낸 데이터가 UTF-8로 되어 있다고 알려줘야 한다.
    // 
    request.setCharacterEncoding("UTF-8");
    
    // 이 필터 다음에 또 다른 필터가 있다면 그 필터를 실행한다.
    // 없다면 원래 목적지인 서블릿을 실행한다.
    chain.doFilter(request, response);
    
  }
}






