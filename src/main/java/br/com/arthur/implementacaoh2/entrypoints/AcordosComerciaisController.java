package br.com.arthur.implementacaoh2.entrypoints;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arthur.implementacaoh2.entities.AcordoComercialDb;
import br.com.arthur.implementacaoh2.entities.AcordoComercialId;
import br.com.arthur.implementacaoh2.entities.CanalDisponivelDb;
import br.com.arthur.implementacaoh2.entities.CanalDisponivelId;
import br.com.arthur.implementacaoh2.entities.ContaId;
import br.com.arthur.implementacaoh2.entities.ContaParceiroDb;
import br.com.arthur.implementacaoh2.entities.ContaRepasseDb;
import br.com.arthur.implementacaoh2.entities.ContaRepasseId;
import br.com.arthur.implementacaoh2.entities.MeioPagamentoDb;
import br.com.arthur.implementacaoh2.entities.MeioPagamentoId;
import br.com.arthur.implementacaoh2.entities.SituacaoType;
import br.com.arthur.implementacaoh2.entrypoints.ports.AcordoComercialRepository;

@RestController
@RequestMapping("/acordos_comerciais")
public class AcordosComerciaisController {
	
	private static final Long ID_ACORDO_COMERCIAL = 1L;
	private static final Long ID_VERSAO = 1L;
	private static final Integer ID_PARCEIRO = 1;

	@Autowired AcordoComercialRepository acordoComercialRepository;

	@GetMapping
	public ResponseEntity<?> consulta() {
		return ResponseEntity.ok(acordoComercialRepository.consultaAcordoComercial(new Long(1), new Long(1)));
	}
	
	@GetMapping("/consultar")
	public ResponseEntity<?> consultaFixo() {
		return ResponseEntity.ok(gerarAcordoComercial());
	}
	
	@PostMapping
	public ResponseEntity<AcordoComercialDb> insere() {
		return ResponseEntity.ok(acordoComercialRepository.incluirAcordoComercial(gerarAcordoComercial()));
	}
	
	@PostMapping("/inserir")
	public ResponseEntity<AcordoComercialDb> insere_completo(@RequestBody AcordoComercialDb acordoComercialDb) {
		return ResponseEntity.ok(acordoComercialRepository.incluirAcordoComercial(acordoComercialDb));
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
			.setMeioPagamentoId(new MeioPagamentoId(canalDisponivelId, 1));
		canalDisponivelDb.getMeiosPagamento().get(0).setSituacao(SituacaoType.ATIVO);
		canalDisponivelDb.setIdSituacao(SituacaoType.ATIVO);
		acordoComercialDb.setContasRepasse(new ArrayList<>());
		ContaRepasseDb contaRepasse1 = new ContaRepasseDb();
		contaRepasse1.setContaRepasseId(new ContaRepasseId(acordoComercialId, new ContaParceiroDb(new ContaId(ID_PARCEIRO, 1))));
		contaRepasse1.setPercentualRateio(50.);
		ContaRepasseDb contaRepasse2 = new ContaRepasseDb();
		contaRepasse2.setContaRepasseId(new ContaRepasseId(acordoComercialId, new ContaParceiroDb(new ContaId(ID_PARCEIRO, 2))));
		contaRepasse2.setPercentualRateio(50.);
		acordoComercialDb.getContasRepasse().add(contaRepasse1);
		acordoComercialDb.getContasRepasse().add(contaRepasse2);
		
		return acordoComercialDb;
	}
}
