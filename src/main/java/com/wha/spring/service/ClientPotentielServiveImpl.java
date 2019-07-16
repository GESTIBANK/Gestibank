package com.wha.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.ClientPotentielDAO;
import com.wha.spring.iservice.ClientPotentielService;
import com.wha.spring.model.ClientPotentiel;


@Service("clientPotentielService")
@Transactional
public class ClientPotentielServiveImpl implements ClientPotentielService{

	@Autowired(required=true)
	ClientPotentielDAO clientPotentielDAO;
	
	@Override
	public void addClientP(ClientPotentiel clientp) {
		
		clientPotentielDAO.addClientP(clientp);
		
	}

}
