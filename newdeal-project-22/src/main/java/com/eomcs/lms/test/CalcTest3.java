package com.eomcs.lms.test;

public class CalcTest3 {

  public static void main(String[] args) throws Exception {
    Calculator2 c1 = new Calculator2();
    Calculator2 c2 = new Calculator2();
    
    Calculator2.plus(c1,100);
    Calculator2.plus(c1,50);
    Calculator2.minus(c1,80);
    
    Calculator2.plus(c2,10);
    Calculator2.plus(c2,5);
    Calculator2.minus(c2,8);
    
    System.out.println(c1.result);
    System.out.println(c2.result);
  }

}
