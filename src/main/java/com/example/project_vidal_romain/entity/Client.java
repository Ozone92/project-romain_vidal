package com.example.project_vidal_romain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    private Integer postal;

    @Getter
    @Setter
    private String city;

    @Getter
    @Setter
    private Integer phone;

    @ManyToOne
    @JoinColumn(name = "conseiller_id")
    @Getter
    private Conseiller conseiller;

    public void setConseiller(Conseiller conseiller) {
        if (this.conseiller != null) {
            this.conseiller.getClients().remove(this);
        }

        this.conseiller = conseiller;
        conseiller.getClients().add(this);
    }

    @OneToMany(cascade = CascadeType.REMOVE)
    @Getter
    private final Set<Compte> comptes = new HashSet<>();
}
