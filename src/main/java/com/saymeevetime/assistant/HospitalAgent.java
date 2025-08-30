package com.saymeevetime.assistant;

/**
 *
 * @author jiacheng
 * @date 28/8/25 23:02 Thursday
 * @description :
 *
 */

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(
        wiringMode = EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemoryProvider ="chatMemoryProviderHospital",
        tools = "appointmentTools")
public interface HospitalAgent {

    @SystemMessage(fromResource = "hospital-prompt-template.txt")
    String chat(@MemoryId Long memoryId, @UserMessage String userMessage);

}
