package br.com.zuporange05.orangetalents05projetoproposta.cartoes;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.zuporange05.orangetalents05projetoproposta.proposta.Proposta;

@Entity
public class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String numeroCartao;

	private LocalDateTime emitidoEm = LocalDateTime.now();

	private String titular;

	private Integer limite;

	@OneToOne(mappedBy = "cartao")
	private Proposta proposta;

	@Deprecated
	public Cartao() {
	}

	public Cartao(String numeroCartao, LocalDateTime emitidoEm, String titular, Integer limite, Proposta proposta) {

		this.numeroCartao = numeroCartao;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.limite = limite;
		this.proposta = proposta;

	}

	public Long getId() {
		return id;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

	public Integer getLimite() {
		return limite;
	}

	public Proposta getProposta() {
		return proposta;
	}

}
