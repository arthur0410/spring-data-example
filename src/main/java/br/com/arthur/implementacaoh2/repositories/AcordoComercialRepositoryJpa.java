package br.com.arthur.implementacaoh2.repositories;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.arthur.implementacaoh2.entities.AcordoComercialDb;
import br.com.arthur.implementacaoh2.entities.AcordoComercialId;
import br.com.arthur.implementacaoh2.entities.AcordoComercialIdDto;

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
	
	@Query(value = "SELECT AC.ID_ACORDO_COMERCIAL as idAcordoComercial, AC.ID_VERSAO_ACORDO_COMERCIAL as idVersaoAcordoComercial "
			+ "FROM (SELECT ID_ACORDO_COMERCIAL, MAX(ID_VERSAO_ACORDO_COMERCIAL) AS MAIOR_VERSAO "
			        + "FROM ACORDO_COMERCIAL "
			        + "GROUP BY ID_ACORDO_COMERCIAL) " 
			+ "as x INNER JOIN ACORDO_COMERCIAL as AC "
			+ "ON x.ID_ACORDO_COMERCIAL = AC.ID_ACORDO_COMERCIAL AND "
			+ "x.MAIOR_VERSAO = AC.ID_VERSAO_ACORDO_COMERCIAL "
			+ "ORDER BY DATA_INCLUSAO DESC",
			countQuery = "SELECT ID_ACORDO_COMERCIAL, MAX(ID_VERSAO_ACORDO_COMERCIAL) " + 
						   "FROM ACORDO_COMERCIAL " + 
						   "GROUP BY ID_ACORDO_COMERCIAL",
			nativeQuery = true)
	Page<AcordoComercialIdDto> consultarAcordosComerciais(Pageable pageable);
}
