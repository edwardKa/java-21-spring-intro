package com.greetings;

import com.greetings.model.Greeting;
import com.greetings.service.GreetingsReaderService;
import com.greetings.service.HelloWorldService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.greetings")
@PropertySource("classpath:application.properties")
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        context.register(App.class);
        context.refresh();

        //starting Spring
        HelloWorldService service =
                context.getBean(HelloWorldService.class);
        service.printMessage();

        System.out.println("--------------------------------");
        System.out.println();
        System.out.println();
        GreetingsReaderService greetingService = context.getBean(GreetingsReaderService.class);
        Greeting greetingsFromFile = greetingService.getGreetingsFromFile();
        System.out.println("From: " + greetingsFromFile.getFromWho());
        System.out.println("Message: " + greetingsFromFile.getMessage());
    }
}
