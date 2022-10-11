package com.example.demo2.project;

import javax.persistence.*;
import javax.print.attribute.standard.DateTimeAtCreation;

@Entity
@Table
public class Messages {
    @Id
    @SequenceGenerator(
            name = "messages_sequence",
            sequenceName = "messages_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "messages_sequence"
    )
    private Integer id;
    private String createdOn;
    private String subject;
    private String message;
    private Integer parentMessageId;
    private String status;

    public Messages() {
    }

    public Messages(Integer id, String createdOn, String subject, String message, Integer parentMessageId, String status) {
        this.id = id;
        this.createdOn = createdOn;
        this.subject = subject;
        this.message = message;
        this.parentMessageId = parentMessageId;
        this.status = status;
    }

    public Messages(String createdOn, String subject, String message, Integer parentMessageId, String status) {
        this.createdOn = createdOn;
        this.subject = subject;
        this.message = message;
        this.parentMessageId = parentMessageId;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getParentMessageId() {
        return parentMessageId;
    }

    public void setParentMessageId(Integer parentMessageId) {
        this.parentMessageId = parentMessageId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "id=" + id +
                ", createdOn=" + createdOn +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", parentMessageId=" + parentMessageId +
                ", status='" + status + '\'' +
                '}';
    }
}
