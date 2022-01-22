package com.sbrf.reboot;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan(basePackages = "com.github.tagirqa")
public class Main {
    public static void main(String[] args) {
        getClassPathXMLContext();
        getAnnotationConfigContext();

    }

    public static void getClassPathXMLContext(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("context.xml");
    }

    public static void getAnnotationConfigContext(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
    }
}
