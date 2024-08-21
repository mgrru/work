package com.ru;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
        App app1 = (App) app.getBean("App");
        
        System.out.println(app1.username + "Hello World!");
    }
}
