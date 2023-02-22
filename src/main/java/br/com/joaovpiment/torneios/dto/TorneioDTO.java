package br.com.joaovpiment.torneios.dto;

import java.util.List;

import br.com.joaovpiment.torneios.dto.enums.Status;
import lombok.Data;

@Data
public class TorneioDTO {

	Status status;

	List<ApostadorDTO> participantes;

	String dataInicio;

	String valorInscricao;


}
