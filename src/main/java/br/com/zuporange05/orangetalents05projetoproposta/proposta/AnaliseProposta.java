package br.com.zuporange05.orangetalents05projetoproposta.proposta;

public class AnaliseProposta {

	public String documento;
	public String nome;
	public Long idProposta;
	public ResultadoSolicitacao resultadoSolicitacao;

	public AnaliseProposta(Proposta proposta) {
		this.documento = proposta.getDocumento();
		this.nome = proposta.getNome();
		this.idProposta = proposta.getId();

	}

	public String getDocumento() {
		return this.documento;
	}

	public String getNome() {
		return this.nome;
	}

	public Long getIdProposta() {
		return this.idProposta;
	}

	public ResultadoSolicitacao getResultadoSolicitacao() {
		return this.resultadoSolicitacao;
	}

	public AnaliseProposta(String documento, String nome, Long idProposta, ResultadoSolicitacao resultadoSolicitacao) {
		this.documento = documento;
		this.nome = nome;
		this.idProposta = idProposta;
		this.resultadoSolicitacao = resultadoSolicitacao;
	}

	
	@Override
	public String toString() {
		return "AnaliseProposta [documento=" + documento + ", nome=" + nome + ", idProposta=" + idProposta
				+ ", resultadoSolicitacao=" + resultadoSolicitacao + ", getDocumento()=" + getDocumento()
				+ ", getNome()=" + getNome() + ", getIdProposta()=" + getIdProposta() + ", getResultadoSolicitacao()="
				+ getResultadoSolicitacao() + "]";
	}

}
