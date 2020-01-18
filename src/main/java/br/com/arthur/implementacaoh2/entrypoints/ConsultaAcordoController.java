package br.com.arthur.implementacaoh2.entrypoints;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arthur.implementacaoh2.entities.AcordoComercialDb;
import br.com.arthur.implementacaoh2.entities.AcordoComercialId;
import br.com.arthur.implementacaoh2.entities.CanalDisponivelDb;
import br.com.arthur.implementacaoh2.entities.CanalDisponivelId;
import br.com.arthur.implementacaoh2.entities.MeioPagamentoDb;
import br.com.arthur.implementacaoh2.entities.MeioPagamentoId;
import br.com.arthur.implementacaoh2.entities.SituacaoType;
import br.com.arthur.implementacaoh2.entrypoints.ports.AcordoComercialRepository;

@RestController
@RequestMapping("/acordos_comerciais")
public class ConsultaAcordoController {
	
	private static final Long ID_ACORDO_COMERCIAL = new Long(1);
	private static final Long ID_VERSAO = new Long(1);

	@Autowired AcordoComercialRepository acordoComercialRepository;

	@GetMapping
	public ResponseEntity<?> consulta() {
		return ResponseEntity.ok(acordoComercialRepository.consultaAcordoComercial(new Long(1), new Long(1)));
	}
	
	@PostMapping
	public ResponseEntity<AcordoComercialDb> insere() {
		return ResponseEntity.ok(acordoComercialRepository.incluirAcordoComercial(gerarAcordoComercial()));
	}
	
	private AcordoComercialDb gerarAcordoComercial() {
		AcordoComercialDb acordoComercialDb = new AcordoComercialDb();
		AcordoComercialId acordoComercialId = new AcordoComercialId(ID_ACORDO_COMERCIAL, ID_VERSAO);
		acordoComercialDb.setAcordoComercialId(acordoComercialId);
		acordoComercialDb.setIdSituacao(SituacaoType.ATIVO);
		acordoComercialDb.setCanaisDisponiveis(new ArrayList<>());
		CanalDisponivelDb canalDisponivelDb = new CanalDisponivelDb();
		canalDisponivelDb.setIdSituacao(SituacaoType.ATIVO);
		CanalDisponivelId canalDisponivelId = new CanalDisponivelId(acordoComercialId, "C1");
		canalDisponivelDb.setCanalDisponivelId(canalDisponivelId);
		acordoComercialDb.getCanaisDisponiveis().add(canalDisponivelDb);
		canalDisponivelDb.setMeiosPagamento(new ArrayList<>());
		canalDisponivelDb.getMeiosPagamento().add(new MeioPagamentoDb());
		canalDisponivelDb.getMeiosPagamento().get(0)
			.setMeioPagamentoId(new MeioPagamentoId(canalDisponivelId, new Integer(1)));
		canalDisponivelDb.getMeiosPagamento().get(0).setSituacao(SituacaoType.ATIVO);
		canalDisponivelDb.setIdSituacao(SituacaoType.ATIVO);
		return acordoComercialDb;
	}
}
