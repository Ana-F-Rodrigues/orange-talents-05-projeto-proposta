package br.com.zuporange05.orangetalents05projetoproposta.proposta;

public class AnalisePropostaDados {

	public String documento;
	public String nome;
	public Long idProposta;
	
	
	public AnalisePropostaDados(String documento, String nome, Long idProposta) {
		super();
		this.documento = documento;
		this.nome = nome;
		this.idProposta = idProposta;
	}
	public String getDocumento() {
		return documento;
	}
	public String getNome() {
		return nome;
	}
	public Long getIdProposta() {
		return idProposta;
	}
	
	
	
	
	
}



