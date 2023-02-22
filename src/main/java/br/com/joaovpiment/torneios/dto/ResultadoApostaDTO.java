package br.com.joaovpiment.torneios.dto;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class ResultadoApostaDTO {

	private String nomeApostador;
	private Map<String, String> aposta;

	public ResultadoApostaDTO(ApostadorDTO aposta, SorteioDTO sorteio) {
		this.nomeApostador = aposta.getNome();
		this.aposta = new HashMap<>();
		aposta.getDezenas().forEach(d -> this.aposta.put(d, sorteio.getDezenas().contains(d) ? "acertou" : "errou"));
	}

}
