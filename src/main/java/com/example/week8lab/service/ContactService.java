package com.example.week8lab.service;

import com.example.week8lab.dto.ContactDTO;
import com.example.week8lab.dto.NameDTO;
import com.example.week8lab.model.Contact;
import com.example.week8lab.model.Name;
import com.example.week8lab.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact addContact(ContactDTO contactDTO) {
        Contact contact = new Contact();
        contact.setCompany(contactDTO.getCompany());
        contact.setTitle(contactDTO.getTitle());

        NameDTO nameDTO = contactDTO.getName();

        if (nameDTO != null) {
            Name name = new Name();
            name.setSalutation(nameDTO.getSalutation());
            name.setFirstName(nameDTO.getFirstName());
            name.setMiddleName(nameDTO.getMiddleName());
            name.setLastName(nameDTO.getLastName());
            contact.setName(name);
        }

        return contactRepository.save(contact);
    }
}
