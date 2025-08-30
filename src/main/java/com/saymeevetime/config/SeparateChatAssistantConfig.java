package com.saymeevetime.config;

import com.saymeevetime.store.MongoChatMemoryStore;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author jiacheng
 * @date 28/8/25 22:04 Thursday
 * @description :
 *
 */
@Configuration
public class SeparateChatAssistantConfig {


    //注入持久化对象
    @Autowired
    private MongoChatMemoryStore mongoChatMemoryStore;


    @Bean
    ChatMemoryProvider chatMemoryProvider() {
        return memoryId -> MessageWindowChatMemory.builder()
                .id(memoryId)
                .maxMessages(10)
                .chatMemoryStore(mongoChatMemoryStore)
                .build();
    }
}
