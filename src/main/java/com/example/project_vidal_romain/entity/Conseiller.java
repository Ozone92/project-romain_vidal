package com.example.project_vidal_romain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Conseiller {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private final Set<Client> clients = new HashSet<>();
}
