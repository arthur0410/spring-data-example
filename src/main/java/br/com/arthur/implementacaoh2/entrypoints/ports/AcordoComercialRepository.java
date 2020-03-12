package br.com.arthur.implementacaoh2.entrypoints.ports;

import java.util.Date;
import java.util.List;

import br.com.arthur.implementacaoh2.entities.AcordoComercialDb;

public interface AcordoComercialRepository {

	AcordoComercialDb consultaAcordoComercial(Integer idAcordoComercial, Integer idVersaoAcordoComercial);
	
	AcordoComercialDb incluirAcordoComercial(AcordoComercialDb acordoComercialDb);
	
	void verificarSeExisteAcordoComercialAtivo(Integer idParceiro, Integer idProduto, 
			Date dataInicioVigencia, boolean vigenciaIndeterminada, Date dataFimVigencia);
	
	List<AcordoComercialDb> consultaAcordosComerciais();
}
