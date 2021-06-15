package br.com.zuporange05.orangetalents05projetoproposta.viagem;

import java.time.LocalDate;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zuporange05.orangetalents05projetoproposta.cartoes.Cartao;
import br.com.zuporange05.orangetalents05projetoproposta.cartoes.CartaoFeign;
import br.com.zuporange05.orangetalents05projetoproposta.cartoes.CartaoRepository;
import feign.FeignException;

@RestController
@RequestMapping("/viagem")
public class ViagemController {
	
	private CartaoRepository cartaoRepository;
	private ViagemRepository viagemRepository;
	private CartaoFeign cartaoFeign;
	
	
	
	public ViagemController(CartaoRepository cartaoRepository, ViagemRepository viagemRepository,
			CartaoFeign cartaoFeign) {
		
		this.cartaoRepository = cartaoRepository;
		this.viagemRepository = viagemRepository;
		this.cartaoFeign = cartaoFeign;
		
	}

	@PostMapping("/{id}")
	public ResponseEntity<?> cadastrarAviso(@RequestBody @Valid ViagemRequest request, @PathVariable("id") Long idCartao, HttpServletRequest servletRequest,
            @RequestHeader(value = "User-Agent") String userAgent){
		
		Optional<Cartao> checaCartao = cartaoRepository.findById(idCartao);
		
		if(checaCartao.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		try {
			
			ViagemResponse avisoResponse = cartaoFeign.avisoViagem(checaCartao.get().getNumeroCartao(), request);
			
			viagemRepository.save(new Viagem(checaCartao.get(), request.getDestino(),request.getDataTermino(),servletRequest.getRemoteAddr(),userAgent));
		
			return ResponseEntity.ok("Cadastrado com sucesso");
			
		} catch (FeignException.UnprocessableEntity e) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nao armazenado!");
			
		}
	}

}
