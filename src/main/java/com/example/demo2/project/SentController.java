package com.example.demo2.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/sent")
public class SentController {
    private final SentService sentService;
    private final SentRepository sentRepository;
    @Autowired
    public SentController(SentService sentService, SentRepository sentRepository) {
        this.sentService = sentService;
        this.sentRepository = sentRepository;
    }
    @GetMapping
    public List<Sent> getSent() {
        return sentService.getSent();
    }

    @GetMapping(path = "/{id}")
    public Sent getSentbyId(@PathVariable("id") Integer id ) {
        return sentService.getSentbyId(id);
    }

    @PostMapping
    public void addNewSent(@RequestBody Sent sent){
        sentService.addNewSent(sent);
    }

    @PutMapping(path = "/{id}")
    public Sent updateSent (@PathVariable ("id") Integer id, @RequestBody Sent sent) {
        Sent returnedSent = sentService.updateSent(id, sent);
        return returnedSent;
    }

    @DeleteMapping(path = "/{id}")
    public void deleteSent(@PathVariable("id") Integer id ) { sentService.deleteSent(id); }
}
