package com.saymeevetime.controller;

import com.saymeevetime.assistant.HospitalAgent;
import com.saymeevetime.bean.ChatForm;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jiacheng
 * @date 28/8/25 23:06 Thursday
 * @description :
 *
 */
@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalAgent hospitalAgent;


    @Operation(summary = "对话")
    @PostMapping("/chat")
    public String chat(@RequestBody ChatForm chatForm) {
        return hospitalAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }
}
