package com.saymeevetime.bean;

import lombok.Data;

/**
 *
 * @author jiacheng
 * @date 28/8/25 23:05 Thursday
 * @description :
 *
 */
@Data
public class ChatForm {

    // 对话ID
    private Long memoryId;
    // 用户问题
    private String message;
}
