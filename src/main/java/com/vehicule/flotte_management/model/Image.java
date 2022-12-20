package com.vehicule.flotte_management.model;

import javax.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name="planeImg")
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Column(name = "img")
    private String img;
	@Column(name="idavion")
    private Integer avion;

    public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAvion() {
		return avion;
	}

	public void setAvion(Integer avion) {
		this.avion = avion;
	}

    
}
