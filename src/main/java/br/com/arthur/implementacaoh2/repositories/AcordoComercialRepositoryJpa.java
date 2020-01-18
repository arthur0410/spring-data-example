package br.com.arthur.implementacaoh2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arthur.implementacaoh2.entities.AcordoComercialDb;
import br.com.arthur.implementacaoh2.entities.AcordoComercialId;

public interface AcordoComercialRepositoryJpa extends JpaRepository<AcordoComercialDb, AcordoComercialId> {

}
