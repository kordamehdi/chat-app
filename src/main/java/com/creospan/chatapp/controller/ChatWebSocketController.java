package com.creospan.chatapp.controller;

import com.creospan.chatapp.dto.MessageDto;
import com.creospan.chatapp.dto.UserStatus;
import com.creospan.chatapp.entities.Message;
import com.creospan.chatapp.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatWebSocketController {

    @Autowired
    ChatService chatService;

    @MessageMapping("/connected/{user}")
    @SendTo("/topic/updateUsers")
    public UserStatus newUser( @DestinationVariable String user ) throws InterruptedException {
        return chatService.saveUser(user);
    }

    @MessageMapping("/send/{from}")
    @SendTo("/topic/updateUsers")
    public UserStatus sendMessage( @DestinationVariable String from ,
                                   @Payload  String message) throws InterruptedException {

        return chatService.saveMessage(from , message);
    }

}
