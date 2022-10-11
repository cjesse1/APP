package com.example.demo2.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "api/v1/messages")
public class MessagesController {
    private final MessagesService messagesService;
    private final MessagesRepository messagesRepository;
    @Autowired
    public MessagesController(MessagesService messagesService, MessagesRepository messagesRepository) {
        this.messagesService = messagesService;
        this.messagesRepository = messagesRepository;
    }
    @GetMapping
    public List<Messages> getMessages() {
        return messagesService.getMessages();
    }
    @GetMapping(path = "/{id}")
    public Messages getMessagesbyId(@PathVariable("id") Integer id ) {
        return messagesService.getMessagesbyId(id);}

    @PostMapping
    public void addNewMessages(@RequestBody Messages messages){
        messagesService.addNewMessages(messages);
    }

    @PutMapping(path = "/{id}")
    public Messages updateMessages (@PathVariable ("id") Integer id, @RequestBody Messages messages) {
        Messages returnedMessages = messagesService.updateMessages(id, messages);
        return returnedMessages;
    }

    @DeleteMapping(path = "/{id}")
    public void deleteMessages(@PathVariable("id") Integer id ) { messagesService.deleteMessages(id); }
}
