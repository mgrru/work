package com.example.r1;

import java.util.Scanner;

public class Course {
  private String course1;
  private String course2;
  private String course3;
  private int input;

  public Course() {
    course1 = "c#";
    course2 = "java";
    course3 = "rust";
  }

  private void input() throws Exception {
    Scanner in = new Scanner(System.in);
    System.out.println("输入课程代号(1-3):");
    if (in.hasNext()) {
      input = in.nextInt();
      in.close();
    } else {
      in.close();
      throw new Exception();
    }
  }

  public void select() {
    try {
      input();
      if (input == 1) {
        System.out.println(course1);
      } else if (input == 2) {
        System.out.println(course2);
      } else if (input == 3) {
        System.out.println(course3);
      } else {
        throw new Exception();
      }

    } catch (Exception e) {
      System.out.println("输入错误");
    } finally {
      System.out.println("欢迎建议");
    }
  }
}
