package br.com.zuporange05.orangetalents05projetoproposta.proposta;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zuporange05.orangetalents05projetoproposta.validacoes.ApiErrorException;
import feign.FeignException.UnprocessableEntity;
import io.opentracing.Span;
import io.opentracing.Tracer;

@RestController
@RequestMapping("/propostas")

public class PropostaController {
	

	 @Autowired
     private Tracer tracer;

	@Autowired
	private PropostaRepository propostaRepository;

	@Autowired
	private ConsultaSwagger consultaSwagger;

	@PostMapping
	public ResponseEntity<PropostaDto> Cadastrar(@RequestBody @Valid PropostaDto propostaDto,
			UriComponentsBuilder uriBuilder) {
		
		Span activeSpan = tracer.activeSpan();
		activeSpan.setTag("tag.teste", "testando criacao de tag");
		activeSpan.setBaggageItem("Teste do bagage", "Qual o propósito do baggage?");
		activeSpan.log("Log do tracing");

		if (documentoExiste(propostaDto.getDocumento())) {
			throw new ApiErrorException(HttpStatus.UNPROCESSABLE_ENTITY,
					"É permitido apenas uma proposta por CPF/CNPJ");
		}
		Proposta proposta = propostaDto.converter(propostaDto);
		proposta = propostaRepository.save(proposta);

		AnalisePropostaDados analisePropostaDados = new AnalisePropostaDados(proposta.getDocumento(),
				proposta.getNome(), proposta.getId());
		try {
			AnaliseProposta analiseProposta = consultaSwagger.analiseProposta(analisePropostaDados);
			proposta.atualizaStatusProposta(StatusProposta.ELEGIVEL);

		} catch (UnprocessableEntity ex) {
			proposta.atualizaStatusProposta(StatusProposta.NAO_ELEGIVEL);
		}

		propostaRepository.save(proposta);
		URI uri = uriBuilder.path("/propostas/{id}").build(proposta.getId());
		return ResponseEntity.created(uri).build();

	}

	private boolean documentoExiste(String documento) {
		return propostaRepository.findByDocumento(documento).isPresent();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PropostaDetalhe> checarProposta(@PathVariable Long id){

		Optional<Proposta> proposta = propostaRepository.findById(id);

		if(proposta.isPresent()) {

			return ResponseEntity.ok(new PropostaDetalhe(proposta.get()));

		}

		return ResponseEntity.notFound().build();
	}

	
	

}
