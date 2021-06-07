package br.com.zuporange05.orangetalents05projetoproposta.proposta;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zuporange05.orangetalents05projetoproposta.validacoes.ApiErrorException;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

	@Autowired
	private PropostaRepository propostaRepository;

	@PostMapping
	public ResponseEntity<PropostaDto> Cadastrar(@RequestBody @Valid PropostaDto propostaDto,
			UriComponentsBuilder uriBuilder) {
		
      if(documentoExiste(propostaDto.getDocumento())) {
    	  
    	  throw new ApiErrorException(HttpStatus.UNPROCESSABLE_ENTITY, "É permitido apenas uma proposta por CPF/CNPJ");
      }
		Proposta proposta = propostaDto.converter(propostaDto);
		proposta = propostaRepository.save(proposta);
		URI uri = uriBuilder.path("/propostas/{id}").build(proposta.getId());
		return ResponseEntity.created(uri).build();

	}
	
	private boolean documentoExiste(String documento){
		return propostaRepository.findByDocumento(documento).isPresent();
	}

}
