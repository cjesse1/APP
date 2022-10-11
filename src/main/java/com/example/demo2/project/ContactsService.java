package com.example.demo2.project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ContactsService {
    private final ContactsRepository contactsRepository;
    @Autowired
    public ContactsService(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }
    public List<Contacts> getContacts(){
        return contactsRepository.findAll();
    }
    public Contacts getContactsbyId(Integer id) {
        return contactsRepository.findById(id).get();
    }

    public void addNewContacts(Contacts contacts) {
        contactsRepository.save(contacts);
    }

    public Contacts updateContacts(Integer id, Contacts contacts) {
        Contacts savedContacts = contactsRepository.findById(id).get();
        savedContacts.setEmail(contacts.getEmail());
        savedContacts.setFirstName(contacts.getFirstName());
        savedContacts.setLastName(contacts.getLastName());
        contactsRepository.save(savedContacts);
        return savedContacts;
    }

    public Contacts updateContactsEmail(Integer id, Contacts contacts) {
        Contacts savedContacts = contactsRepository.findById(id).get();
        savedContacts.setEmail(contacts.getEmail());
        contactsRepository.save(savedContacts);
        return savedContacts;
    }

    public void deleteContacts(Integer id) { contactsRepository.deleteById(id);
    }
}
