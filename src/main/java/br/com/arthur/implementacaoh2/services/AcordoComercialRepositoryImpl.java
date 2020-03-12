package br.com.arthur.implementacaoh2.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.arthur.implementacaoh2.entities.AcordoComercialDb;
import br.com.arthur.implementacaoh2.entities.AcordoComercialId;
import br.com.arthur.implementacaoh2.entities.AcordoComercialIdDto;
import br.com.arthur.implementacaoh2.entrypoints.ports.AcordoComercialRepository;
import br.com.arthur.implementacaoh2.repositories.AcordoComercialRepositoryJpa;

@Repository
public class AcordoComercialRepositoryImpl implements AcordoComercialRepository{

	private final AcordoComercialRepositoryJpa acordoComercialRepositoryJpa;

	public AcordoComercialRepositoryImpl(AcordoComercialRepositoryJpa acordoComercialRepositoryJpa) {
		this.acordoComercialRepositoryJpa = acordoComercialRepositoryJpa;
	}

	@Override
	public AcordoComercialDb consultaAcordoComercial(Integer idAcordoComercial, Integer idVersaoAcordoComercial) {
		return acordoComercialRepositoryJpa.findById(new AcordoComercialId(idAcordoComercial, idVersaoAcordoComercial))
			.orElseThrow(() -> new RuntimeException());
	}

	@Override
	public AcordoComercialDb incluirAcordoComercial(AcordoComercialDb acordoComercialDb) {
		acordoComercialDb.setDataInclusao(LocalDateTime.now());
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

	@Override
	public List<AcordoComercialDb> consultaAcordosComerciais() {
		return acordoComercialRepositoryJpa.consultarAcordosComerciais()
				.stream()
				.map(acordoComercialId -> consultaAcordoComercial(acordoComercialId.getIdAcordoComercial(),
						acordoComercialId.getIdVersaoAcordoComercial()))
				.collect(Collectors.toList());
	}
	
}
