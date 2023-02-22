package br.com.joaovpiment.torneios.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaovpiment.torneios.dto.ApostadorDTO;
import br.com.joaovpiment.torneios.dto.ResultadoApostaDTO;
import br.com.joaovpiment.torneios.dto.SorteioDTO;
import br.com.joaovpiment.torneios.dto.TorneioDTO;
import br.com.joaovpiment.torneios.dto.enums.Status;
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
	public ResponseEntity<Object> criarTorneio(/**@RequestBody TorneioDTO dto**/) {
		SorteioDTO sorteio = loteria.getUltimoSorteio("megasena", "aJPDxxBDBGVyJMC", "2165");


		ApostadorDTO apostadorDTO = new ApostadorDTO();
		apostadorDTO.setNome("joao");
		apostadorDTO.setDezenas(List.of("05", "08", "32", "59", "41", "15"));
		ApostadorDTO apostadorDTO2 = new ApostadorDTO();
		apostadorDTO.setNome("joao2");
		apostadorDTO.setDezenas(List.of("22", "36", "43", "12", "11", "25"));
		ApostadorDTO apostadorDTO3 = new ApostadorDTO();
		apostadorDTO.setNome("joao3");
		apostadorDTO.setDezenas(List.of("58", "23", "45", "11", "21", "06"));

		TorneioDTO dto = new TorneioDTO();
		dto.setDataInicio("15/03/2023");
		dto.setStatus(Status.ABERTO);
		dto.setValorInscricao(new BigDecimal("550").toString());
		dto.setParticipantes(List.of(apostadorDTO, apostadorDTO2, apostadorDTO3));


		return ResponseEntity.
				//				ok(UUIDJavaType.INSTANCE);
				ok(dto);
	}

	@GetMapping("/sorteio")
	public ResponseEntity<SorteioDTO> listaSorteios() {
		SorteioDTO sorteio = loteria.getUltimoSorteio("megasena", "aJPDxxBDBGVyJMC", "2165");

		return ResponseEntity.ok(sorteio);
	}

}
