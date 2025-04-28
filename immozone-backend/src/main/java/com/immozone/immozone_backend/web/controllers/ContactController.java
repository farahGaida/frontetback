package com.immozone.immozone_backend.web;

import com.immozone.immozone_backend.business.services.ContactService;
import com.immozone.immozone_backend.dao.entities.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {

    private final ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping
    public List<Contact> getAll() {
        return service.getAllContacts();
    }

    @GetMapping("/{id}")
    public Contact getOne(@PathVariable Long id) {
        return service.getContactById(id);
    }

    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        return service.addContact(contact);
    }

    @PutMapping("/{id}")
    public Contact update(@PathVariable Long id, @RequestBody Contact contact) {
        return service.updateContact(id, contact);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteContact(id);
    }
} 