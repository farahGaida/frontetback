package com.immozone.immozone_backend.business;

import com.immozone.immozone_backend.dao.entities.Annonce;
import java.util.List;

public interface AnnonceService {
    List<Annonce> getAllAnnonces();
    Annonce getAnnonceById(Long id);
    Annonce addAnnonce(Annonce annonce);
    Annonce updateAnnonce(Long id, Annonce annonce);
    void deleteAnnonce(Long id);
}
