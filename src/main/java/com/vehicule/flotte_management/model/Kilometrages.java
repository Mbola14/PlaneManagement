package com.vehicule.flotte_management.model;

import javax.persistence.*;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Entity
@Table(name="kilometrages")
@NoArgsConstructor
public class Kilometrages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idkilometrage", nullable = false)
    private Integer id;
    @Column(name="date")
    private Date date;
    @Column(name="debutkm")
    private Double debutKm;
    @Column(name = "finkm")
    private Double finKm;
    @ManyToOne
    @JoinColumn(name = "idavion",referencedColumnName = "idavion")
    private Avion avion;

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Double getDebutKm() {
        return debutKm;
    }

    public Double getFinKm() {
        return finKm;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDebutKm(Double debutKm) {
        this.debutKm = debutKm;
    }

    public void setFinKm(Double finKm) {
        this.finKm = finKm;
    }
}
