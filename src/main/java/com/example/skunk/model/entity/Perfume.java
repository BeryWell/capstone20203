package com.example.skunk.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Perfume {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "brand")
    private String brand;
    @ManyToMany
    private List<Note> topNotes;
    @ManyToMany
    private List<Note> heartNotes;
    @ManyToMany
    private List<Note> baseNotes;

    @Column(name = "url")
    private String imgUrl;
}
