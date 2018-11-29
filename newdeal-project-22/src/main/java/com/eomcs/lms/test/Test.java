package com.eomcs.lms.test;

public class Test {

  public static void main(String[] args) throws Exception {
    // 클래스 로딩?
    // - 클래스 멤버를 사용할 때!
    // - Class.forName()으로 명시적으로 클래스를 로딩할 때!
    
    //A p = null;
    /*
    Class.forName("com.eomcs.lms.test.A");
    Class.forName("com.eomcs.lms.test.A");
    Class.forName("com.eomcs.lms.test.A");
    Class.forName("com.eomcs.lms.test.A");
    */
    
    A.v1 = 100;
    
    System.out.println("----------------");
    
    A.m();
  }

}
