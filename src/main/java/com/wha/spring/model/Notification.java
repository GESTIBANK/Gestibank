package com.wha.spring.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Notification")
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="numero_notification")
	private int numeroNotification;
	
	@Column(name="message")
	private String Message;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_creation")
	private Date date;
	
	@ManyToOne
    private Compte compte;
}
