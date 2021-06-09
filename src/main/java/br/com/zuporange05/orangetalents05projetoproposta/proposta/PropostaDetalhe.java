package br.com.zuporange05.orangetalents05projetoproposta.proposta;

import java.math.BigDecimal;

public class PropostaDetalhe {
	
	
	private String documento;

	private String email;

	private String nome;

	private String endereco;

	private BigDecimal salario;
	
	public PropostaDetalhe(Proposta proposta) {
		

		documento = proposta.getDocumento();
		email = proposta.getEmail();
		nome = proposta.getNome();
		endereco = proposta.getEndereco();
		salario = proposta.getSalario();
	
	}
	
	public String getDocumento() {
		return documento;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}
	
	

}
