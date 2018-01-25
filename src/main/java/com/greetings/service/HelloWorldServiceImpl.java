package com.greetings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Autowired
    private AnotherService anotherService;

    public void printMessage() {
        String myMessage = "Message";
        System.out.println(myMessage);

        anotherService.printMessageFromParameter(myMessage);
    }
}
