package com.ru.demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnoAdvice {
  @Before(value = "execution(* com.ru.UserDao.*(..))")
  public void before(){
    System.out.println("前置通知");
  }
}
