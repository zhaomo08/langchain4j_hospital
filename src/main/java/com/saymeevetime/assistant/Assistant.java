package com.saymeevetime.assistant;

import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 *
 * @author jiacheng
 * @date 28/8/25 21:39 Thursday
 * @description :
 *
 */


//因为我们在配置文件中同时配置了多个大语言模型，所以需要在这里明确指定（EXPLICIT）模型的beanName（qwenChatModel）
@AiService(wiringMode = EXPLICIT,
        chatModel = "qwenChatModel")
public interface Assistant {

    String chat(String userMessage);
}
