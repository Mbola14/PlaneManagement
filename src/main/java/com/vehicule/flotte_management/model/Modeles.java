package com.vehicule.flotte_management.model;

import javax.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name="type")
@NoArgsConstructor
public class Modeles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idtype", nullable = false)
    private Integer idType;
    @Column(name="type")
    private String type;
    @ManyToOne(targetEntity = Marques.class)
    @JoinColumn(name = "idmarque",referencedColumnName = "idmarque")
    private Marques marque;

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public Integer getIdMarque() {
//        return idMarque;
//    }

//    public void setIdMarque(Integer idMarque) {
//        this.idMarque = idMarque;
//    }

    public Marques getMarque() {
        return marque;
    }

    public void setMarque(Marques marque) {
        this.marque = marque;
    }
}
