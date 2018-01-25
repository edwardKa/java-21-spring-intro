package com.greetings.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greetings.model.Greeting;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class GreetingsReaderServiceImpl implements
        GreetingsReaderService {

    @Value("${file.path}")
    private String filepath;

    @Value("${file.name}")
    private String filename;

    @SneakyThrows
    public Greeting getGreetingsFromFile() {
//        ObjectMapper mapper = new ObjectMapper();
//        Greeting greeting = new Greeting("Hello", "From spring");
//        System.out.println(mapper.writeValueAsString(greeting));

        List<String> strings = FileUtils.readLines(
                new File(filepath + filename));
        StringBuilder builder = new StringBuilder();
        for (String s : strings) {
            builder.append(s);
        }

        String fileContent = builder.toString();

        return new ObjectMapper().readValue(fileContent, Greeting.class);
    }
}
