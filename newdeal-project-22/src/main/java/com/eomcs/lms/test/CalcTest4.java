package com.eomcs.lms.test;

public class CalcTest4 {

  public static void main(String[] args) throws Exception {
    Calculator3 c1 = new Calculator3();
    Calculator3 c2 = new Calculator3();
    
    c1.plus(100);
    c1.plus(50);
    c1.minus(80);
    
    c2.plus(10);
    c2.plus(5);
    c2.minus(8);
    
    System.out.println(c1.result);
    System.out.println(c2.result);
    
    Calculator3 p3 = null;
    p3.plus(100);
    
  }

}







