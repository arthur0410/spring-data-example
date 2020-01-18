package br.com.arthur.implementacaoh2.entrypoints.ports;

import br.com.arthur.implementacaoh2.entities.AcordoComercialDb;

public interface AcordoComercialRepository {

	AcordoComercialDb consultaAcordoComercial(Long idAcordoComercial, Long idVersaoAcordoComercial); 
}
