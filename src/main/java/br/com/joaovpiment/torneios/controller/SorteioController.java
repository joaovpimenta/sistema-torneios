package br.com.joaovpiment.torneios.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaovpiment.torneios.dto.ApostadorDTO;
import br.com.joaovpiment.torneios.dto.ResultadoApostaDTO;
import br.com.joaovpiment.torneios.dto.SorteioDTO;
import br.com.joaovpiment.torneios.dto.TorneioDTO;
import br.com.joaovpiment.torneios.service.feign.ApiLoteriasClient;
import br.com.joaovpiment.torneios.service.feign.ApiLoteriasClientDEPRECATED;

@RestController
@RequestMapping("/api")
public class SorteioController {

	@Autowired
	private ApiLoteriasClientDEPRECATED deprecated;

	@Autowired
	private ApiLoteriasClient loteria;

	@PostMapping("/sorteio")
	public ResponseEntity<Object> checaAposta(@RequestBody ApostadorDTO aposta) {
		SorteioDTO sorteio = loteria.getSorteioByNumeroConcurso("megasena", "aJPDxxBDBGVyJMC", "2165");

		return ResponseEntity.ok(new ResultadoApostaDTO(aposta, sorteio));
	}

	@PostMapping("/novo-torneio")
	public ResponseEntity<Object> criarTorneio(@RequestBody TorneioDTO dto) {

		return ResponseEntity.ok(UUID.randomUUID());
	}

	@GetMapping("/sorteio/{concurso}")
	public ResponseEntity<?> getSorteio(@PathVariable String concurso) {
		SorteioDTO sorteio = loteria.getSorteioByNumeroConcurso("megasena", "0a216b7800c5223a89c33a7f2460e520", concurso);

		return ResponseEntity.ok(sorteio);
	}

	@GetMapping("/sorteios")
	public ResponseEntity<SorteioDTO> getUltimoSorteio() {
		SorteioDTO sorteio = loteria.getUltimoSorteio("megasena", "0a216b7800c5223a89c33a7f2460e520");

		return ResponseEntity.ok(sorteio);
	}

}
