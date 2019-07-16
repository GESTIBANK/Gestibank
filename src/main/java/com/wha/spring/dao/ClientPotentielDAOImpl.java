package com.wha.spring.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.ClientPotentielDAO;
import com.wha.spring.model.ClientPotentiel;


@Repository("clientPotentielDao")
@Transactional
public class ClientPotentielDAOImpl extends AbstractDao implements ClientPotentielDAO {

	@Override
	public void addClientP (ClientPotentiel clientp) {
		
		em.persist(clientp);
		
	}

}
