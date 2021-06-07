package br.com.zuporange05.orangetalents05projetoproposta.proposta;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;



public class PropostaDto {

	@NotBlank
	@CpfOuCnpj
	private String documento;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String endereco;

	@NotNull
	@Positive
	private BigDecimal salario;
	
	private StatusProposta statusProposta;

	public PropostaDto(String documento, String email, String nome, String endereco, BigDecimal salario) {

		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	
	}
	
	public Proposta converter(PropostaDto propostaDto) {

		Proposta proposta = new Proposta(propostaDto.getDocumento(), propostaDto.getEmail(), propostaDto.getNome(),
				propostaDto.getEndereco(), propostaDto.getSalario());

		return proposta;

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


	public StatusProposta getStatusProposta() {
		return this.statusProposta;
	}

}
