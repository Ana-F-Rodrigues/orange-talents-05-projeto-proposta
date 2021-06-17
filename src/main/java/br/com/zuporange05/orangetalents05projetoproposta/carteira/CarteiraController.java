package br.com.zuporange05.orangetalents05projetoproposta.carteira;

import java.net.URI;
import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zuporange05.orangetalents05projetoproposta.cartoes.Cartao;
import br.com.zuporange05.orangetalents05projetoproposta.cartoes.CartaoFeign;
import br.com.zuporange05.orangetalents05projetoproposta.cartoes.CartaoRepository;
import feign.FeignException;
import io.opentracing.Span;
import io.opentracing.Tracer;


@RestController
@RequestMapping("/carteiras")
public class CarteiraController {
	

	@Autowired
	CartaoRepository cartaoRepository;
	
	@Autowired
	CartaoFeign cartaoFeign;
	
//	 @Autowired
	// private Tracer tracer;

	
	@PostMapping("/{id}")
	public ResponseEntity<?> associarCartao(@PathVariable String id,@RequestBody CarteiraRequest carteiraRequest, UriComponentsBuilder builder) {
//	
//		Span activeSpan = tracer.activeSpan();
//		activeSpan.setTag("tag.teste", "testando criacao de tag");
//		activeSpan.setBaggageItem("Teste do bagage", "Qual o propósito do baggage?");
//		activeSpan.log("Log do tracing");
	      
	Optional<Cartao> cartao = cartaoRepository.findByNumeroCartao(id);
		
		
       if(cartao.isPresent()){
    	   try{
    	   
    	   CarteiraResponse responseCarteiraClient = cartaoFeign.adiciona(id, carteiraRequest);
    	   Carteira novaCarteira =  new Carteira(responseCarteiraClient.getId(),carteiraRequest.getEmail(),carteiraRequest.getCarteiraEnum(),cartao.get());
    	   cartao.get().adicionarCarteira(novaCarteira);
    	   cartaoRepository.save(cartao.get());
    	   URI uri = builder.path("/carteiras/{id}/{idCarteira}").build(cartao.get().getId(),responseCarteiraClient.getId());
    	   return ResponseEntity.created(uri).build();
    	 
    	   }catch(FeignException e) {
    		   
    		   return ResponseEntity.status(e.status()).build();
    	   }
       }
        return ResponseEntity.notFound().build();
        
        
	}
   
	
	
}