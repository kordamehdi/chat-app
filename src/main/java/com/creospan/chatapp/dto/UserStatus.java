package com.creospan.chatapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("UserStatus")
public class UserStatus implements Serializable {
    private String id;
    private String username;
    private List<String>  users = new ArrayList<>();
    private List<MessageDto> msgs =  new ArrayList<>();
}
