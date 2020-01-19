package br.com.arthur.implementacaoh2.services;

import java.util.Date;

import org.springframework.stereotype.Repository;

import br.com.arthur.implementacaoh2.entities.AcordoComercialDb;
import br.com.arthur.implementacaoh2.entities.AcordoComercialId;
import br.com.arthur.implementacaoh2.entrypoints.ports.AcordoComercialRepository;
import br.com.arthur.implementacaoh2.repositories.AcordoComercialRepositoryJpa;

@Repository
public class AcordoComercialRepositoryImpl implements AcordoComercialRepository{

	private final AcordoComercialRepositoryJpa acordoComercialRepositoryJpa;

	public AcordoComercialRepositoryImpl(AcordoComercialRepositoryJpa acordoComercialRepositoryJpa) {
		this.acordoComercialRepositoryJpa = acordoComercialRepositoryJpa;
	}

	@Override
	public AcordoComercialDb consultaAcordoComercial(Long idAcordoComercial, Long idVersaoAcordoComercial) {
		return acordoComercialRepositoryJpa.findById(new AcordoComercialId(idAcordoComercial, idVersaoAcordoComercial))
			.orElseThrow(() -> new RuntimeException());
	}

	@Override
	public AcordoComercialDb incluirAcordoComercial(AcordoComercialDb acordoComercialDb) {
		return acordoComercialRepositoryJpa.save(acordoComercialDb);
	}

	@Override
	public void verificarSeExisteAcordoComercialAtivo(Integer idParceiro, Integer idProduto,
			Date dataInicioVigencia, boolean vigenciaIndeterminada, Date dataFimVigencia) {
		if (acordoComercialRepositoryJpa.consultarAcordoComercialAtivo(idParceiro, idProduto, dataInicioVigencia, vigenciaIndeterminada, dataFimVigencia)
				.isPresent()) {
			throw new RuntimeException();
		}
	}
	
}
