
package com.immozone.immozone_backend.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "annonces")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String type;
    private String wilaya;
    private int numberOfRooms;
    private double price;

    @ElementCollection
    private List<String> photos;
}
