package br.com.arthur.implementacaoh2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arthur.implementacaoh2.entities.MeioPagamentoDb;
import br.com.arthur.implementacaoh2.entities.MeioPagamentoId;

public interface MeioPagamentoRepositoryJpa extends JpaRepository<MeioPagamentoDb, MeioPagamentoId>{

}
