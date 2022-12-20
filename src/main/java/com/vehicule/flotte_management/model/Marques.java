package com.vehicule.flotte_management.model;

import javax.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Marques")
@NoArgsConstructor
public class Marques {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmarque", nullable = false)
    private Integer idMarque;

    @Column(name = "nommarque")
    private String marque;

    public Integer getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Integer idMarque) {
        this.idMarque = idMarque;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
}