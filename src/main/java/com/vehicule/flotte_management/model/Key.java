package com.vehicule.flotte_management.model;

import javax.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name="key")
@NoArgsConstructor
public class Key {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "keyid", nullable = false)
    private Integer id;
    @Column(name="secretkey")
    private String secretKey;

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
}
