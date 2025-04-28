package com.immozone.immozone_backend.business.serviceImpl;

import com.immozone.immozone_backend.business.services.ContactService;
import com.immozone.immozone_backend.dao.entities.Contact;
import com.immozone.immozone_backend.dao.repositories.ContactRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contact not found"));
    }

    @Override
    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Long id, Contact contact) {
        Contact existing = getContactById(id);
        existing.setEmail(contact.getEmail());
        existing.setSubject(contact.getSubject());
        existing.setDescription(contact.getDescription());
        return contactRepository.save(existing);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
} 