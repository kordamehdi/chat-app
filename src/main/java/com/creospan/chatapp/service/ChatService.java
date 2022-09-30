package com.creospan.chatapp.service;

import com.creospan.chatapp.dto.MessageDto;
import com.creospan.chatapp.dto.UserStatus;
import com.creospan.chatapp.repository.UserStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    @Autowired
    private UserStatusRepository userStatusRepository;

    public UserStatus saveUser(String username){

        Optional<UserStatus> optionalUserStatus =  userStatusRepository.findById("my-app");
        UserStatus userStatus = optionalUserStatus.orElse(null);
        if(userStatus != null){
            if(!userStatus.getUsers().contains(username)){
                userStatus.getUsers().add(username);
                userStatusRepository.save(userStatus);
            }
        }else{
             userStatus =
                    new UserStatus("my-app","", List.of(username) ,new ArrayList<>());
            userStatusRepository.save(userStatus);
        }
        return userStatus;
    }

    public UserStatus saveMessage(String username , String content){

        Optional<UserStatus> optionalUserStatus =  userStatusRepository.findById("my-app");
        UserStatus userStatus = optionalUserStatus.get();
        MessageDto messageDto = new MessageDto(content, LocalDateTime.now() ,username);
        optionalUserStatus.get()
                .getMsgs()
                .add(messageDto);
        userStatus= userStatusRepository.save(userStatus);
        return userStatus;
    }
}
