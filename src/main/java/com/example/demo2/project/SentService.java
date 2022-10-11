package com.example.demo2.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SentService {

    private final SentRepository sentRepository;
    @Autowired
    public SentService(SentRepository sentRepository) {
        this.sentRepository = sentRepository;
    }
    public List<Sent> getSent() {
        return sentRepository.findAll();
    }
    public Sent getSentbyId(Integer id) {
        return sentRepository.findById(id).get();
    }

    public void addNewSent(Sent sent) {
        sentRepository.save(sent);
    }

    public Sent updateSent(Integer id, Sent sent) {
        Sent savedSent = sentRepository.findById(id).get();
        savedSent.setCreatedOn(sent.getCreatedOn());
        savedSent.setMessageId(sent.getMessageId());
        savedSent.setSenderId(sent.getSenderId());
        sentRepository.save(savedSent);
        return savedSent;
    }

    public void deleteSent(Integer id) { sentRepository.deleteById(id);}
}
