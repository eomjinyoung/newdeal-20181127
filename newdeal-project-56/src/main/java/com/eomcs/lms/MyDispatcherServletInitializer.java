package com.eomcs.lms;

// AbstractAnnotationConfigDispatcherServletInitializer 클래스는 
// WebApplicationInitializer 인터페이스를 구현하고 있다.
// 또한 DispatcherServlet을 등록하도록 프로그램 되어 있다.
// 
// 그래서 이 클래스를 상속 받아 서브 클래스를 만든다면, 
// DispatcherServlet에 대해서만 설정하면 된다.
// 
// 직접 WebApplicationInitializer를 구현하여 
// DispatcherServlet을 등록하는 것 보다 편하다!
//
public class MyDispatcherServletInitializer 
  /*extends AbstractAnnotationConfigDispatcherServletInitializer*/ {

  protected Class<?>[] getRootConfigClasses() {
    return null;
  }

  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] {AppConfig.class};
  }

  protected String[] getServletMappings() {
    return new String[] {"/app/*"};
  }
  

}
