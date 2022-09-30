package com.creospan.chatapp.controller;

import com.creospan.chatapp.dto.ChannelDto;
import com.creospan.chatapp.dto.EmployeeDto;
import com.creospan.chatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<Void> addEmployee(@RequestBody EmployeeDto employeeDto){
        userService.addEmployee(employeeDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/channels")
    public ResponseEntity<Void> addChannel(@RequestBody ChannelDto channelDto) {
        userService.addChannel(channelDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/channels/{id}")
    public ResponseEntity<Void> deleteChannel(@RequestParam Long id) {
        userService.deleteChannel(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteEmployee(@RequestParam Long id) {
        userService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}
