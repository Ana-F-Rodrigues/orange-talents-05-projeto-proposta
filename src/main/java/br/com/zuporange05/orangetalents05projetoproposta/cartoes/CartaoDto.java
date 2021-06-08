package br.com.zuporange05.orangetalents05projetoproposta.cartoes;

import java.time.LocalDateTime;

import br.com.zuporange05.orangetalents05projetoproposta.proposta.Proposta;
import br.com.zuporange05.orangetalents05projetoproposta.proposta.PropostaRepository;

public class CartaoDto {

	private String id;
	private String titular;
	private LocalDateTime emitidoEm;
	private Integer limite;
	private Long idProposta;

	public String getId() {
		return id;
	}

	public String getTitular() {
		return titular;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public Integer getLimite() {
		return limite;
	}

	public Long getIdProposta() {
		return idProposta;
	}

	public Cartao toModel(PropostaRepository propostaRepository) {

		Proposta proposta = propostaRepository.findById(idProposta).get();
		return new Cartao(id, emitidoEm, titular, limite, proposta);

	}

}
