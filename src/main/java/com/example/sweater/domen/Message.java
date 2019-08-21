package com.example.sweater.domen;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Message {

    public Message(){}

    public Message(String text, String tag,User user) {
        this.text = text;
        this.tag = tag;
        this.author=user;
    }

    public String getAuthorName(){
        return author != null ? author.getUsername():"<none>";
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String text;
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User author;

    private String filename;
}
