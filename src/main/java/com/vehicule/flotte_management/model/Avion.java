package com.vehicule.flotte_management.model;

import javax.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name="avion")
@NoArgsConstructor
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idavion", nullable = false)
    private Integer idAvion;
    @ManyToOne(targetEntity = Modeles.class)
    @JoinColumn(name = "idtype",referencedColumnName = "idtype")
    private Modeles modele;
    @ManyToOne(targetEntity = Compagnie.class)
    @JoinColumn(name = "idcompagnie",referencedColumnName = "idcompagnie")
    private Compagnie compagnie;

    public Compagnie getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(Compagnie compagnie) {
        this.compagnie = compagnie;
    }

    public Integer getidAvion() {
        return idAvion;
    }

    public void setidAvion(Integer idAvion) {
        this.idAvion = idAvion;
    }

    public Modeles getModele() {
        return modele;
    }

    public void setModele(Modeles modele) {
        this.modele = modele;
    }
}