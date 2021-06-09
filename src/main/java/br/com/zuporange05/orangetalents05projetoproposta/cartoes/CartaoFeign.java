package br.com.zuporange05.orangetalents05projetoproposta.cartoes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="cartao", url="http://localhost:8888")
public interface CartaoFeign {
	
	@GetMapping("/api/cartoes")
	CartaoDto buscarCartao(@RequestParam(name="idProposta") Long idProposta);
	

}