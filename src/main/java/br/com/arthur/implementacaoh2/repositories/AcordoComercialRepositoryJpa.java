package br.com.arthur.implementacaoh2.repositories;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.arthur.implementacaoh2.entities.AcordoComercialDb;
import br.com.arthur.implementacaoh2.entities.AcordoComercialId;

public interface AcordoComercialRepositoryJpa extends JpaRepository<AcordoComercialDb, AcordoComercialId> {

	@Query("Select acordo from AcordoComercialDb acordo "
			+ "where acordo.idParceiro = ?1"
			+ "  and acordo.idProduto = ?2"
			+ "  and acordo.idSituacao = br.com.arthur.implementacaoh2.entities.SituacaoDbType.ATIVO"
			+ "  and ((acordo.dataInicioVigencia >= ?3 and acordo.dataInicioVigencia <= ?5) "
			+ "      or (acordo.dataFimVigencia >= ?3 and acordo.dataFimVigencia <= ?5)"
			+ "      or (acordo.dataInicioVigencia <= ?3 and acordo.dataFimVigencia >= ?5)"
			+ "      or (acordo.vigenciaIndeterminada = true and ?4 = true)"
			+ "      or (acordo.vigenciaIndeterminada = true and ?4 = false and acordo.dataInicioVigencia < ?5))")
	Optional<AcordoComercialDb> consultarAcordoComercialAtivo(Integer idParceiro, Integer idProduto, 
			Date dataInicioVigencia, boolean vigenciaIndeterminada, Date dataFimVigencia);
}
