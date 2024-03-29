package br.com.zuporange05.orangetalents05projetoproposta.cartoes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.zuporange05.orangetalents05projetoproposta.bloqueio.BloqueioDetalhe;
import br.com.zuporange05.orangetalents05projetoproposta.bloqueio.BloqueioDto;
import br.com.zuporange05.orangetalents05projetoproposta.carteira.CarteiraRequest;
import br.com.zuporange05.orangetalents05projetoproposta.carteira.CarteiraResponse;
import br.com.zuporange05.orangetalents05projetoproposta.viagem.ViagemRequest;
import br.com.zuporange05.orangetalents05projetoproposta.viagem.ViagemResponse;

@FeignClient(name="cartao", url="${client.cartao}")
public interface CartaoFeign {
	
	@GetMapping("/api/cartoes")
	CartaoDto buscarCartao(@RequestParam(name="idProposta") Long idProposta);
	

	@PostMapping("api/cartoes/{id}/bloqueios")
    BloqueioDetalhe bloqueioCartao(@PathVariable(name = "id") String numeroCartao, @RequestBody BloqueioDto request);
	
	@PostMapping("/api/cartoes/{id}/avisos")
    ViagemResponse avisoViagem(@PathVariable(name= "id")String idCartao, @RequestBody ViagemRequest request);
	
	@PostMapping("api/cartoes/{id}/carteiras")
    CarteiraResponse adiciona(@PathVariable("id") String id, CarteiraRequest carteira);
}
