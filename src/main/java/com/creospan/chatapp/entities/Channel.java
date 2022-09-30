package com.creospan.chatapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Channel {

    public static String GROUP = "group";
    public static String SIMPLE_CHAT = "simple chat";


    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name="CHAT_FK")
    private List<Message> messages = new ArrayList<>();

    @ManyToMany()
    @JoinTable(name = "EMP_CH" ,
            joinColumns = { @JoinColumn(name = "FK_CH")},
            inverseJoinColumns ={@JoinColumn(name = "FK_EMP")})
    private List<Employee> employees = new ArrayList<>();

    public String getChatType(){
        return employees.size() == 2 ? SIMPLE_CHAT : GROUP;
    }

}
