package com.vehicule.flotte_management.model;

import javax.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CompagnieAssurance")
@NoArgsConstructor
public class CompagnieAssurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idca", nullable = false)
    private Integer IdCA;

    @Column(name = "comp_assurance")
    private String compagnie;

    public String getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(String compagnie) {
        this.compagnie = compagnie;
    }

    public Integer getIdCA() {
        return IdCA;
    }

    public void setIdCA(Integer idCA) {
        IdCA = idCA;
    }
}