package br.com.arthur.implementacaoh2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arthur.implementacaoh2.entities.CanalDisponivelDb;
import br.com.arthur.implementacaoh2.entities.CanalDisponivelId;

public interface CanalDisponivelRepositoryJpa extends JpaRepository<CanalDisponivelDb, CanalDisponivelId>{

}
