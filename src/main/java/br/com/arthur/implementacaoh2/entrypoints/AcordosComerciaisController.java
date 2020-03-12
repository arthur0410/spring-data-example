package br.com.arthur.implementacaoh2.entrypoints;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AcordosComerciaisController.class);

	@Autowired AcordoComercialRepository acordoComercialRepository;

//	@GetMapping
//	public ResponseEntity<?> consulta() {
//		return ResponseEntity.ok(acordoComercialRepository.consultaAcordoComercial(new Long(1), new Long(1)));
//	}
//	
	@GetMapping
	public ResponseEntity<?> consulta() {
		return ResponseEntity.ok(acordoComercialRepository.consultaAcordosComerciais());
	}

	@PostMapping
	public ResponseEntity<AcordoComercialDb> insere(@Valid @RequestBody AcordoComercial acordoComercial) {
		return ResponseEntity.ok(acordoComercialRepository.incluirAcordoComercial(AcordoComercialDb
				.converterParaDb(acordoComercial)));
	}
}
