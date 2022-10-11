package com.example.demo2.project;

import javax.persistence.*;
import javax.print.attribute.standard.DateTimeAtCreation;

@Entity
@Table
public class Sent {
    @Id
    @SequenceGenerator(
            name = "sent_sequence",
            sequenceName = "sent_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sent_sequence"
    )
    private Integer senderId;
    private String messageId;
    private String createdOn;

    public Sent() {
    }

    public Sent(Integer senderId, String messageId, String createdOn) {
        this.senderId = senderId;
        this.messageId = messageId;
        this.createdOn = createdOn;
    }

    public Sent(String messageId, String createdOn) {
        this.messageId = messageId;
        this.createdOn = createdOn;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
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
        return "Sent{" +
                "senderId=" + senderId +
                ", messageId='" + messageId + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }
}
