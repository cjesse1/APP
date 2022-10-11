package com.example.demo2.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/contacts")
public class ContactsController {
    private final ContactsService contactsService;
    private final ContactsRepository contactsRepository;
    @Autowired
    public ContactsController(ContactsService contactsService, ContactsRepository contactsRepository) {
        this.contactsService = contactsService;
        this.contactsRepository = contactsRepository;
    }
    @GetMapping
    public List<Contacts> getContacts(){
       return contactsService.getContacts();
    }
    @GetMapping(path = "/{id}")
    public Contacts getContactsbyId(@PathVariable("id") Integer id ) {
        return contactsService.getContactsbyId(id);}

    @PostMapping
    public void addNewContacts(@RequestBody Contacts contacts){ contactsService.addNewContacts(contacts);}

    @PutMapping(path = "/{id}")
    public Contacts updateContacts (@PathVariable ("id") Integer id, @RequestBody Contacts contacts) {
        Contacts returnedContacts = contactsService.updateContacts(id, contacts);
        return returnedContacts;
    }

    @PatchMapping(path = "/{id}")
    public Contacts updateContactsEmail (@PathVariable("id") Integer id, @RequestBody Contacts contacts) {
        Contacts returnedContactsService = contactsService.updateContactsEmail(id, contacts);
        return returnedContactsService;
    }

    @DeleteMapping(path = "/{id}")
    public void deleteContacts(@PathVariable("id") Integer id ) { contactsService.deleteContacts(id); }
}
