package com.vehicule.flotte_management.model;

import javax.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Compagnie")
@NoArgsConstructor
public class Compagnie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcompagnie", nullable = false)
    private Integer IdCompagnie;

    @Column(name = "compagnie")
    private String compagnie;

    public Integer getIdCompagnie() {
        return IdCompagnie;
    }

    public void setIdCompagnie(Integer IdCompagnie) {
        this.IdCompagnie = IdCompagnie;
    }

    public String getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(String compagnie) {
        this.compagnie = compagnie;
    }
}