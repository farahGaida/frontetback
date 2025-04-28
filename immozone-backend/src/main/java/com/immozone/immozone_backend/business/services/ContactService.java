package com.immozone.immozone_backend.business.services;

import com.immozone.immozone_backend.dao.entities.Contact;
import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();
    Contact getContactById(Long id);
    Contact addContact(Contact contact);
    Contact updateContact(Long id, Contact contact);
    void deleteContact(Long id);
} 