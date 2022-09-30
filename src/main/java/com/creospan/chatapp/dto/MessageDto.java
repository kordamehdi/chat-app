package com.creospan.chatapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("MessageDto")

public class MessageDto {

    private String content;
    private LocalDateTime dateTime;
    private String from;
}
