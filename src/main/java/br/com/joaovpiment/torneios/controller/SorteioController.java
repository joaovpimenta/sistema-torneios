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

@RestController
@RequestMapping("/api")
public class SorteioController {

	@Autowired
	private ApiLoteriasClient loteria;

	@PostMapping("/sorteio")
	public ResponseEntity<Object> checaAposta(@RequestBody ApostadorDTO aposta) {
		SorteioDTO sorteio = loteria.getUltimoSorteio("megasena", "aJPDxxBDBGVyJMC", "2165");

		return ResponseEntity.ok(new ResultadoApostaDTO(aposta, sorteio));
	}

	@PostMapping("/novo-torneio")
	public ResponseEntity<Object> criarTorneio(@RequestBody TorneioDTO dto) {

		return ResponseEntity.ok(UUID.randomUUID());
	}

	@GetMapping("/sorteios")
	public ResponseEntity<SorteioDTO> listaSorteios() {
		SorteioDTO sorteio = loteria.getUltimoSorteio("megasena", "aJPDxxBDBGVyJMC", "2165");

		return ResponseEntity.ok(sorteio);
	}

	@GetMapping("/sorteio/{concurso}")
	public ResponseEntity<SorteioDTO> listaSorteios(@PathVariable String concurso) {
		SorteioDTO sorteio = loteria.getUltimoSorteio("megasena", "aJPDxxBDBGVyJMC", concurso);

		return ResponseEntity.ok(sorteio);
	}

}
