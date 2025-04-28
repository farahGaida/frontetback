package com.immozone.immozone_backend.dao.repositories;

import com.immozone.immozone_backend.dao.entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
}
