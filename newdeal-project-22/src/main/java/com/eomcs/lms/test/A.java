package com.eomcs.lms.test;

public class A {
  static int v1; // 클래스가 로딩될 때 준비된다.
  int v2;
  int v3;
  
  public int getV2() {
    return this.v2;
  }

  public void setV2(int v2) {
    this.v2 = v2;
  }

  public int getV3() {
    return v3;
  }

  public void setV3(int v3) {
    this.v3 = v3;
  }

  static { // 최초로 클래스가 로딩될 때 실행됨.
    System.out.println("A클래스 로딩되었음!");
  }
  
  public static void m() {
    
  }
  
 
}






