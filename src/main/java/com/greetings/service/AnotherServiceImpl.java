package com.greetings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AnotherServiceImpl implements AnotherService {

    @Autowired
    private GreetingsReaderService greetingsReaderService;

    @Value("${greetings.message}")
    private String propsMessage;

    public void printMessageFromParameter(String message) {
        System.out.println(message);


        System.out.println("------------------");

        System.out.println("Greetings from application.props :");
        System.out.println(propsMessage);
    }


    public void printJsonGreeting() {
        greetingsReaderService.getGreetingsFromFile();
    }
}
