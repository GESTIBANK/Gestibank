package com.wha.spring.model;

import java.io.File;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientPotentiel {
	
	private String name;
	private String username;
	private String email;
	private int revenuMens;
	private File[] piecesJustif;

}
