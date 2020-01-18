package br.com.arthur.implementacaoh2.entrypoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arthur.implementacaoh2.entrypoints.ports.AcordoComercialRepository;

@RestController
public class ConsultaAcordoController {
	
	@Autowired AcordoComercialRepository acordoComercialRepository;

	@GetMapping("/teste")
	public ResponseEntity<?> teste() {
		return ResponseEntity.ok(acordoComercialRepository.consultaAcordoComercial(new Long(1), new Long(1)).convert());
	}
}
