package com.example.demo2.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class InboxService {
    private final InboxRepository inboxRepository;
    @Autowired
    public InboxService(InboxRepository inboxRepository) {
        this.inboxRepository = inboxRepository;
    }

    public List<Inbox> getInbox(){
        return inboxRepository.findAll();
    }

    public Inbox getInboxbyId(Integer id) { return inboxRepository.findById(id).get();
    }

    public void addNewInbox(Inbox inbox) {
        inboxRepository.save(inbox);
    }

    public Inbox updateInbox(Integer id, Inbox inbox) {
        Inbox savedInbox = inboxRepository.findById(id).get();
        savedInbox.setCreatedOn(inbox.getCreatedOn());
        savedInbox.setMessageId(inbox.getMessageId());
        savedInbox.setReceiverId(inbox.getReceiverId());
        inboxRepository.save(savedInbox);
        return savedInbox;
    }

    public void deleteInbox(Integer id) { inboxRepository.deleteById(id); }
}
