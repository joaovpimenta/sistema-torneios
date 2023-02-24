package br.com.joaovpiment.torneios.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.joaovpiment.torneios.dto.SorteioDTO;

@FeignClient(name = "loteria-mksoft-client", url = "https://apiloterias.mksoft.com.br/v1")
public interface ApiLoteriasClient {

	@GetMapping
	public SorteioDTO getUltimoSorteio(@RequestParam String sorteio, @RequestParam String key);

	@GetMapping
	public SorteioDTO getSorteioByNumeroConcurso(@RequestParam String sorteio, @RequestParam String key, @RequestParam String concurso);

}
