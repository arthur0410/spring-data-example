package br.com.arthur.implementacaoh2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arthur.implementacaoh2.entities.ContaId;
import br.com.arthur.implementacaoh2.entities.ContaParceiroDb;

public interface ContaParceiroRepositoryJpa extends JpaRepository<ContaParceiroDb, ContaId>{

}
