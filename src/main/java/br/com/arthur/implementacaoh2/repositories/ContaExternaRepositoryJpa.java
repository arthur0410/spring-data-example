package br.com.arthur.implementacaoh2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arthur.implementacaoh2.entities.ContaExternaDb;
import br.com.arthur.implementacaoh2.entities.ContaId;

public interface ContaExternaRepositoryJpa extends JpaRepository<ContaExternaDb, ContaId>{

}
