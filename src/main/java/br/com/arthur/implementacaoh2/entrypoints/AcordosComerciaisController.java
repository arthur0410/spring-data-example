package br.com.arthur.implementacaoh2.entrypoints;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arthur.implementacaoh2.domain.AcordoComercial;
import br.com.arthur.implementacaoh2.entities.AcordoComercialDb;
import br.com.arthur.implementacaoh2.entrypoints.ports.AcordoComercialRepository;

@RestController
@RequestMapping("/acordos_comerciais")
public class AcordosComerciaisController {

	@Autowired AcordoComercialRepository acordoComercialRepository;

	@GetMapping
	public ResponseEntity<?> consulta() {
		return ResponseEntity.ok(acordoComercialRepository.consultaAcordoComercial(new Long(1), new Long(1)));
	}

	@PostMapping
	public ResponseEntity<AcordoComercialDb> insere(@Valid @RequestBody AcordoComercial acordoComercial) {
		acordoComercialRepository.verificarSeExisteAcordoComercialAtivo(1, 1, acordoComercial.getDataInicioVigencia(), 
				acordoComercial.getVigenciaIndeterminada(), acordoComercial.getDataFimVigencia());
		return ResponseEntity.ok(acordoComercialRepository.incluirAcordoComercial(AcordoComercialDb
				.converterParaDb(acordoComercial)));
	}
}
