package com.example.ffmjava232chatgpt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("/chatgpt")
public class ChatGPTController {
    @Value("${openai-api-key")
    private String chatGPTApiKey;
    @PostMapping
    public String post(@RequestBody String prompt){
        ChatGPTResponse response = Objects.requireNonNull(
                WebClient.create()
                        .post()
                        .uri("https://api.openai.com/v1/chat/completions")
                        .header("Authorization", "Bearer " + chatGPTApiKey )
                        .bodyValue(new ChatGPTRequest("gpt-3.5-turbo",
                                List.of(new ChatGPTRequestMessage(
                                        "user",
                                        prompt
                                        )
                                    )
                                )
                        )
                        .retrieve()
                        .toEntity(ChatGPTResponse.class)
                        .block()
        ).getBody();

        if (response.choices().size()>0){
            return response.choices().get(0).message().content();
        }
        else {
            return "";
        }
    }
}
