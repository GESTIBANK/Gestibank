package com.wha.spring.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

import javax.persistence.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Credit")
public class Credit extends Transaction{

	@Column( nullable=true)
	private int montant;
	@Column( nullable=false)
	private String type="Credit";
	@Column( nullable=true)
	private Date dateMvt= new Date();
	@Column( nullable=true)
	private String libelle;
}
