package br.com.zuporange05.orangetalents05projetoproposta.cartoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.zuporange05.orangetalents05projetoproposta.proposta.Proposta;
import br.com.zuporange05.orangetalents05projetoproposta.proposta.PropostaRepository;
import br.com.zuporange05.orangetalents05projetoproposta.proposta.StatusProposta;
import feign.FeignException;

@Component
public class CartaoScheduler {
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private PropostaRepository propostaRepository;
	
	@Autowired
	private CartaoFeign cartaoFeign;
	
	
	@Deprecated
	public CartaoScheduler() {
	}
	
	@Scheduled(fixedDelay = 1000 * 60)
	public void associaCartaoProposta() {
		
		List<Proposta> propostas = propostaRepository.findByStatusOndeCartaoElegivel(StatusProposta.ELEGIVEL);
	
		for (Proposta proposta : propostas) {
			
			try {
				
				CartaoDto cartaoDto = cartaoFeign.buscarCartao(proposta.getId());
				
				Cartao cartao = cartaoDto.toModel(propostaRepository);
				
			
				
				cartaoRepository.save(cartao);
				
				proposta.setCartao(cartao);
				
				propostaRepository.save(proposta);
				
				System.out.println("Proposta de documento " + proposta.getDocumento() + " e cartao "+ cartaoDto.getId() +" criados com sucesso!");
				
				
			} catch (FeignException e) {
				
				 e.printStackTrace();
				
			}
			
		}
		
	}

}
