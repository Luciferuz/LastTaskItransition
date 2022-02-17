package com.antsiferov.lasttaskitransition.entity;

import lombok.Data;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "messages_table")
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String subject;

    @Column
    private String text;

    @Column
    private String sender;

    @Column
    private String recipient;

    @Column
    private String time;

    public Message() {

    }

    public Message(String subject, String text, String sender, String recipient) {
        this.subject = subject;
        this.text = text;
        this.sender = sender;
        this.recipient = recipient;
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        this.time = df.format(new Date());
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}