package com.example.demo2.project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "api/v1/inbox")
public class InboxController {
    private final InboxService inboxService;
    @Autowired
    public InboxController(InboxService inboxService) {
        this.inboxService = inboxService;
    }
    @GetMapping
    public List<Inbox> getInbox(){
        return inboxService.getInbox();
    }
    @GetMapping(path = "/{id}")
    public Inbox getInboxbyId(@PathVariable("id") Integer id ) {
        return inboxService.getInboxbyId(id);}

    @PostMapping
    public void addNewInbox(@RequestBody Inbox inbox){
        inboxService.addNewInbox(inbox);
    }

    @PutMapping(path = "/{id}")
    public Inbox updateInbox (@PathVariable ("id") Integer id, @RequestBody Inbox inbox) {
        Inbox returnedInbox = inboxService.updateInbox(id, inbox);
        return returnedInbox;
    }

    @DeleteMapping(path = "/{id}")
    public void deleteInbox(@PathVariable("id") Integer id ) { inboxService.deleteInbox(id); }

}
