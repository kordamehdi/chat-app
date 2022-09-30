package com.creospan.chatapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue
    private Long id;
    private String content;
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name="USER_FK")
    private Employee sender;
}
