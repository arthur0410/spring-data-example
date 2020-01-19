package br.com.arthur.implementacaoh2.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.arthur.implementacaoh2.entities.ContaExternaDb;
import br.com.arthur.implementacaoh2.entities.ContaId;
import br.com.arthur.implementacaoh2.entities.ContaInternaDb;
import br.com.arthur.implementacaoh2.entities.ContaType;
import br.com.arthur.implementacaoh2.repositories.ContaExternaRepositoryJpa;
import br.com.arthur.implementacaoh2.repositories.ContaInternaRepositoryJpa;
import br.com.arthur.implementacaoh2.repositories.ContaParceiroRepositoryJpa;

@Component
public class Inicializador {

	@Autowired ContaParceiroRepositoryJpa contaParceiroRepositoryJpa;
	@Autowired ContaInternaRepositoryJpa contaInternaRepositoryJpa;
	@Autowired ContaExternaRepositoryJpa contaExternaRepositoryJpa;
	
    @PostConstruct
    public void init() {
    	ContaId contaIdUm = new ContaId(1, 1);
    	ContaInternaDb contaInternaDb = new ContaInternaDb(contaIdUm, ContaType.INTERNA);
    	contaInternaDb.setAgencia("1500");
    	contaInternaDb.setBanco("341");
    	contaInternaDb.setConta("07715");
    	contaInternaDb.setDigitoVerificador("1");
    	contaInternaRepositoryJpa.save(contaInternaDb);
    	
    	ContaId contaIdDois = new ContaId(1, 2);
    	ContaExternaDb contaExternaDb = new ContaExternaDb(contaIdDois, ContaType.EXTERNA);
    	contaExternaDb.setAgencia("12345");
    	contaExternaDb.setBanco("237");
    	contaExternaDb.setConta("123456789");
    	contaExternaRepositoryJpa.save(contaExternaDb);
    	
    }
}
