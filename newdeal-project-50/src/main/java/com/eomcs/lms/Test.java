package com.eomcs.lms;

import java.util.Scanner;

public class Test {

  public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);
    while (true) {
      System.out.print("숫자? ");
      int i = Integer.parseInt(keyboard.nextLine());
      
      System.out.println(i & 7);
    }

  }

}





