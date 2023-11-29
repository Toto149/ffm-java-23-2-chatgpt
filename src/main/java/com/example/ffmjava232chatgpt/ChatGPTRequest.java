package com.example.ffmjava232chatgpt;

import java.util.List;

public record ChatGPTRequest(String model,
                             List<ChatGPTRequestMessage> messages
                             )
{
}
