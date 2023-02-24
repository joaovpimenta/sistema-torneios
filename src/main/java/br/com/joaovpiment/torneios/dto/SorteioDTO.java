package br.com.joaovpiment.torneios.dto;

import java.util.List;

import lombok.Data;

@Data
public class SorteioDTO {

	private Integer numero_concurso;
	private String data_concurso;
	List<String> dezenas;
	private String data_proximo_concurso;

}
