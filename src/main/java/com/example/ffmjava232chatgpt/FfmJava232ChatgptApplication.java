package com.example.ffmjava232chatgpt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FfmJava232ChatgptApplication {

    @Value("${openai-api-key}")
    private String apiKey;

    public static void main(String[] args) {
        SpringApplication.run(FfmJava232ChatgptApplication.class, args);
    }

}
