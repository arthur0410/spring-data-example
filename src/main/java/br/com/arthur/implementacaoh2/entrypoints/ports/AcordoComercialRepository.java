package br.com.arthur.implementacaoh2.entrypoints.ports;

import java.util.Date;

import br.com.arthur.implementacaoh2.entities.AcordoComercialDb;

public interface AcordoComercialRepository {

	AcordoComercialDb consultaAcordoComercial(Long idAcordoComercial, Long idVersaoAcordoComercial);
	
	AcordoComercialDb incluirAcordoComercial(AcordoComercialDb acordoComercialDb);
	
	void verificarSeExisteAcordoComercialAtivo(Integer idParceiro, Integer idProduto, 
			Date dataInicioVigencia, boolean vigenciaIndeterminada, Date dataFimVigencia);
}
