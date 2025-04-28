package com.immozone.immozone_backend.business;

import com.immozone.immozone_backend.dao.entities.Annonce;
import com.immozone.immozone_backend.dao.repositories.AnnonceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnnonceServiceImpl implements AnnonceService {
    private final AnnonceRepository annonceRepository;

    public AnnonceServiceImpl(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    @Override
    public List<Annonce> getAllAnnonces() {
        return annonceRepository.findAll();
    }

    @Override
    public Annonce getAnnonceById(Long id) {
        return annonceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Annonce not found"));
    }

    @Override
    public Annonce addAnnonce(Annonce annonce) {
        return annonceRepository.save(annonce);
    }

    @Override
    public Annonce updateAnnonce(Long id, Annonce annonce) {
        Annonce existing = getAnnonceById(id);
        existing.setTitle(annonce.getTitle());
        existing.setDescription(annonce.getDescription());
        existing.setType(annonce.getType());
        existing.setWilaya(annonce.getWilaya());
        existing.setNumberOfRooms(annonce.getNumberOfRooms());
        existing.setPrice(annonce.getPrice());
        existing.setPhotos(annonce.getPhotos());
        return annonceRepository.save(existing);
    }

    @Override
    public void deleteAnnonce(Long id) {
        annonceRepository.deleteById(id);
    }
}
