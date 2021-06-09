package br.com.zuporange05.orangetalents05projetoproposta.proposta;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "${client.analise}", name = "consultaSwagger")
public interface ConsultaSwagger {
	@RequestMapping(value = "/api/solicitacao", method = RequestMethod.POST, consumes = "application/json")
	AnaliseProposta analiseProposta(AnalisePropostaDados analiseProposta);
}
