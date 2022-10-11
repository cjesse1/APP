package com.example.demo2.project;

import javax.persistence.*;
import javax.print.attribute.standard.DateTimeAtCreation;

@Entity
@Table
public class Inbox {
    @Id
    @SequenceGenerator(
            name = "inbox_sequence",
            sequenceName = "inbox_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "inbox_sequence"
    )
    private Integer receiverId;
    private String messageId;
    private String createdOn;

    public Inbox() {
    }

    public Inbox(Integer receiverId, String messageId, String createdOn) {
        this.receiverId = receiverId;
        this.messageId = messageId;
        this.createdOn = createdOn;
    }

    public Inbox(String messageId, String createdOn) {
        this.messageId = messageId;
        this.createdOn = createdOn;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "Inbox{" +
                "receiverId=" + receiverId +
                ", messageId='" + messageId + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }
}
