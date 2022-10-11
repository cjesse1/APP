package com.example.demo2.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesService {
    private final MessagesRepository messagesRepository;
    @Autowired
    public MessagesService(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }
    public List<Messages> getMessages() {
        return messagesRepository.findAll();
    }

    public Messages getMessagesbyId(Integer id) {
        return messagesRepository.findById(id).get();
    }

    public void addNewMessages(Messages messages) {
        try {
            messagesRepository.save(messages);
        }catch(Exception exception){
            System.out.println(exception);
        }
    }

    public Messages updateMessages(Integer id, Messages messages) {
        Messages savedMessages = messagesRepository.findById(id).get();
        savedMessages.setCreatedOn(messages.getCreatedOn());
        savedMessages.setSubject(messages.getSubject());
        savedMessages.setMessage(messages.getMessage());
        savedMessages.setParentMessageId(messages.getParentMessageId());
        savedMessages.setStatus(messages.getStatus());
        messagesRepository.save(savedMessages);
        return savedMessages;
    }

    public void deleteMessages(Integer id) {
        messagesRepository.deleteById(id);
    }
}
