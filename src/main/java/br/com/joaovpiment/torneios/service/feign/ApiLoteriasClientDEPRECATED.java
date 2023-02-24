package br.com.joaovpiment.torneios.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.joaovpiment.torneios.dto.SorteioDTO;

@FeignClient(name = "loteria-client", url = "https://apiloterias.com.br/app/resultado")
public interface ApiLoteriasClientDEPRECATED {

	@GetMapping
	public SorteioDTO getUltimoSorteio(@RequestParam String loteria, @RequestParam String token, @RequestParam String concurso);

}
