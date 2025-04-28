package com.immozone.immozone_backend.web;

import com.immozone.immozone_backend.dao.entities.Annonce;
import com.immozone.immozone_backend.business.AnnonceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/api/annonces")
@CrossOrigin(origins = "http://localhost:4200")
public class AnnonceController {

    private final AnnonceService service;

    public AnnonceController(AnnonceService service) {
        this.service = service;
    }

    @GetMapping
    public List<Annonce> getAll() {
        return service.getAllAnnonces();
    }

    @GetMapping("/{id}")
    public Annonce getOne(@PathVariable Long id) {
        return service.getAnnonceById(id);
    }

    @PostMapping
    public Annonce create(@RequestBody Annonce annonce) {
        return service.addAnnonce(annonce);
    }

    @PutMapping("/{id}")
    public Annonce update(@PathVariable Long id, @RequestBody Annonce annonce) {
        return service.updateAnnonce(id, annonce);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteAnnonce(id);
    }
}
