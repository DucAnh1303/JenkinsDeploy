package com.service.jenkins.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "manage")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    public ManageEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
