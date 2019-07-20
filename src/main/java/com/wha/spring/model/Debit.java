package com.wha.spring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Debit")
public class Debit extends Transaction {
	
	@Column( nullable=true)
	private int montant;
	@Column( nullable=true)
	private Date dateMvt= new Date();
	@Column( nullable=true)
	private String libelle;
}
