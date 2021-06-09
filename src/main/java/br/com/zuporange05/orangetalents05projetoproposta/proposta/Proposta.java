package br.com.zuporange05.orangetalents05projetoproposta.proposta;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.zuporange05.orangetalents05projetoproposta.cartoes.Cartao;



@Entity
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String documento;

	private String email;

	private String nome;

	private String endereco;

	private BigDecimal salario;
	
	@OneToOne
	private Cartao cartao;

	@Enumerated(EnumType.STRING)
	private StatusProposta statusProposta;

	@Deprecated
	public Proposta() {

	}

	public Proposta(String documento, String email, String nome, String endereco, BigDecimal salario) {

		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;

	}

	public Long getId() {

		return id;
	}

	public String getDocumento() {

		return documento;
	}

	public String getNome() {
		return nome;
	}

	public StatusProposta getStatusProposta() {
		return this.statusProposta;
	}

	public void atualizaStatusProposta( StatusProposta restricao){

        this.statusProposta = restricao;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}


}

